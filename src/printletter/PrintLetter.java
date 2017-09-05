package printletter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amerharb
 */
public class PrintLetter {

    final static int NoL = 27; // number of letters 0 = Space, 1 = A, 2 = B, 3 = C ...etc
    final static int XL = 10; // number of X pixels
    final static int YL = 10; // number of Y pixels, **hint the array will be filled manually 10 by 10 

    final static boolean[][][] LetterPattern = new boolean[NoL][][];
    final static Map<Character, Integer> LN = new HashMap<>(); //Letter Number it give the number for spesific char

    static {
        fillLettersNumberValue();
        fillLettersPattern();
    }

    private static int getLN(char c) {
        return LN.get(c); 
    }

    private static boolean[][] getLetter(char c){
        return LetterPattern[getLN(c)];
    }

    static boolean[][] getWordpattern(String word) {

        boolean wordPattern[][] = new boolean[XL][YL * word.length()];

        boolean ls[][][] = new boolean[word.length()][XL][YL];

        for (int l = 0; l < word.length(); l++) {
            ls[l] = getLetter(word.charAt(l));
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

    //Fill array of pattern 3Dimention Array 1- number of the letter from 0 to 25 (A-Z). 2- X of  
    private static void fillLettersNumberValue() {

        LN.put(' ', 0);
        LN.put('A', 1);
        LN.put('B', 2);
        LN.put('C', 3);
        LN.put('D', 4);
        LN.put('E', 5);
        LN.put('F', 6);
        LN.put('G', 7);
        LN.put('H', 8);
        LN.put('I', 9);
        LN.put('J', 10);
        LN.put('K', 11);
        LN.put('L', 12);
        LN.put('M', 13);
        LN.put('N', 14);
        LN.put('O', 15);
        LN.put('P', 16);
        LN.put('Q', 17);
        LN.put('R', 18);
        LN.put('S', 19);
        LN.put('T', 20);
        LN.put('U', 21);
        LN.put('V', 22);
        LN.put('W', 23);
        LN.put('X', 24);
        LN.put('Y', 25);
        LN.put('Z', 26);

        //give the value of the small letter same of capital letter untill support the small letter with diffreant number 
        LN.put('a', 1);
        LN.put('b', 2);
        LN.put('c', 3);
        LN.put('d', 4);
        LN.put('e', 5);
        LN.put('f', 6);
        LN.put('g', 7);
        LN.put('h', 8);
        LN.put('i', 9);
        LN.put('j', 10);
        LN.put('k', 11);
        LN.put('l', 12);
        LN.put('m', 13);
        LN.put('n', 14);
        LN.put('o', 15);
        LN.put('p', 16);
        LN.put('q', 17);
        LN.put('r', 18);
        LN.put('s', 19);
        LN.put('t', 20);
        LN.put('u', 21);
        LN.put('v', 22);
        LN.put('w', 23);
        LN.put('x', 24);
        LN.put('y', 25);
        LN.put('z', 26);
    }

    private static void fillLettersPattern() {
        LetterPattern[getLN(' ')] = getLetterSpace();
        LetterPattern[getLN('A')] = getLetterA();
        LetterPattern[getLN('B')] = getLetterB();
        LetterPattern[getLN('C')] = getLetterC();
        LetterPattern[getLN('D')] = getLetterD();
        LetterPattern[getLN('E')] = getLetterE();
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
                             {X, X, X, X, O, O, O, O, O, O}
                            ,{X, X, X, X, X, O, O, O, O, O}
                            ,{X, X, O, O, X, X, O, O, O, O}
                            ,{X, X, O, O, X, X, O, O, O, O}
                            ,{X, X, X, X, X, O, O, O, O, O}
                            ,{X, X, X, X, X, O, O, O, O, O}
                            ,{X, X, O, O, X, X, O, O, O, O}
                            ,{X, X, O, O, X, X, O, O, O, O}
                            ,{X, X, X, X, X, O, O, O, O, O}
                            ,{X, X, X, X, O, O, O, O, O, O}
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
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O, O, O}                        
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

    //TODO: do the rest letters E - Z
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
