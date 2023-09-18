package helper;

import data.GlobalData;
import service.impl.FileServiceImpl;
import service.impl.UrlServiceImpl;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Random;


import static util.InputUtil.inputRequiredString;


public class TimeHelper {
    static UrlServiceImpl urlService = new UrlServiceImpl();
    static FileServiceImpl fileService = new FileServiceImpl();
    public static int correctWordCount = 0;
    static LocalTime startTime = LocalTime.now();
    static LocalTime endTime = startTime.plusSeconds(10);
    public static void timeDownCounter() {
        try {
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
            System.out.println("Game has Started!");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void wpsCalculator() {
        Duration timePassed = Duration.between(startTime, endTime);
        double spendTime = timePassed.toMillis() / 1000.0;
        System.out.println("Your result is: " + correctWordCount);
        System.out.println("Your type speed is: " + (correctWordCount / spendTime) + "WPS");
    }
    public static void writeWordsToArray() throws MalformedURLException {
        Instant endTimeWrite = Instant.now().plusSeconds(10);

        while (Instant.now().isBefore(endTimeWrite)) {
            String randomWord = urlService.readWordsFromUrl().replace("[\"", " ").replace("\"]", " ").trim();
            GlobalData.wordDynamicArray.add(randomWord);
            fileService.saveAllWords("randomWords.txt", randomWord);
        }
    }

    public static void readWordsFromArray() {
        Random random = new Random();
        Instant endTimeRead = Instant.now().plusSeconds(30);
        while (Instant.now().isBefore(endTimeRead)) {
            String randomWord = GlobalData.wordDynamicArray.get(random.nextInt(GlobalData.wordDynamicArray.getSize()));
            System.out.println(randomWord);
            String writtenWord = inputRequiredString("Please enter word: ");
            if (randomWord.equals(writtenWord)) {
                correctWordCount++;
            }
        }
    }
}
