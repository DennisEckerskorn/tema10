package com.denniseckerskorn.ejer08;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Class representing a simple dictionary.
 */
public class Dictionary {
    private Map<String, String> dictionary;

    /**
     * Default constructor that initializes the dictionary with a HashMap.
     */
    public Dictionary() {
        dictionary = new HashMap<>();
    }

    /**
     * Adds a word and its definition to the dictionary.
     *
     * @param word       The word to add.
     * @param definition The definition to add.
     * @return true if the word is added successfully, false if the word already exists in the dictionary.
     */
    public boolean addWord(String word, String definition) {
        if (dictionary.containsKey(word)) {
            return false;
        } else {
            dictionary.put(word, definition);
            return true;
        }
    }

    /**
     * Gets the definition of a word from the dictionary.
     *
     * @param word The word to look up.
     * @return The definition of the specified word.
     * @throws NoSuchElementException if the specified word does not exist in the dictionary.
     */
    public String getWord(String word) throws NoSuchElementException {
        String definition = dictionary.get(word);
        if (definition == null) {
            throw new NoSuchElementException("The specified word does not exist in the dictionary");
        }
        return definition;
    }

    /**
     * Checks if a word exists in the dictionary.
     *
     * @param word The word to check.
     * @return true if the word exists in the dictionary, false otherwise.
     */
    public boolean containsWord(String word) {
        return dictionary.containsKey(word);
    }

    /**
     * Modifies the definition of a word in the dictionary.
     *
     * @param word          The word whose definition will be modified.
     * @param newDefinition The new definition of the word.
     */
    public void modifiyDefinition(String word, String newDefinition) {
        dictionary.put(word, newDefinition);
    }

    /**
     * Removes a word from the dictionary.
     *
     * @param word The word to remove.
     * @return true if the word is removed successfully, false if the word does not exist in the dictionary.
     */
    public boolean removeWord(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the entire dictionary.
     *
     * @return A string representing the dictionary and its definitions.
     */
    public String showDictionary() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> e : dictionary.entrySet()) {
            sb.append(e.getKey()).append(" - ").append(e.getValue());
        }
        return sb.toString();
    }


}
