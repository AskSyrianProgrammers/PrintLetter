package printletter;

import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        print("ABCDEFGKLMNOP",'¤');
        do {
            try {
                //currently its only support few letters [space], A B C D E,... if you add any other letter will have char=0 [Space] instead
                //Search for "//TODO:" to suuport other letters 
                //small letter takes same value of capital letter, in case want to support both see how letter I and i are supported
                
                Scanner sc = new Scanner(System.in);

                System.out.print(">");
                String word = sc.nextLine();
                if (word.equals("exit")){
                    System.exit(0);
                }
                //print the word using '#'
                //String word = "ABCDEFGHIiJKLMNOPQRSTUVWXYZ";
                print(word, '#');
                System.out.println();

                //print the word using each letter shape
                printWithSameChar(word);

            } catch (Exception e) {
                System.out.println(e);
            }
            //TODO: change the condition until command exit
        } while (true);

    }

    public static void printWithSameChar(String word) {

        char pat[][] = PrintLetter.getWordpatternChar(word);
        for (char[] line : pat) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void print(String word, char c) {

        boolean pat[][] = PrintLetter.getWordpattern(word);
        for (boolean[] line : pat) {
            for (boolean b : line) {
                System.out.print(b ? c : ' ');
            }
            System.out.println();
        }
    }

}
