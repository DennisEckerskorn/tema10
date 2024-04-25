package com.denniseckerskorn.ejer09;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

/**
 * This class represents a menu for managing a dictionary.
 */
public class MenuDictionary {
    private final Dictionary dictionary;
    private final ConsoleMenu menu;
    private final ConsoleMenu menuGame;
    private final DictionaryGame game;

    /**
     * Constructs a new MenuDictionary object.
     * Initializes the dictionary and creates a console menu with various options.
     */
    public MenuDictionary() {
        dictionary = new Dictionary();
        initializeDictionary();
        game = new DictionaryGame(dictionary);

        menu = new ConsoleMenu("DICTIONARY MANAGEMENT");
        menu.addOpcion("Add Word...");
        menu.addOpcion("Modify Word...");
        menu.addOpcion("Remove Word...");
        menu.addOpcion("Check Word and Definition");
        menu.addOpcion("Show entire Dictionary...");
        menu.addOpcion("Play Game...");
        menu.addOpcion("Top Scores...");
        menu.addOpcion("Exit");

        menuGame = new ConsoleMenu("GAME MENU");
        menuGame.addOpcion("Create new Player");
        menuGame.addOpcion("Play");
        menuGame.addOpcion("Return to Main Menu");

        mainMenu();

    }

    private void mainMenu() {
        int opcion;
        do {
            opcion = menu.mostrarMenuInt();

            switch (opcion) {
                case 1:
                    addWord();
                    break;
                case 2:
                    modifyWord();
                    break;
                case 3:
                    removeWord();
                    break;
                case 4:
                    checkWord();
                    break;
                case 5:
                    showDictionary();
                    break;
                case 6:
                    menuJugar();
                    break;
                case 7: //TODO: add player point table, top 5.
                    break;
                case 8:
                    System.out.println("See you soon...");
                    break;
                default:
                    System.out.println("Invalid number input");
                    break;
            }
        } while (opcion != 8);
    }

    private void menuJugar() {
        int option;
        do {
            option = menuGame.mostrarMenuInt();
            switch (option) {
                case 1: //Add Player, TODO: Needs to be added before game...
                    addPlayer();
                    break;
                case 2: //Play TODO: Add, play again option and show current points
                    playGame();
                    break;
                case 3:
                    return; //Exit method, return to main menu.
                default:
                    System.out.println("Option is not valid");
                    break;
            }
        } while (true);
    }

    private void initializeDictionary() {
        dictionary.addWord("Dog", "A common animal with four legs, especially kept by people as a pet or to hunt or guard things");
        dictionary.addWord("Cat", "A small animal with fur, four legs, a tail, and claws, usually kept as a pet or for catching mice");
        dictionary.addWord("Fish", "An animal that lives in water, is covered with scales, and breathes by taking water in through its mouth, or the flesh of these animals eaten as food");
    }

    private void addPlayer() {
        String name = LibIO.requestString("Please enter your player name:");
        if (game.addPlayer(name)) {
            System.out.println("The player has been added correctly");
        } else {
            System.out.println("The player couldn't be added.");
        }
    }

    private void playGame() {
        String currentDef = game.getCurrentDefinition();
        int attempts = 3;
        System.out.println("Try to guess the Word for the following definition:");
        System.out.println(currentDef);
        while (attempts > 0) {
            String guess = LibIO.requestString("Try your luck, you have" + attempts + "attempts:", 1, 30);
            if (game.checkWord(guess)) {
                System.out.println("Correct Word, Congrats");
                game.getCurrentPlayer().incrementPoints();
                return;
            } else {
                System.out.println("Incorrect Word, please try again");
                attempts--;
                if (attempts > 0) {
                    System.out.println("You have " + attempts + " left");
                }
            }
        }
        System.out.println("You've run out of attemtps, the correct word was: " + game.getCurrentWord());
    }

    /**
     * Prompts the user to add a new word and its definition to the dictionary.
     */
    private void addWord() {
        String word = LibIO.requestString("Introduce the word: ");
        String definition = LibIO.requestString("Introduce the definition of the word: ");

        if (dictionary.addWord(word, definition)) {
            System.out.println("The word and definition has been added correctly");
        } else {
            System.out.println("The provided word already exists in the dictionary: " + word);
        }
    }

    /**
     * Prompts the user to modify the definition of an existing word in the dictionary.
     */
    private void modifyWord() {
        String word = LibIO.requestString("Introduce the word to find in the dictionary: ");
        if (dictionary.containsWord(word)) {
            String definition = LibIO.requestString("Introduce the definition of the word: ");
            dictionary.modifiyDefinition(word, definition);
            System.out.println("The definition of the word " + word + " has been modified correctly");
        } else {
            System.out.println("The dictionary doesn't contain the word " + word);
        }
    }

    /**
     * Prompts the user to remove a word from the dictionary.
     */
    private void removeWord() {
        String word = LibIO.requestString("Introduce the word to find and remove in the dictionary: ");
        if (dictionary.removeWord(word)) {
            System.out.println("The word has been removed correctly");
        } else {
            System.out.println("The dictionary doesn´t contain the word " + word);
        }
    }

    /**
     * Prompts the user to check the definition of a word in the dictionary.
     */
    private void checkWord() {
        String word = LibIO.requestString("Introduce the word to find the definition: ");
        if (dictionary.containsWord(word)) {
            System.out.println(dictionary.get(word));
        } else {
            System.out.println("The dictionary doesn't contain the word " + word);
        }
    }

    /**
     * Displays the entire dictionary.
     */
    private void showDictionary() {
        System.out.println(dictionary.showDictionary());
    }

}
