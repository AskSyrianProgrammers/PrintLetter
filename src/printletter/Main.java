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

                //print the word using '#'
                print("ABCDEFG a b-cf", '#');
                System.out.println();

                //print the word using each letter shape
                printWithSameChar("ABCDEFG a b-d e f");

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
