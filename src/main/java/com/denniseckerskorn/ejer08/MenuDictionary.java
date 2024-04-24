package com.denniseckerskorn.ejer08;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

public class MenuDictionary {
    private final Dictionary dictionary;
    private final ConsoleMenu menu;

    public MenuDictionary() {
        dictionary = new Dictionary();
        menu = new ConsoleMenu("GESTIÓN DICCIONARIO");
        menu.addOpcion("Add Word...");
        menu.addOpcion("Modifiy Word...");
        menu.addOpcion("Remove Word...");
        menu.addOpcion("Check Word and Definition");
        menu.addOpcion("Show entire Dictionary...");
        menu.addOpcion("Exit");

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
                default:
                    System.out.println("Invalid number input");
                    break;
            }
        } while (opcion != 6);
    }

    private void addWord() {
        String word = LibIO.requestString("Introduce the word: ");
        String definition = LibIO.requestString("Introduce the definition of the word: ");

        if (dictionary.addWord(word, definition)) {
            System.out.println("The word and definition has been added correctly");
        } else {
            System.out.println("The provided word already exists in the dictionary: " + word);
        }
    }

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

    private void removeWord() {
        String word = LibIO.requestString("Introduce the word to find and remove in the dictionary: ");
        if (dictionary.removeWord(word)) {
            System.out.println("The word has been removed correctly");
        } else {
            System.out.println("The dictionary doesn´t contain the word " + word);
        }
    }

    private void checkWord() {
        String word = LibIO.requestString("Introduce the word to find the definition: ");
        if (dictionary.containsWord(word)) {
            System.out.println(dictionary.getWord(word));

        } else {
            System.out.println("The dictionary doesn't contain the word " + word);
        }
    }

    private void showDictionary() {
        System.out.println(dictionary.showDictionary());
    }

}
