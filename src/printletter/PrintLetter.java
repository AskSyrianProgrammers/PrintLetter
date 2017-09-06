package printletter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amerharb
 */
public class PrintLetter {

    final static int XL = 10; // number of X pixels
    final static int YL = 10; // number of Y pixels, **hint the array will be filled manually 10 by 10 

    final static Map<Character, boolean[][]> LP = new HashMap<>(); //LP is Letter Pattenr 2D array of boolean for spesific char

    static {
        fillLettersPattern();
    }

    private static boolean[][] getLetterPattern(char c){
        if (LP.containsKey(c))
            return LP.get(c);
        else
            return LP.get(' '); // return space, we garantee allways that space is there
    }

    static boolean[][] getWordpattern(String word) {

        boolean wordPattern[][] = new boolean[XL][YL * word.length()];

        boolean ls[][][] = new boolean[word.length()][XL][YL];

        for (int l = 0; l < word.length(); l++) {
            ls[l] = getLetterPattern(word.charAt(l));
        }

        //copy from 3d array to 2d array 
        for (int l = 0; l < word.length(); l++) {
            for (int y = 0; y < XL; y++) {
                for (int x = 0; x < YL; x++) {
                    wordPattern[x][y + (YL * l)] = ls[l][x][y];
                }
            }
        }
        return wordPattern;
    }

    private static void fillLettersPattern() {
        LP.put(' ', getLetterSpace());
        LP.put('-', getLetterDash());
        LP.put('A', getLetterA());
        LP.put('a', getLetterA());
        LP.put('B', getLetterB());
        LP.put('b', getLetterB());
        LP.put('C', getLetterC());
        LP.put('c', getLetterC());
        LP.put('D', getLetterD());
        LP.put('d', getLetterD());
        LP.put('E', getLetterE());
        LP.put('e', getLetterE());
        LP.put('F', getLetterF());
        LP.put('f', getLetterF());

        //TODO: call the rest of the letters
        //....
    }

    private static boolean[][] getLetterSpace() {
        boolean L[][] = new boolean[XL][YL];

        for (int x = 0; x < XL; x++) {
            for (int y = 0; y < YL; y++) {
                L[x][y] = false;
            }
        }
        return L;
    }

    private static boolean[][] getLetterDash() {

        boolean O = false, X = true;
        boolean[][] L = {  
                             {O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{X, X, X, X, X, X, X, X, O, O}
                            ,{X, X, X, X, X, X, X, X, O, O}
                            ,{X, X, X, X, X, X, X, X, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterA() {

        boolean O = false, X = true;
        boolean[][] L = {  
                             {O, O, O, O, X, O, O, O, O, O}
                            ,{O, O, O, X, X, X, O, O, O, O}
                            ,{O, O, X, X, O, X, X, O, O, O}
                            ,{O, X, X, O, O, O, X, X, O, O}
                            ,{X, X, O, O, O, O, O, X, X, O}
                            ,{X, X, O, O, O, O, O, X, X, O}
                            ,{X, X, X, X, X, X, X, X, X, O}
                            ,{X, X, X, X, X, X, X, X, X, O}
                            ,{X, X, O, O, O, O, O, X, X, O}
                            ,{X, X, O, O, O, O, O, X, X, O}
                        };
        return L;
    }

    private static boolean[][] getLetterB() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {X, X, X, X, X, O, O, O, O, O}
                            ,{X, X, X, X, X, X, O, O, O, O}
                            ,{X, X, O, O, O, X, X, O, O, O}
                            ,{X, X, O, O, O, X, X, O, O, O}
                            ,{X, X, X, X, X, X, O, O, O, O}
                            ,{X, X, X, X, X, X, O, O, O, O}
                            ,{X, X, O, O, O, X, X, O, O, O}
                            ,{X, X, O, O, O, X, X, O, O, O}
                            ,{X, X, X, X, X, X, O, O, O, O}
                            ,{X, X, X, X, X, O, O, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterC() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {O, O, X, X, X, X, X, O, O, O}
                            ,{O, X, X, X, X, X, X, O, O, O}
                            ,{X, X, X, O, O, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O, O, O, O}
                            ,{X, X, X, O, O, O, O, O, O, O}
                            ,{O, X, X, X, X, X, X, O, O, O}
                            ,{O, O, X, X, X, X, X, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterD() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X, O, O, O, O}
                            ,{X, X, X, X, X, X, X, O, O, O}
                            ,{X, X, O, O, X, X, X, X, O, O}
                            ,{X, X, O, O, O, X, X, X, O, O}
                            ,{X, X, O, O, O, O, X, X, O, O}
                            ,{X, X, O, O, O, O, X, X, O, O}
                            ,{X, X, O, O, O, X, X, X, O, O}
                            ,{X, X, O, O, X, X, X, X, O, O}
                            ,{X, X, X, X, X, X, X, O, O, O}
                            ,{X, X, X, X, X, X, O, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterE() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterF() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, X, X, X, X, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O, O}
                        };
        return L;
    }

    //TODO: do the rest letters ....X Y Z
    //...
    private static boolean[][] getLetterRandom() {

        boolean L[][] = new boolean[XL][YL];

        for (int i = 0; i < XL; i++) {
            for (int j = 0; j < YL; j++) {
                L[i][j] = getRandomBoolean();
            }
        }
        return L;
    }

    private static boolean getRandomBoolean() {
        if (Math.random() > 0.5) {
            return true;
        } else {
            return false;
        }
    }

}
