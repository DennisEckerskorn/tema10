package com.denniseckerskorn.ejer08;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public boolean addWord(String word, String definition) {
        if (dictionary.containsKey(word)) {
            return false;
        } else {
            dictionary.put(word, definition);
            return true;
        }
    }

    public String getWord(String word) {
        return dictionary.get(word);
    }

    public boolean containsWord(String word) {
        return dictionary.containsKey(word);
    }

    public void modifiyDefinition(String word, String newDefinition) {
        dictionary.put(word, newDefinition);
    }

    public boolean removeWord(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            return true;
        } else {
            return false;
        }
    }

    public String showDictionary() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> e : dictionary.entrySet()) {
            sb.append(e.getKey()).append(" - ").append(e.getValue());
        }
        return sb.toString();
    }


}
