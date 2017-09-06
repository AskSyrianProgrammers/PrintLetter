/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printletter;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        do {
            try {
                //TODO: add scanner
                //currently its only support few letters [space], A B C D E,... if you add any other letter will have char=0 [Space] instead
                //Search for "//TODO:" to suuport other letters 
                //small letter takes same value of capital letter :

                //print the word using '*'
                print("ABCDEF a b-d?e f", '*');
                System.out.println();
                
                //print the word using each letter shape
                printWithSameChar("ABCDEF a b-d e f");

            } catch (Exception e) {
                System.out.println(e);
            }
            //TODO: change the condition until command exit
        } while (false);

    }

    public static void printWithSameChar(String word) {
        boolean pat[][] = PrintLetter.getWordpattern(word);

        //assuming all char comes at the same width
        int cw = pat[0].length / word.length();
 
        for (boolean[] line : pat) {
            int i = 0;
            for (boolean c : line) {
                System.out.print(c ? word.charAt(i/cw) : ' ');
                i++;
            }
            System.out.println();
        }
    
    }

    public static void print(String word, char p) {

        boolean pat[][] = PrintLetter.getWordpattern(word);

        for (boolean[] line : pat) {
            for (boolean c : line) {
                System.out.print(c ? p : ' ');
            }
            System.out.println();
        }
    }

}
