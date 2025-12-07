package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountButton;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginButton;

    public void clickMyAccountButton(){
        myAccountButton.click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
