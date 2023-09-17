package data;

import java.io.Serializable;

public class WordDynamicArray implements Serializable {
    private String[] randomWords = new String[0];

    public void add(String randomWord) {
        String[] newRandomWords = new String[randomWord.length() + 1];
        for (int i = 0; i < randomWords.length; i++) {
            newRandomWords[i] = randomWords[i];
        }

        newRandomWords[newRandomWords.length - 1] = randomWord;
        randomWords = newRandomWords;
    }

    public String get(int index) {
        if (index < 0 || index >= randomWords.length) {
            System.out.println("Index is wrong!");
            return null;
        } else {
            return randomWords[index];
        }
    }

    public int size() {
        return randomWords.length;
    }

    public String[] getAllWords() {
        return randomWords;
    }
}


