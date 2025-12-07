package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utility.Base;
import utility.ProviderFromExcel;

import java.sql.Driver;

public class TestCase_Login extends Base {

    @Test(dataProvider = "login-data", dataProviderClass = ProviderFromExcel.class)
    public void verifyLoginWithValidCredentials(String username, String password){
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountButton();
            homePage.clickLoginButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setInputEmailAddress(username);
            loginPage.setInputPassword(prop.getProperty(password));
            loginPage.clickLoginButton();

            MyAccountPage mccPage = new MyAccountPage(driver);

            Assert.assertTrue(mccPage.isTextMyAccountVisible());

        } catch (RuntimeException e) {
            Assert.fail();
            System.out.println("Exception with : " + e.getMessage());
        }
    }
}
