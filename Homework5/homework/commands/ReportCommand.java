package org.homework.commands;

/**
 * @author Pal Alexandra
 * This class describe the command report from the Document Management System
 */

import freemarker.template.TemplateException;
import org.homework.system.Catalog;
import org.homework.system.Document;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Template;


public class ReportCommand extends Command {

    /**
     * This is the constructor of the class
     *
     * @param command: sets the name of the command
     * @param catalog: sets the Catalog object that will be processed
     */
    public ReportCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    /**
     * This method creates (and opens) an HTML report representing the content of a Catalog object
     *
     * @param catalog: the Catalog object that will be processed
     * @throws IOException
     */
    public static void report(Catalog catalog) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setDirectoryForTemplateLoading(new File("templates"));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


        Template template = cfg.getTemplate("raport.html");

        Map<String, Object> report = new HashMap<>();

        report.put("name", catalog.getName());
        report.put("documents", catalog.getDocs());

        Writer fileWriter = new FileWriter("reports\\" + catalog.getName() + " report.html");
        try {
            template.process(report, fileWriter);
        } catch (IOException | TemplateException e) {
            System.out.println(e.getMessage());
        } finally {
            fileWriter.close();
        }

        //Opening the report
        Document document = new Document(catalog.getName() + " report", UUID.randomUUID().toString());
        document.setLocation("reports\\" + catalog.getName() + " report.html");
        File file = new File(document.getLocation());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }


}
