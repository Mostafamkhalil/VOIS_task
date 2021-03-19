package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.HomePage.WaitTime;

public class AuthenticationPage {
    WebDriver driver;
    private By email_signIn_Locator = By.id("email");
    private By password_signIn_Locator = By.id("passwd");
    private By signIn_button_Locator = By.id("SubmitLogin");
    private By email_signUp_Locator = By.id("email_create");
    private By signUp_button_Locator = By.id("SubmitCreate");

    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
    }


    public void enterEmail_Login(String email){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(email_signIn_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(email_signIn_Locator).sendKeys(email);
    }

    public void enterPassword_Login(String password){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password_signIn_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(password_signIn_Locator).sendKeys(password);
    }

    public HomePage pressLoginButton(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signIn_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(signIn_button_Locator).click();
        return new HomePage(driver);
    }

    public void enterEmail_SignUp(String email){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(email_signUp_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(email_signUp_Locator).sendKeys(email);
    }

    public RegistrationPage pressCreateAccountButton(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signUp_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(signUp_button_Locator).click();
        return new RegistrationPage(driver);
    }
}
