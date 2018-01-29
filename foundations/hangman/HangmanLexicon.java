package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is a lexicon for the hangman game.
 * Either create a new lexicon with a default list of words
 * or provide the file name for a text file to read the words from.
 */
public class HangmanLexicon {

    private String[] defaultWords = {
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
    private List<String> words;
    private String lexiconSource;

    /**
     * Create a hangman lexicon with a default list of words.
     */
    public HangmanLexicon () {
        words = Arrays.<String>asList(defaultWords);
    }

    /**
     * Create a hangman lexicon with words from the source file.
     *
     * @param source Source file for lexicon words.
     */
    public HangmanLexicon (String source) throws IOException {
        words = new ArrayList<String>();
        lexiconSource = source;
        parseSource();
    }

    /**
     * Parse the source file and populate the lexicon words with its content.
     */
    private void parseSource () throws IOException {
        String path = Paths.get(".")
                .toAbsolutePath()
                .normalize()
                .toString();
        path += "/" + lexiconSource;
        // the try-with-resources idiom for SE7 or later
        try (BufferedReader br =
                new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.toLowerCase());
            }
        }
    }

    /**
     * Returns the number of words in the lexicon.
     *
     * @return The number of words in the lexicon.
     */
    public int getWordCount () {
        return words.size();
    }

    /**
     * Returns the word at the specified index.
     *
     * @param index Index of the word in the lexicon.
     * @return The word in the lexicon corresponding to the given index.
     */
    public String getWord (int index) {
        return words.get(index);
    }

}
