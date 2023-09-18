package service.impl;

import data.GlobalData;
import data.WordDynamicArray;
import service.FileServiceInter;

import java.io.*;

public class FileServiceImpl implements FileServiceInter, Serializable {

    public static FileServiceImpl instance = null;
    private FileServiceImpl() {
    }

    public static FileServiceImpl getInstance() {
        return instance == null ? instance = new FileServiceImpl() : instance;
    }

    @Override
    public void saveAllWords(String fileName, String randomWord) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
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
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                GlobalData.wordDynamicArray.add(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}


