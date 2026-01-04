package utility;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Base base = new Base();
        base.setUp("chrome");
        System.out.println(Base.getScreenShotPath());
    }
}
