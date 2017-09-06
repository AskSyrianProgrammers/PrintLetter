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
        // TODO code application logic here
        do {
            try {
                //TODO: add scanner
                //currently its only support 6 letters [space], A B C D E, if you add any other letter will have NullPointerException Search for TODO:
                //small letter takes same value of capital letter :
                
                print("ABCDEF a b c d e f", 'f');

            } catch (Exception e) {
                System.out.println(e);
            }
            //TODO: change the condition until command exit
        } while (false);

    }

    public static void print(String word, char p)  {
        
        boolean pat[][] = PrintLetter.getWordpattern(word);

        for (boolean[] line : pat) {
            for (boolean c:line) {
                System.out.print(c ? p : " ");
            }
            System.out.println("");
        }
    }

}
