package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterPage;
import utility.Base;

public class TestCase_Register extends Base {

    @Test
    public void verifyRegistrationWithAllMandatoryFields(){
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountButton();
            homePage.clickRegisterButton();

            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.setInputFirstName("kaleswararao");
            registerPage.setInputLastName("Nakuluri");
            registerPage.setInputEmail(prop.getProperty("email"));
            registerPage.setInputTelephone("8877887788");
            registerPage.setInputPassword(prop.getProperty("password"));
            registerPage.setInputConfirmPassword(prop.getProperty("password"));
            registerPage.clickCheckboxPrivacyPolicy();
            registerPage.clickContinueButton();

            MyAccountPage mccPage = new MyAccountPage(driver);
            Assert.assertTrue(mccPage.isTextAccountCreatedVisible());
        } catch (Exception e) {
            Assert.fail("Registration failed with :" + e.getMessage());

        }
    }
}
