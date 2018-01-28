package hangman;

/**
 * This class contains a stub implementation of the HangmanLexicon class.
 */
public class HangmanLexicon {

    private String[] words = {
            "BUOY",
            "COMPUTER",
            "CONNOISSEUR",
            "DEHYDRATE",
            "FUZZY",
            "HUBBUB",
            "KEYHOLE",
            "QUAGMIRE",
            "SLITHER",
            "ZIRCON"
    };

    /**
     * Returns the number of words in the lexicon.
     *
     * @return The number of words in the lexicon.
     */
    public int getWordCount () {
        return words.length;
    }

    /**
     * Returns the word at the specified index.
     *
     * @param index Index of the word in the lexicon.
     * @return The word in the lexicon corresponding to the given index.
     */
    public String getWord (int index) {
        return words[index];
    }

}
