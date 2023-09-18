package service;

import data.WordDynamicArray;

public interface FileServiceInter {
    void saveAllWords(String fileName, String randomWord);
    WordDynamicArray readAllWords(String fileName);
}
