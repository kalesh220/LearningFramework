package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement textAccountCreated;

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement textMyAccount;


    public boolean isTextAccountCreatedVisible(){
        return textAccountCreated.isDisplayed();
    }

    public boolean isTextMyAccountVisible(){
        return textMyAccount.isDisplayed();
    }
}
