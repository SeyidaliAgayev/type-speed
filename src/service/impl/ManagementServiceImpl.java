package service.impl;
import service.ManagementServiceInter;
import util.MenuUtil;
import java.net.MalformedURLException;
import static helper.TimeHelper.*;

public class ManagementServiceImpl implements ManagementServiceInter {
    public static ManagementServiceImpl instance = null;
    private ManagementServiceImpl() {
    }

    public static ManagementServiceImpl getInstance() {
        return instance == null ? instance = new ManagementServiceImpl() : instance;
    }

    @Override
    public void management() throws MalformedURLException, InterruptedException {
        while (true) {
            int option = MenuUtil.entryMenu();

            switch (option) {
                case 0:
                    System.exit(-1);
                case 1:
                    timeDownCounter();
                    writeWordsToArray();
                    readWordsFromArray();
                    wpsCalculator();
                    break;
            }
        }
    }
}
