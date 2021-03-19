package logintests;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AuthenticationPage;

public class LoginTests extends BaseTest {

    AuthenticationPage authPage;

    @BeforeMethod
    public void logOutIfAlreadyLoggedIn(){
        if(isUserLoggedIn == true){
            homePage.logout();
            homePage.validateLoggedOutSuccessfully();
            isUserLoggedIn = false;
        }
    }

    @Test(dataProvider = "Login Credentials", dataProviderClass = LoginDDT.class)
    public void loginWithValidCredentials(String email, String password,
                                          String firstName, String lastName){
        authPage = homePage.navigateToAuthenticationPage();
        authPage.enterEmail_Login(email);
        authPage.enterPassword_Login(password);
        homePage=authPage.pressLoginButton();

        String ExpectedName = firstName.concat(" ").concat(lastName);
        String ActualName = homePage.getLoggedInName();
        Assert.assertEquals(ActualName,ExpectedName,"User Logged in successfully with the expected Name");
        isUserLoggedIn = true;
    }
}
