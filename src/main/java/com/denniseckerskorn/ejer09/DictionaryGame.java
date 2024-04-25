package com.denniseckerskorn.ejer09;

import java.util.*;

public class DictionaryGame {
    private final Dictionary dictionary;
    private final Random rnd;
    private String currentWord;
    private String currentDefinition;

    public DictionaryGame() {
        this.dictionary = new Dictionary();
        this.rnd = new Random();
        nextRound();
    }

    public void nextRound() {
        currentWord = getRandomWord();
        currentDefinition = dictionary.get(currentWord);
    }

    public int checkWord(String userWord) {
        int pointCounter = 0;
        if(userWord.equals(currentWord)) {
            pointCounter++;
        }
        return pointCounter;
    }

    private String getRandomWord() {
        List<String> randomDef = dictionary.getKeys();
        return randomDef.get(rnd.nextInt(randomDef.size()));
    }


}
