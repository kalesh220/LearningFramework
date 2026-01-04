package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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

    public static String getScreenShotPath() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-hh_HH-mm-ss");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir")+"/screenshots/screenshot_"+formatter.format(new Date())+".png";
        File targetFile = new File(targetFilePath);
        FileUtils.copyFile(srcFile, targetFile);
        return targetFilePath;
    }
}
