import data.GlobalData;
import data.WordDynamicArray;
import service.impl.FileServiceImpl;
import service.impl.UrlServiceImpl;
import util.MenuUtil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;
import static util.MenuUtil.*;
import static util.InputUtil.*;

public class Main {
    static UrlServiceImpl urlService = new UrlServiceImpl();
    static FileServiceImpl fileService = new FileServiceImpl();
    public static int correctWordCount = 0;
    static long startTime = 0;
    static long endTime = 0;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        while (true) {
            int option = MenuUtil.entryMenu();

            switch (option) {
                case 0:
                    System.exit(-1);
                case 1:
                    System.out.println("3");
                    Thread.sleep(1000);
                    System.out.println("2");
                    Thread.sleep(1000);
                    System.out.println("1");
                    Thread.sleep(1000);
                    System.out.println("Game has Started!");
                    startTime = System.currentTimeMillis();
                    endTime = startTime;
                    for (int i = 0; i < 5; i++) {
                        String randomWord = urlService.readWordsFromUrl().replace("[\"", " ").replace("\"]", " ").trim();
                        String writtenWord = inputRequiredString("Please write word: ");
                        if (randomWord.equals(writtenWord)) {
                            correctWordCount++;
                        }
                    }
                    System.out.println("Your result is: " + correctWordCount);
                    if (startTime > 0) {
                        endTime = System.currentTimeMillis();
                        double spendTime = (endTime - startTime) / 1000.0;
                        System.out.println("Your type speed is: " + (correctWordCount / spendTime));
                    }
                    break;
            }

        }
    }

}