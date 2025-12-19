package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static FileInputStream fileInputStream;
    public static Properties prop;


    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser){
        try {
            fileInputStream = new FileInputStream("./src/test/resources/data.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch (browser.toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver();
            case "firfox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            default -> driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown() throws InterruptedException, IOException {
        Thread.sleep(5000);
        if(driver!=null){
            driver.quit();
        }
        fileInputStream.close();
    }
}
