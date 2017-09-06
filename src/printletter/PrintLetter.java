package printletter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amerharb
 */
public class PrintLetter {

    final static int defaultX = 10;
    final static int defaultY = 10;
    
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

    private static char[][] convertBoolToChar(boolean b[][], char c){
        
        char[][] r = new char[b.length][];
        
        for (int y = 0; y < b.length; y++) {
            r[y] = new char[b[y].length];
            for (int x = 0; x < b[y].length; x++) {
                if (b[y][x])
                    r[y][x] = c;
                else
                    r[y][x] = ' ';
            }
        }
        return r;
    }
    
    static char[][] getWordpatternChar(String word) {
        int maxY = 0, totalX = 0;
        
        char ls[][][] = new char[word.length()][][];

        for (int l = 0; l < word.length(); l++) {
            char[][] lp;
            
            lp = convertBoolToChar(getLetterPattern(word.charAt(l)),word.charAt(l));

            ls[l] = lp;
            if (maxY < lp.length)
                maxY = lp.length;
            totalX += lp[0].length;
        }
        
        char wordPatternChar[][] = new char[maxY][totalX];

        //copy from 3d array to 2d array
        int letterX = 0;
        for (int l = 0; l < word.length(); l++) {
            int y;
            for (y = 0; y < ls[l].length; y++) {
                int x;
                for (x = 0; x < ls[l][y].length; x++) {
                    wordPatternChar[y][letterX + x] = ls[l][y][x];
                }
            }
            for (; y < maxY; y++) {
                for (int x = 0; x < ls[l][0].length; x++) {
                    wordPatternChar[y][letterX + x] = ' ';
                }
            }
            letterX += ls[l][0].length;
        }
        return wordPatternChar;

    }

    static boolean[][] getWordpattern(String word) {

        int maxY = 0, totalX = 0;
        
        boolean ls[][][] = new boolean[word.length()][][];

        for (int l = 0; l < word.length(); l++) {
            boolean[][] lp;
            
            lp = getLetterPattern(word.charAt(l));
            ls[l] = lp;
            if (maxY < lp.length)
                maxY = lp.length;
            totalX += lp[0].length;
        }
        
        boolean wordPattern[][] = new boolean[maxY][totalX];

        //copy from 3d array to 2d array
        int letterX = 0;
        for (int l = 0; l < word.length(); l++) {
            int y;
            for (y = 0; y < ls[l].length; y++) {
                int x;
                for (x = 0; x < ls[l][y].length; x++) {
                    wordPattern[y][letterX + x] = ls[l][y][x];
                }
            }
            for (; y < maxY; y++) {
                for (int x = 0; x < ls[l][0].length; x++) {
                    wordPattern[y][letterX + x] = false;
                }
            }
            letterX += ls[l][0].length;
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
        boolean L[][] = new boolean[defaultY][defaultX];

        for (boolean[] l:L){
            for(boolean b:l){
                b = false;
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

        boolean L[][] = new boolean[defaultX][defaultY];

        for (int x = 0; x < defaultX; x++) {
            for (int y = 0; y < defaultY; y++) {
                L[x][y] = getRandomBoolean();
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
