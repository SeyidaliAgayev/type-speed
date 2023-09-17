package util;
import java.io.Serializable;

import static util.InputUtil.*;

public class MenuUtil implements Serializable {
    public static int entryMenu() {
        System.out.println("""
                           [0] ---->> Finish Game
                           [1] ---->> Start Game
                           """
        );
        return inputRequiredInt("Choose an option: ");
    }
}
