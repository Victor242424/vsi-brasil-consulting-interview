package br.vsi_brasil.consulting;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate all possible anagrams from a set of different letters.
 */
public class Main {

    /**
     * Main method for demonstration.
     */
    public static void main(String[] args) {
        char[] inputLetters = {'a', 'b', 'c'};
        List<String> anagrams = anagramsGenerator(inputLetters);

        System.out.println("Anagrams:");
        for (int i = 0; i < anagrams.size(); i++) {
            System.out.print(anagrams.get(i));
            if (i < anagrams.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    /**
     * Generates all possible anagrams for a set of letters.
     *
     * @param letters Array of characters with different letters
     * @return List of strings with all possible anagrams
     * @throws IllegalArgumentException If the entry is invalid
     */

    public static List<String> anagramsGenerator(char[] letters) {
        validateInput(letters);
        List<String> anagrams = new ArrayList<>();
        recursiveAnagramGenerator(letters, 0, anagrams);
        return anagrams;
    }

    /**
     * Checks if the input is correct.
     *
     * @param letters Array of characters to validate
     * @throws IllegalArgumentException If the input is null, empty, or contains non-alphabetic characters
     */
    private static void validateInput(char[] letters) {
        if (letters == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (letters.length == 0) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        for (char character : letters) {
            if (!Character.isLetter(character)) {
                throw new IllegalArgumentException("Input must contain only letters");
            }
        }
    }

    /**
     * Generate anagrams using recursion.
     *
     * @param letters Array of characters to validate
     * @param currentIndex Integer of the current index on the letters array
     * @param result List of strings to store anagrams
     */

    private static void recursiveAnagramGenerator(char[] letters, int currentIndex, List<String> result) {

        //Add anagram at last element add it to the result list
        if (currentIndex == letters.length - 1) {
            result.add(new String(letters));
            return;
        }

        //Iterate each element position and interchange the current element with the next one
        for (int i = currentIndex; i < letters.length; i++) {
            swap(letters, currentIndex, i);
            recursiveAnagramGenerator(letters, currentIndex + 1, result);
            swap(letters, currentIndex, i); // backtrack
        }

    }

    /**
     * Utility function to swap letters positions
     * @param array  letters Array of characters to swap
     * @param i current letter position
     * @param j next letter position
     */
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}