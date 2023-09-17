package service.impl;

import data.GlobalData;
import data.WordDynamicArray;
import service.FileServiceInter;

import java.io.*;

public class FileServiceImpl implements FileServiceInter, Serializable {

    @Override
    public void saveAllWords(String fileName, String[] randomWord) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {

            objectOutputStream.writeObject(GlobalData.wordDynamicArray);
            objectOutputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public WordDynamicArray readAllWords(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            WordDynamicArray wordDynamicArray = (WordDynamicArray) objectInputStream.readObject();

            return wordDynamicArray;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;

    }
}

//

