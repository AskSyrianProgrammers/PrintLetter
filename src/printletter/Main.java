package printletter;

import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        int newLine = 0;
        for (int i = 9600; i < 9999; i++) {
            if (true) {
                newLine++;
                if (newLine == 200) {
                    System.out.println("");
                    newLine = 0;
                }
                System.out.print((char) i);
            }
        }
        System.out.println("");
        
        print("ABCDEFGHIJKLMNOPQRSTUVWXYZ", '\u2591', '\u2592');
        System.out.println("");
        print("abcdefghijklmnopqrstuvwxyz", '\u2591', '\u2592');
        do {
            try {
                //currently its only support few letters [space], A B C D E,... if you add any other letter will have char=0 [Space] instead
                //Search for "//TODO:" to suuport other letters 
                //small letter takes same value of capital letter, in case want to support both see how letter I and i are supported

                Scanner sc = new Scanner(System.in);
                
                System.out.print(">");
                String word = "";//sc.nextLine();
                if (word.equals("exit")) {
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
        } while (false);

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

    public static void print(String word, char c, char bg) {
        boolean pat[][] = PrintLetter.getWordpattern(word);
        for (boolean[] line : pat) {
            for (boolean b : line) {
                System.out.print(b ? c : bg);
            }
            System.out.println();
        }
    }

    public static void print(String word, char c) {
        print(word, c, ' ');
    }

    public static void print(String word) {
        print(word, '#', ' ');
    }

}
