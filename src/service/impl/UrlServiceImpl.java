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
    FileServiceImpl fileService = new FileServiceImpl();
    @Override
    public String readWordsFromUrl() throws MalformedURLException {
        String urlPath = "https://random-word-api.herokuapp.com/word";
        URL url = new URL(urlPath);

        try {
            Scanner scanner = new Scanner(url.openStream());
            String randomWord = scanner.useDelimiter("\\A").nextLine();
            System.out.println(randomWord);
            fileService.saveAllWords("randomWords.txt", GlobalData.wordDynamicArray.getAllWords());
            return randomWord;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
