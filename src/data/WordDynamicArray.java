package data;

import java.io.Serializable;

public class WordDynamicArray implements Serializable {
    public String[] randomWords;

    public WordDynamicArray() {
        randomWords = new String[0];
    }


    public void add(String word) {
        String[] newWords = new String[randomWords.length + 1];

        for (int i = 0; i < randomWords.length; i++) {
            newWords[i] = randomWords[i];
        }
        newWords[randomWords.length] = word;

        randomWords = newWords;

    }

    public String get(int index) {
        if (index < 0 || index >= randomWords.length) {
            throw new IllegalArgumentException();
        }
        return randomWords[index];

    }
    public int getSize() {

        return randomWords.length;
    }
}


