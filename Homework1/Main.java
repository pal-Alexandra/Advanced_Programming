
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
        long millisStartTime = System.currentTimeMillis();

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
            long millisEndTime = System.currentTimeMillis();

            System.out.println("The running time is: " + (millisEndTime - millisStartTime));
        }
    }

    /**
     * This method creates a latin Square of size "size"
     * @param size - is the number of lines/columns of the latinSquare
     * @return mat - the matrix of the latinSquare containing the symbols from 1 -> n
     */
    public static int[][] latinSquare(int size){
        int [][] mat = new int[size][size];
        int rotation = 1;
        int i, j;
        for(i=0; i<size; i++) {
            int symbol = 1;
            for(j=rotation; j<size; j++)
                mat[i][j] = symbol++;

            for(j=0;j<rotation;j++)
                mat[i][j] = symbol++;
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
     * @param matLen - the size of the matrix
     */
    public static void buildStringObjForLine(int [][] mat, int matLen){
        int i, j;
        for(i=0; i< mat.length; i++) {

            StringBuilder strObj = new StringBuilder();
            for (j = 0; j < mat.length; j++) {
                String s = String.valueOf(mat[i][j]);
                strObj.append(s);
            }
            if(matLen < 30_000)
                System.out.println("The String_obj for line: " + i + " is: " + strObj);
        }
    }

    /**
     * This method create and display on the screen String objects representing the concatenation of the symbols of each column
     * @param mat - a latinSquare (matrix)
     * @param matLen - the size of the matrix
     */
    public static void buildStringObjForColumn(int [][] mat, int matLen) {
        int i, j;
        for (j = 0; j < mat.length; j++) {

            StringBuilder strObj = new StringBuilder();
            for (i = 0; i < mat.length; i++) {
                String s = String.valueOf(mat[i][j]);
                strObj.append(s);
            }
            if (matLen < 30_000)
                System.out.println("The String_obj for column: " + j + " is: " + strObj);
        }
    }
}