
import service.impl.ManagementServiceImpl;
import java.net.MalformedURLException;


public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ManagementServiceImpl.getInstance().management();
    }
}