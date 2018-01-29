package hangman;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is part I of the Hangman challenge on Google's Tech Dev Guide,
 * Foundation path.
 *
 * This program will:
 *  - Choose a word from the lexicon at random.
 *  - Accept either lower or upper case guesses.
 *  - Penalise repeated guesses that are incorrect.
 *  - Not penalise repeated guesses that are correct.
 *  - Not penalise and ignore guesses that are longer than 1 char.
 */
public class Hangman {

    private static HangmanLexicon lexicon;
    private static String word;
    private static StringBuilder hint;
    private static char[] badGuesses;
    private static char[] goodGuesses;
    private static int fails;   // number of bad guesses

    public static void main (String[] args) {
        init();
        run();
    }

    /**
     * Initialise the game.
     */
    private static void init () {
        try {
            lexicon = new HangmanLexicon("HangmanLexicon.txt");
        } catch (IOException e) {
            System.err.println("Error reading lexicon file!");
            return;
        }
        badGuesses = new char[26];
        goodGuesses = new char[26];
        fails = 0;
        setWord();
        setHint();
    }
    /**
     * Run the game.
     */
    private static void run () {
        System.out.println("Welcome to Hangman!");
        while (!isDead() && !isComplete()) {
            String guesses = getPrintableBadGuesses();
            String printGuesses = (guesses.length() == 0 ? "-" : guesses);
            System.out.println("Progress:\t" + hint);
            System.out.println("Guesses:\t" + printGuesses);
            System.out.println("Chances:\t" + (8 - fails));
            System.out.print("Next guess\t>> ");
            String input = getInput().toLowerCase();
            System.out.print("\n\t");
            if (input.length() == 1) {
                char inputChar = input.charAt(0);
                if (inputChar < 'a' || inputChar > 'z') {
                    System.out.println("Invalid input!");
                } else if (isInCharArray(inputChar, badGuesses)) {
                    if (isDead()) break;
                    System.out.println("Incorrect guess again!");
                    fails++;
                } else if (isInCharArray(inputChar, goodGuesses)) {
                    System.out.println("Already guessed!");
                    // At this point, the inputChar is valid and new.
                } else if (isInString(inputChar, word)) {
                    if (isComplete()) break;
                    System.out.println("Correct!");
                    goodGuesses[inputChar - 'a'] = inputChar;
                    updateHint(inputChar);
                } else {
                    if (isDead()) break;
                    System.out.println("Incorrect!");
                    badGuesses[inputChar - 'a'] = inputChar;
                    fails++;
                }
            } else {
                System.out.println("Choose one letter!");
            }
        }
        System.out.println();
        if (isDead()) {
            System.out.println("Game Over! The word is " + word + "!");
        }
        if (isComplete()) {
            System.out.println("Congratulations! You won!");
        }
    }

    /**
     * Set the word of the game based on the lexicon.
     */
    private static void setWord () {
        int i = randomInt(0, lexicon.getWordCount() - 1);
        word = lexicon.getWord(i).toLowerCase();
    }
    /**
     * Initialise the hint to me the word with each char replaced by "-".
     */
    private static void setHint () {
        hint = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hint.append('-');
        }
    }
    /**
     * Populate hint String with the char based on the word.
     *
     * @param c Char to populate the hint String based on the word.
     */
    private static void updateHint (char c) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                hint.setCharAt(i, c);
            }
        }
    }

    /**
     * Check whether or not the player is dead.
     *
     * @return Boolean stating whether or not the player is dead.
     */
    private static boolean isDead () {
        return fails >= 8;
    }
    /**
     * Check whether or not the player completed the word.
     *
     * @return Boolean stating whether or not the player completed the word.
     */
    private static boolean isComplete () {
        return word.equalsIgnoreCase(hint.toString());
    }
    /**
     * Check if char is in the char array.
     *
     * @param c Char to check whether or not it is in the array.
     * @param array Array to check whether or not the char is in.
     * @return Boolean stating whether or not the char is in the array.
     */
    private static boolean isInCharArray (char c, char[] array) {
        for (char d : array) {
            if (c == d) return true;
        }
        return false;
    }
    /**
     * Check if char is in the String.
     *
     * @param c Char to check whether or not it is in the array.
     * @param s String to check whether or not the char is in.
     * @return Boolean stating whether or not the char is in the String.
     */
    private static boolean isInString (char c, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) return true;
        }
        return false;
    }

    /**
     * Return a String of comma-separated chars of bad guesses so far.
     *
     * @return String of comma-separated chars of bad guesses so far.
     */
    private static String getPrintableBadGuesses () {
        StringBuilder sb = new StringBuilder();
        for (char g : badGuesses) {
            if (g != '\u0000') { // the null char
                sb.append(g).append(",");
            }
        }
        sb.setLength(Math.max(0, sb.length() - 1));
        return sb.toString();
    }
    /**
     * Get the player input as a String.
     * @return Player input as a String.
     */
    private static String getInput () {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /**
     * Return a random integer in the interval [a,b].
     *
     * @param a One of the integers defining the interval.
     * @param b One of the integers defining the interval.
     * @return A random integer in the interval [a,b].
     */
    private static int randomInt (int a, int b) {
        return (int)(Math.random() * (Math.abs(b-a) + 1)) + a;
    }

}
