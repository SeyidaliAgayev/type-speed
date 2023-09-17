package util;

import java.io.Serializable;
import java.util.Scanner;

public class InputUtil implements Serializable {
    public static int inputRequiredInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextInt();
    }

    public static String inputRequiredString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }
}
