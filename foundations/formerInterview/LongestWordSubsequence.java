package formerInterview;

import java.util.*;

/**
 * This class attempts to solve the following problem:
 *
 *      Given a string S and a set of words D, find the longest word in D
 *      that is a subsequence of S.
 *
 * Word W is a subsequence of S if some number of characters, possibly zero,
 * can be deleted from S to form W without reordering the remaining characters.
 */
public class LongestWordSubsequence {

    /*
        We first note that the prompt assumes uniqueness of D when this may
        not be the case, e.g.
            S = "batman"
            D = {"bat","man"}
        Both "bat" and "man" are the longest words in D that is a subsequence
        of S.

        We will first deal with the first occurrence of such a subsequence,
        then come back to look at a more complete solution of identifying all
        such subsequences.

        Note also that "first occurrence" is ambiguous; let S = "bmant", then
        we would "complete" the "man" first, but the "b" in "bat" is the first
        character to appear. We will take "first occurrence" to mean the latter
        case here.
     */

    /**
     * First idea treating s as a set of characters and looping through its
     * power set.
     *
     * This solution is not good because it's exponential.
     *      O(d.length() * 2^s.length())
     * 2^s.length() is the size of the power set of s
     * For each set in the power set of s, we check if it's in the set of
     * words (linear search).
     *
     * @param s String to look for subsequence in.
     * @param d String array representing the set of words.
     * @return A longest word in d that is a subsequence of s.
     */
    private static String longestWordSubsequence1 (String s, String[] d) {
        // The first idea is to enumerate through the power set of s
        // starting from the longest to the shortest.
        String candidate = "";
        for (int i = (int)Math.pow(2,s.length()) - 1; i > 0; i--) {
            String current = binaryMaskString(i,s);
            if (isInArray(current, d) && current.length() > candidate.length()) {
                candidate = current;
            }
        }
        return candidate;
    }
    /**
     * Check if the string s is in the array d.
     *
     * @param s String to check for containment.
     * @param d Array of strings to check against.
     * @return Boolean stating whether or not s is in d.
     */
    private static boolean isInArray (String s, String[] d) {
        for (String ss : d) {
            if (ss.equals(s)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Mask the string using the binary representation of the integer.
     *
     * @param n Integer in decimal to mask the string.
     * @param s String to be masked.
     * @return Masked string.
     */
    private static String binaryMaskString (int n, String s) {
        String bin = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bin.length(); i++) {
            // Calibrate i if the length of the binary representation of n is
            // shorter than s in order to simulate the leading zeros.
            int sIndex = i + (s.length() - bin.length());
            if (bin.charAt(i) == '1') {
                sb.append(s.charAt(sIndex));
            }
        }
        return sb.toString();
    }

    private static String longestWordSubsequence2 (String s, String[] d) {
        // Consider processing d into a tree of max breadth 26 and max depth
        // equal to the longest word in d.
        // Each node contains a boolean to mark if it is the end of a word
        // in d.
        // Then loop through each char in s and "expand" through the tree.
        
        return s;
    }

    public static void main (String[] args) {
        String s = "abppplee";
        String[] d = {"able","ale","apple","bale","kangaroo"};
        String expected = "apple";

        System.out.println("Expected:\t" + expected);
        System.out.println("1:\t" + longestWordSubsequence1(s,d));
        System.out.println("2:\t" + longestWordSubsequence2(s,d));
    }

}
