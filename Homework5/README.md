## General info
This folder contains the solution for compulsory exercices from the fifth homework. Solved/ unsolved tasks are checkmarked (:smile: / :confused:).

# The problem

Document Management System

Write an application that can manage a catalog of documents. An entry in this catalog might be an article, a book, etc.
A document may be located using a path in the local file system or a link to an external URL. Each document has a unique ID, a name and may have additional tags, which are pairs name-value. Example of tags may be title, author, year, publishingDate, etc.

## Tasks
  * :smile: Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command;
  * :smile: Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.)
    * :smile: list: prints the list of documents on the screen;
    * :smile: view: opens a document using the native operating system application;
    * :smile: report: creates (and opens) an HTML report representing the content of the catalog;
  * :smile: The application will signal invalid data or the commands that are not valid using custom exceptions.
