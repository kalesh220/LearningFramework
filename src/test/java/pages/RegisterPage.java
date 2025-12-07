package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement inputTelephone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement inputConfirmPassword;
    @FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
    WebElement subscribeNewsletter;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkboxPrivacyPolicy;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    public void setInputFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
    }
    public void setInputLastName(String lastName){
        inputLastName.sendKeys(lastName);
    }
    public void setInputEmail(String email){
        inputEmail.sendKeys(email);
    }
    public void setInputTelephone(String telephoneNumber){
        inputTelephone.sendKeys(telephoneNumber);
    }
    public void setInputPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void setInputConfirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
    }
    public void clickCheckboxPrivacyPolicy(){
        checkboxPrivacyPolicy.click();
    }
    public void clickContinueButton(){
        continueButton.click();
    }
}
