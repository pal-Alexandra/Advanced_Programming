
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //reading n (integer) && validate it
        Scanner cin = new Scanner(System.in);
        System.out.println("Introduce n (integer): ");
        int n;
        if (cin.hasNextInt()){
            n = cin.nextInt();
        }else{
            System.out.print("Invalid input \n");
            n = 0;
            System.exit(-1);
        }

        System.out.print("Input: " + n + "\n");

        //for computation of the running time
        long millis_startTime = System.currentTimeMillis();

        //declaring the matrix
        int[][] square = new int[n][n];
        //creating the latin Matrix for n
        square = latinSquare(n);
        if(n < 30_000){
            printLatinSquare(square);
            System.out.print("\n");
        }

        //For each line, and each column of the matrix, create and display on the screen String objects representing the concatenation of the symbols in the respective line or column
        buildStringObjForLine(square, n);
        System.out.print("\n");
        buildStringObjForColumn(square, n);

        if(n >= 30_000){
            long millis_endTime = System.currentTimeMillis();

            System.out.println("The running time is: " + (millis_endTime - millis_startTime));
        }
    }

    /**
     * This method creates a latin Square of size n
     * @param n - is the number of lines/columns of the latinSquare
     * @return mat - the matrix of the latinSquare containing the symbols from 1 -> n
     */
    public static int[][] latinSquare(int n){
        int [][] mat = new int[n][n];
        int rotation = 1;
        int i, j;
        for(i=0; i<n; i++) {
            int k = 1;
            for(j=rotation; j<n; j++)
                mat[i][j] = k++;

            for(j=0;j<rotation;j++)
                mat[i][j] = k++;
            rotation++;
        }
        return mat;
    }

    /**
     * This method prints the parameter (a matrix)
     * @param mat - a latinSquare (matrix)
     */
    public static void printLatinSquare(int [][] mat){
        System.out.println("Your Latin Square is:");
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println();
        }
    }

    /**
     * This method create and display on the screen String objects representing the concatenation of the symbols of each line
     * @param mat - a latinSquare (matrix)
     * @param matL - the size of the matrix
     */
    public static void buildStringObjForLine(int [][] mat, int matL){
        int i, j;
        for(i=0; i< mat.length; i++) {

            StringBuilder str = new StringBuilder();
            for (j = 0; j < mat.length; j++) {
                String s = String.valueOf(mat[i][j]);
                str.append(s);
            }
            if(matL < 30_000)
                System.out.println("The String_obj for line: " + i + " is: " + str);
        }
    }

    /**
     * This method create and display on the screen String objects representing the concatenation of the symbols of each column
     * @param mat - a latinSquare (matrix)
     * @param matL - the size of the matrix
     */
    public static void buildStringObjForColumn(int [][] mat, int matL) {
        int i, j;
        for (j = 0; j < mat.length; j++) {

            StringBuilder str = new StringBuilder();
            for (i = 0; i < mat.length; i++) {
                String s = String.valueOf(mat[i][j]);
                str.append(s);
            }
            if (matL < 30_000)
                System.out.println("The String_obj for column: " + j + " is: " + str);
        }
    }
}