package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inputEmailAddress;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void setInputEmailAddress(String emailAddress){
        inputEmailAddress.sendKeys(emailAddress);
    }
    public void setInputPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
