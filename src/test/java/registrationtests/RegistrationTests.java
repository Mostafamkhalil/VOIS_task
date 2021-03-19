package registrationtests;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AuthenticationPage;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {
    AuthenticationPage authPage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void logOutIfAlreadyLoggedIn(){
        if(isUserLoggedIn == true){
            homePage.logout();
            homePage.validateLoggedOutSuccessfully();
            isUserLoggedIn = false;
        }
    }

    @Test(dataProvider = "registrationData", dataProviderClass = RegistrationDDT.class)
    public void userCanRegisterNewAccount(String email, String firstName, String lastName,
                                          String gender, String password, String address,
                                          String city, String state, String postalCode,
                                          String country, String mobilePhone){
        authPage = homePage.navigateToAuthenticationPage();
        authPage.enterEmail_SignUp(email);
        registrationPage = authPage.pressCreateAccountButton();
        registrationPage.chooseGender(gender);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterPassword(password);
        registrationPage.enterAddress(address);
        registrationPage.enterCity(city);
        registrationPage.chooseState(state);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.chooseCountry(country);
        registrationPage.enterMobileNumber(mobilePhone);
        registrationPage.pressRegisterButton();

        String ExpectedName = firstName.concat(" ").concat(lastName);
        String ActualName = registrationPage.getRegisteredInName();
        Assert.assertEquals(ActualName,ExpectedName,"User Logged in successfully with the expected Name");
        isUserLoggedIn = true;
    }

}
