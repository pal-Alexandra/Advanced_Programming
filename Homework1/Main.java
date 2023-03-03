/**
 *  * @author Pal Alexandra
 * Aceasta clasa este cea principala.
 */
public class Main {
    public static void main(String[] args) {

        //Display on the screen message << Hello World! >>
        System.out.println("Hello World!");

        //Define an array of strings languages
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        //Generate a random integer n
        int n = (int) (Math.random() * 1_000_000);

        //Compute the result obtained after performing the following calculations
        //multiply n by 3;
        n = n * 3;

        //add the binary number 10101 to the result;
        n = n + convertBinaryToDecimal("10101");

        //add the hexadecimal number FF to the result;
        String hex = "FF";
        int value = Integer.parseInt(hex, 16);
        n = n + value;

        //multiply the result by 6;
        n = n * 6;

        while (n >= 10){
            int sum = 0;
            while(n != 0){
                sum = sum + n%10;
                n= n/10;
            }
            n = sum;
        }

        //Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }

    /**
     * This method convert a binary number into its decimal value
     * @param no - a number in binary
     * @return rez - the number in decimal coresponing to no
     */
    public static int convertBinaryToDecimal(String no) {
        int rez = 0;
        int i;
        for (i = no.length()-1; i >= 0; i--) {
            if (Character.compare(no.charAt(i), '1') == 0) {
                rez = (int) (rez + Math.pow(2, no.length() - i));
            }
        }
        return rez;
    }
}