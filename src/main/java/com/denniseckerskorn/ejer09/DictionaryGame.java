package com.denniseckerskorn.ejer09;

import java.util.*;

public class DictionaryGame {
    private static final int DEFAULT_PLAYER_SIZE = 5;
    private final Dictionary dictionary;
    private final List<Player> players;
    private final Random rnd;
    private String currentWord;
    private String currentDefinition;
    private int currentPlayerIndex;

    public DictionaryGame(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.players = new ArrayList<>(DEFAULT_PLAYER_SIZE);
        this.rnd = new Random();
        nextRound();
    }

    /**
     * Adds a new player to the game.
     *
     * @param name The name of the player to add.
     * @return true if the player was successfully added, false otherwise.
     */
    public boolean addPlayer(String name, int points) {
        if (players != null) {
            players.add(new Player(name, points));
            return true;
        }
        return false;
    }

    public void organizePlayerList() {
        if (players != null && players.size() > 1) {
            bubbleSort(players);
        }
    }

    private void bubbleSort(List<Player> players) {
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = 0; j < players.size() - i - 1; j++) {
                if (players.get(j).getPoints() < players.get(j + 1).getPoints()) {
                    Player temp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, temp);
                }
            }
        }
    }

    public String topPlayerList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            sb.append(i).append(players.get(i).getName()).append(players.get(i).getPoints()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Switches the turn to the next player in the list and returns the player whose turn it is.
     * If the current player index exceeds the number of players in the list, it wraps around to the beginning.
     *
     * @return The player whose turn it is after switching.
     */
    public Player switchPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return players.get(currentPlayerIndex);
    }

    /**
     * Generates a new word for the current round.
     */
    public void nextRound() {
        currentWord = getRandomWord();
        currentDefinition = dictionary.get(currentWord);
    }

    /**
     * Checks if a given word matches the current word for the round.
     *
     * @param userWord The word provided by the user.
     * @return true if the user's word matches the current word, false otherwise.
     */
    public boolean checkWord(String userWord) {
        return userWord.equals(currentWord);
    }

    /**
     * Retrieves a random word from the dictionary.
     *
     * @return A random word from the dictionary.
     * @throws IllegalStateException if dictionary is empty.
     */
    private String getRandomWord() throws IllegalStateException {
        List<String> randomDef = dictionary.getKeys();
        if (!randomDef.isEmpty()) {
            return randomDef.get(rnd.nextInt(randomDef.size()));
        } else {
            throw new IllegalStateException("The dictionary is empty. Can't generate a random word");
        }
    }

    public Player getCurrentPlayer() {
        if (currentPlayerIndex >= 0 && currentPlayerIndex < players.size()) {
            return players.get(currentPlayerIndex);
        } else {
            return null;
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public String getCurrentDefinition() {
        return currentDefinition;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryGame that = (DictionaryGame) o;
        return currentPlayerIndex == that.currentPlayerIndex && dictionary.equals(that.dictionary) && players.equals(that.players) && rnd.equals(that.rnd) && Objects.equals(currentWord, that.currentWord) && Objects.equals(currentDefinition, that.currentDefinition);
    }

    @Override
    public int hashCode() {
        int result = dictionary.hashCode();
        result = 31 * result + players.hashCode();
        result = 31 * result + rnd.hashCode();
        result = 31 * result + Objects.hashCode(currentWord);
        result = 31 * result + Objects.hashCode(currentDefinition);
        result = 31 * result + currentPlayerIndex;
        return result;
    }

    @Override
    public String toString() {
        return "DictionaryGame{" +
                "dictionary=" + dictionary +
                ", players=" + players +
                ", rnd=" + rnd +
                ", currentWord='" + currentWord + '\'' +
                ", currentDefinition='" + currentDefinition + '\'' +
                ", currentPlayerIndex=" + currentPlayerIndex +
                '}';
    }
}
