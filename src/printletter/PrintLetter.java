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
    final static byte DEF_HOR_LETTER_MAGRIN = 2;
    
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
        final byte DEF_HOR_LETTER_MAGRIN = 2;
        return getWordpatternChar(word,DEF_HOR_LETTER_MAGRIN);
    }

    static char[][] getWordpatternChar(String word, byte letterMargin) {
        int maxY = 0, totalX = 0;
        
        char ls[][][] = new char[word.length()][][];

        for (int l = 0; l < word.length(); l++) {
            char[][] lp;
            
            lp = convertBoolToChar(getLetterPattern(word.charAt(l)),word.charAt(l));

            ls[l] = lp;
            if (maxY < lp.length)
                maxY = lp.length;
            totalX += lp[0].length + letterMargin;
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
                //add margin
                for (; x < ls[l][y].length + letterMargin; x++) {
                    wordPatternChar[y][letterX + x] = Character.SPACE_SEPARATOR;
                }    
            }
            for (; y < maxY; y++) {
                for (int x = 0; x < ls[l][0].length + letterMargin; x++) {
                    wordPatternChar[y][letterX + x] = Character.SPACE_SEPARATOR;
                }
            }
            letterX += ls[l][0].length + letterMargin;
        }
        return wordPatternChar;

    }

    static boolean[][] getWordpattern(String word) {
        return getWordpattern(word, DEF_HOR_LETTER_MAGRIN);
    }

    static boolean[][] getWordpattern(String word, byte letterMargin) {
        
        int maxY = 0, totalX = 0;
        
        boolean ls[][][] = new boolean[word.length()][][];

        for (int l = 0; l < word.length(); l++) {
            boolean[][] lp;
            
            lp = getLetterPattern(word.charAt(l));
            ls[l] = lp;
            if (maxY < lp.length)
                maxY = lp.length;
            totalX += lp[0].length + letterMargin;
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
                //add margin //in fact no need to run this block as the init value of the array is already false
                for (; x < ls[l][y].length + letterMargin; x++) {
                    wordPattern[y][letterX + x] = false;
                }    
            }
            //in fact no need to run this block as the init value of the array is already false
            for (; y < maxY; y++) {
                for (int x = 0; x < ls[l][0].length + letterMargin; x++) {
                    wordPattern[y][letterX + x] = false;
                }
            }
            letterX += ls[l][0].length + letterMargin;
        }
        return wordPattern;
    }

    private static void fillLettersPattern() {
        LP.put(' ', getLetterSpace());
        LP.put('-', getLetterDash());
        LP.put('A', getLetterA());
        LP.put('B', getLetterB());
        LP.put('C', getLetterC());
        LP.put('D', getLetterD());
        LP.put('E', getLetterE());
        LP.put('F', getLetterF());
        LP.put('G', getLetterG());
        LP.put('H', getLetterH());
        LP.put('I', getLetterI());
        LP.put('J', getLetterJ());
        LP.put('K', getLetterK());
        LP.put('L', getLetterL());
        LP.put('M', getLetterM());
        LP.put('N', getLetterN());
        LP.put('O', getLetterO());
        LP.put('P', getLetterP());
        LP.put('Q', getLetterQ());
        LP.put('R', getLetterR());
        LP.put('S', getLetterS());
        LP.put('T', getLetterT());
        LP.put('U', getLetterU());
        LP.put('V', getLetterV());
        LP.put('W', getLetterW());
        LP.put('X', getLetterX());
        LP.put('Y', getLetterY());
        LP.put('Z', getLetterZ());
        LP.put('a', getLettera());
        LP.put('b', getLetterb());
        LP.put('c', getLetterc());
        LP.put('d', getLetterd());
        LP.put('e', getLettere());
        LP.put('f', getLetterf());
        LP.put('g', getLetterg());
        LP.put('h', getLetterh());
        LP.put('i', getLetteri());
        LP.put('j', getLetterj());
        LP.put('k', getLetterk());
        LP.put('l', getLetterl());
        LP.put('m', getLetterm());
        LP.put('n', getLettern());
        LP.put('o', getLettero());
        LP.put('p', getLetterp());
        LP.put('q', getLetterq());
        LP.put('r', getLetterr());
        LP.put('s', getLetters());
        LP.put('t', getLettert());
        LP.put('u', getLetteru());
        LP.put('v', getLetterv());
        LP.put('w', getLetterw());
        LP.put('x', getLetterx());
        LP.put('y', getLettery());
        LP.put('z', getLetterz());
        //TODO: add the new charchter 
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
                             {O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O}
                            ,{X, X, X, X, X, X, X, X}
                            ,{X, X, X, X, X, X, X, X}
                            ,{X, X, X, X, X, X, X, X}
                            ,{O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O}
                            ,{O, O, O, O, O, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterA() {
        boolean O = false, X = true;
        boolean[][] L = {  
                             {O, O, O, X, O, O, O}
                            ,{O, O, X, X, X, O, O}
                            ,{O, X, X, O, X, X, O}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, X, X, X, X, X}
                            ,{X, X, X, X, X, X, X}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X}
                        };
        return L;

    }

    private static boolean[][] getLetterB() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {X, X, X, X, X, O, O}
                            ,{X, X, X, X, X, X, O}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, X, X, X, X, O}
                            ,{X, X, X, X, X, X, O}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X}
                            ,{X, X, X, X, X, X, O}
                            ,{X, X, X, X, X, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterC() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {O, O, X, X, X, X, X}
                            ,{O, X, X, X, X, X, X}
                            ,{X, X, X, O, O, O, O}
                            ,{X, X, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O}
                            ,{X, X, O, O, O, O, O}
                            ,{X, X, X, O, O, O, O}
                            ,{O, X, X, X, X, X, X}
                            ,{O, O, X, X, X, X, X}
                        };
        return L;
    }

    private static boolean[][] getLetterD() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {X, X, X, X, X, X, O, O}
                            ,{X, X, X, X, X, X, X, O}
                            ,{X, X, O, O, X, X, X, X}
                            ,{X, X, O, O, O, X, X, X}
                            ,{X, X, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X, X}
                            ,{X, X, O, O, X, X, X, X}
                            ,{X, X, X, X, X, X, X, O}
                            ,{X, X, X, X, X, X, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterE() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X}
                           ,{X, X, X, X, X, X}
                           ,{X, X, O, O, O, O}
                           ,{X, X, O, O, O, O}
                           ,{X, X, X, X, X, X}
                           ,{X, X, X, X, X, X}
                           ,{X, X, O, O, O, O}
                           ,{X, X, O, O, O, O}
                           ,{X, X, X, X, X, X}
                           ,{X, X, X, X, X, X}
                        };
        return L;
    }

    private static boolean[][] getLetterF() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X,}
                           ,{X, X, X, X, X, X,}
                           ,{X, X, O, O, O, O,}
                           ,{X, X, O, O, O, O,}
                           ,{X, X, X, X, X, X,}
                           ,{X, X, X, X, X, X,}
                           ,{X, X, O, O, O, O,}
                           ,{X, X, O, O, O, O,}
                           ,{X, X, O, O, O, O,}
                           ,{X, X, O, O, O, O,}
                        };
        return L;
    }

    private static boolean[][] getLetterG() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {O, O, X, X, X, X, O, O, O}
                           ,{O, X, X, X, X, X, O, O, O}
                           ,{X, X, X, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O, O, O}
                           ,{X, X, O, O, O, X, X, X, X}
                           ,{X, X, O, O, O, X, X, X, X}
                           ,{X, X, X, O, O, O, X, X, O}
                           ,{O, X, X, X, X, X, X, X, O}
                           ,{O, O, X, X, X, X, X, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterH() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, X, X, X, X, X}
                           ,{X, X, X, X, X, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}                        
                        };
        return L;
    }

    private static boolean[][] getLetterI() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X,X, X}
                           ,{X, X,X, X}
                           ,{O, X,X, O}
                           ,{O, X,X, O}
                           ,{O, X,X, O}
                           ,{O, X,X, O}
                           ,{O, X,X, O}
                           ,{O, X,X, O}
                           ,{X, X,X, X}
                           ,{X, X,X, X}                        
        };
        return L;
    }

    private static boolean[][] getLetterJ() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {O, O, O, O, O, X, X}
                           ,{O, O, O, O, O, X, X}
                           ,{O, O, O, O, O, X, X}
                           ,{O, O, O, O, O, X, X}
                           ,{O, O, O, O, O, X, X}
                           ,{O, O, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X}
                           ,{X, X, X, X, X, X, X}
                           ,{O, X, X, X, X, X, O}                                };
        return L;
    }

    private static boolean[][] getLetterK() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, O, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X, O}
                           ,{X, X, O, O, X, X, O, O}
                           ,{X, X, O, X, X, O, O, O}
                           ,{X, X, X, X, O, O, O, O}
                           ,{X, X, X, X, O, O, O, O}
                           ,{X, X, O, X, X, O, O, O}
                           ,{X, X, O, O, X, X, O, O}
                           ,{X, X, O, O, O, X, X, O}
                           ,{X, X, O, O, O, O, X, X}                                
                        };
        return L;
    }

    private static boolean[][] getLetterL() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, O, O, O, O, O}
                           ,{X, X, X, X, X, X, X}
                           ,{X, X, X, X, X, X, X}                       
        };
        return L;
    }

    private static boolean[][] getLetterM() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, O, O, O, O, O, O, O, X, X}
                           ,{X, X, X, O, O, O, O, O, X, X, X}
                           ,{X, X, X, X, O, O, O, X, X, X, X}
                           ,{X, X, O, X, X, O, X, X, O, X, X}
                           ,{X, X, O, O, X, X, X, O, O, X, X}
                           ,{X, X, O, O, O, X, O, O, O, X, X}
                           ,{X, X, O, O, O, O, O, O, O, X, X}
                           ,{X, X, O, O, O, O, O, O, O, X, X}
                           ,{X, X, O, O, O, O, O, O, O, X, X}
                           ,{X, X, O, O, O, O, O, O, O, X, X}
        };
        return L;
    }

    private static boolean[][] getLetterN() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, O, O, O, O, O, O, O, X, X}
                           ,{X, X, X, O, O, O, O, O, O, X, X}
                           ,{X, X, X, X, O, O, O, O, O, X, X}
                           ,{X, X, O, X, X, O, O, O, O, X, X}
                           ,{X, X, O, O, X, X, O, O, O, X, X}
                           ,{X, X, O, O, O, X, X, O, O, X, X}
                           ,{X, X, O, O, O, O, X, X, O, X, X}
                           ,{X, X, O, O, O, O, O, X, X, X, X}
                           ,{X, X, O, O, O, O, O, O, X, X, X}
                           ,{X, X, O, O, O, O, O, O, O, X, X}
        };
        return L;
    }

    private static boolean[][] getLetterO() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {O, O, X, X, X, X, X, O, O}
                            ,{O, X, X, X, X, X, X, X, O}
                            ,{X, X, X, O, O, O, X, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, X, O, O, O, X, X, X}
                            ,{O, X, X, X, X, X, X, X, O}
                            ,{O, O, X, X, X, X, X, O, O}
        };
        return L;
    }

    private static boolean[][] getLetterP() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X, O,}
                           ,{X, X, X, X, X, X, X,}
                           ,{X, X, O, O, O, X, X,}
                           ,{X, X, O, O, O, X, X,}
                           ,{X, X, X, X, X, X, X,}
                           ,{X, X, X, X, X, X, O,}
                           ,{X, X, O, O, O, O, O,}
                           ,{X, X, O, O, O, O, O,}
                           ,{X, X, O, O, O, O, O,}
                           ,{X, X, O, O, O, O, O,}
        };
        return L;
    }

    private static boolean[][] getLetterQ() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {O, O, O, X, X, X, X, O, O, O}
                            ,{O, X, X, X, X, X, X, X, X, O}
                            ,{X, X, X, O, O, O, O, X, X, X}
                            ,{X, X, O, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, X, X, O, X, X}
                            ,{X, X, X, O, O, O, X, X, X, X}
                            ,{O, X, X, X, X, X, X, X, X, O}
                            ,{O, O, O, X, X, X, X, O, X, X}
        };
        return L;
    }

    private static boolean[][] getLetterR() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X, O,}
                           ,{X, X, X, X, X, X, X,}
                           ,{X, X, O, O, O, X, X,}
                           ,{X, X, O, O, O, X, X,}
                           ,{X, X, X, X, X, X, X,}
                           ,{X, X, X, X, X, X, O,}
                           ,{X, X, X, X, O, O, O,}
                           ,{X, X, O, X, X, O, O,}
                           ,{X, X, O, O, X, X, O,}
                           ,{X, X, O, O, O, X, X,}
        };
        return L;
    }

    private static boolean[][] getLetterS() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {O, X, X, X, X, X, O,}
                           ,{X, X, X, X, X, X, X,}
                           ,{X, X, O, O, O, X, X,}
                           ,{X, X, O, O, O, O, O,}
                           ,{X, X, X, X, X, X, O,}
                           ,{O, X, X, X, X, X, X,}
                           ,{O, O, O, O, O, X, X,}
                           ,{X, X, O, O, O, X, X,}
                           ,{X, X, X, X, X, X, X,}
                           ,{O, X, X, X, X, X, O,}
                        };
        return L;
    }

    private static boolean[][] getLetterT() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X, X, X, X, X, X,}
                           ,{X, X, X, X, X, X, X, X,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                           ,{O, O, O, X, X, O, O, O,}
                        };
        return L;
    }

    private static boolean[][] getLetterU() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, X, X}
                            ,{X, X, X, O, O, O, X, X, X}
                            ,{O, X, X, X, X, X, X, X, O}
                            ,{O, O, X, X, X, X, X, O, O}
          };
        return L;
    }

    private static boolean[][] getLetterV() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {X, X, O, O, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, O, O, X, X}
                            ,{O, X, X, O, O, O, O, O, X, X, O}
                            ,{O, X, X, O, O, O, O, O, X, X, O}
                            ,{O, O, X, X, O, O, O, X, X, O, O}
                            ,{O, O, X, X, O, O, O, X, X, O, O}
                            ,{O, O, O, X, X, O, X, X, O, O, O}
                            ,{O, O, O, X, X, O, X, X, O, O, O}
                            ,{O, O, O, O, X, X, X, O, O, O, O}
                            ,{O, O, O, O, X, X, X, O, O, O, O}
                        };
        return L;
    }

    private static boolean[][] getLetterW() {

        boolean O = false, X = true;
        boolean L[][] = {
                             {X, X, O, O, O, O, O, O, O, X, X, X, O, O, O, O, O, O, O, X, X}
                            ,{X, X, O, O, O, O, O, O, O, X, X, X, O, O, O, O, O, O, O, X, X}
                            ,{O, X, X, O, O, O, O, O, X, X, O, X, X, O, O, O, O, O, X, X, O}
                            ,{O, X, X, O, O, O, O, O, X, X, O, X, X, O, O, O, O, O, X, X, O}
                            ,{O, O, X, X, O, O, O, X, X, O, O, O, X, X, O, O, O, X, X, O, O}
                            ,{O, O, X, X, O, O, O, X, X, O, O, O, X, X, O, O, O, X, X, O, O}
                            ,{O, O, O, X, X, O, X, X, O, O, O, O, O, X, X, O, X, X, O, O, O}
                            ,{O, O, O, X, X, O, X, X, O, O, O, O, O, X, X, O, X, X, O, O, O}
                            ,{O, O, O, O, X, X, X, O, O, O, O, O, O, O, X, X, X, O, O, O, O}
                            ,{O, O, O, O, X, X, X, O, O, O, O, O, O, O, X, X, X, O, O, O, O}
        };
        return L;
    }

    private static boolean[][] getLetterX() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterY() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterZ() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLettera() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterb() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterc() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterd() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLettere() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterf() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterg() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterh() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetteri() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X}
                           ,{X, X}
                           ,{O, O}
                           ,{X, X}
                           ,{X, X}
                           ,{X, X}
                           ,{X, X}
                           ,{X, X}
                           ,{X, X}
                           ,{X, X}                        
        };
        return L;
    }

    private static boolean[][] getLetterj() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterk() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {O, O, O, O, O, O}
                           ,{O, O, O, O, O, O}
                           ,{O, O, O, O, O, O}
                           ,{X, X, O, O, O, X}
                           ,{X, X, O, O, X, X}
                           ,{X, X, O, X, X, O}
                           ,{X, X, X, X, O, O}
                           ,{X, X, O, X, X, O}
                           ,{X, X, O, O, X, X}
                           ,{X, X, O, O, O, X}                                
                        };
        return L;
    }

    private static boolean[][] getLetterl() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}
                           ,{X, X, X}                       
                        };
        return L;
    }

    private static boolean[][] getLetterm() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLettern() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLettero() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        //TODO: make its own
        return getLetterO();
    }

    private static boolean[][] getLetterp() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterq() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterr() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetters() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLettert() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetteru() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterv() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterw() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterx() {

        boolean O = false, X = true;
        boolean L[][] = {
                            {O, O, O, O, O, O, O}
                           ,{O, O, O, O, O, O, O}
                           ,{X, O, O, O, O, O, X}
                           ,{X, X, O, O, O, X, X}
                           ,{O, X, X, O, X, X, O}
                           ,{O, O, X, X, X, O, O}
                           ,{O, O, X, X, X, O, O}
                           ,{O, X, X, O, X, X, O}
                           ,{X, X, O, O, O, X, X}
                           ,{X, O, O, O, O, O, X}                                
       };
        return L;
    }

    private static boolean[][] getLettery() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
        };
        return L;
    }

    private static boolean[][] getLetterz() {

        boolean O = false, X = true;
        boolean L[][] = {
            {X}
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
