package service.impl;

import data.GlobalData;
import data.WordDynamicArray;
import service.UrlServiceInter;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UrlServiceImpl implements UrlServiceInter, Serializable {
    public static UrlServiceImpl instance = null;
    private UrlServiceImpl() {
    }

    public static UrlServiceImpl getInstance() {
        return instance == null ? instance = new UrlServiceImpl() : instance;
    }

    @Override
    public String readWordsFromUrl() throws MalformedURLException {
        String urlPath = "https://random-word-api.herokuapp.com/word";
        URL url = new URL(urlPath);

        try {
            Scanner scanner = new Scanner(url.openStream());
            String randomWord = scanner.useDelimiter("\\A").nextLine();
            System.out.println(randomWord);
            FileServiceImpl.getInstance().saveAllWords("randomWords.txt", randomWord);
            return randomWord;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
