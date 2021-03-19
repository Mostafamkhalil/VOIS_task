package pages;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.HomePage.WaitTime;

public class RegistrationPage {
    WebDriver driver;
    private By Mr_gender_radioBtn_Locator = By.id("id_gender1");
    private By Mrs_gender_radioBtn_Locator = By.id("id_gender2");
    private By FirstName_inputField_Locator = By.id("customer_firstname");
    private By LastName_inputField_Locator = By.id("customer_lastname");
    private By Password_inputField_Locator = By.id("passwd");
    private By Address_inputField_Locator = By.id("address1");
    private By City_inputField_Locator = By.id("city");
    private By State_Dropdown_Locator = By.id("id_state");
    private By PostalCode_inputField_Locator = By.id("postcode");
    private By Country_Dropdown_Locator = By.id("id_country");
    private By Mobile_inputField_Locator = By.id("phone_mobile");
    private By Register_button_Locator = By.id("submitAccount");
    private By WelcomeMessage_text_Locator = By.xpath("//p[contains(.,'Welcome')]");
    private By Cst_account_button_Locator = By.xpath("//a[@title='View my customer account']");

    private void scrollIntoView(WebElement element){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,element);
    }

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void chooseGender(String gender){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Mr_gender_radioBtn_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        if(gender.equalsIgnoreCase("Male")){
            driver.findElement(Mr_gender_radioBtn_Locator).click();
        }
        else if (gender.equalsIgnoreCase("Female")){
            driver.findElement(Mrs_gender_radioBtn_Locator).click();
        }
    }

    public void enterFirstName(String firstName){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(FirstName_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement element = driver.findElement(FirstName_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LastName_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement element = driver.findElement(LastName_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(lastName);
    }

    public void enterPassword(String password){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Password_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement element = driver.findElement(Password_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(password);
    }

    public void enterAddress(String address){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Address_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        WebElement element = driver.findElement(Address_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(address);
    }

    public void enterCity(String city){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(City_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        WebElement element = driver.findElement(City_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(city);
    }

    public void chooseState(String state){
        Select dropDown;
        WebElement element = driver.findElement(State_Dropdown_Locator);
        scrollIntoView(element);
        dropDown = new Select(element);
        dropDown.selectByVisibleText(state);
    }

    public void enterPostalCode(String postalCode){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PostalCode_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        WebElement element = driver.findElement(PostalCode_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(postalCode);
    }

    public void chooseCountry(String country){
        Select dropDown;
        WebElement element = driver.findElement(Country_Dropdown_Locator);
        scrollIntoView(element);
        dropDown = new Select(element);
        dropDown.selectByVisibleText(country);
    }

    public void enterMobileNumber(String mobileNumber){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Mobile_inputField_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        WebElement element = driver.findElement(Mobile_inputField_Locator);
        scrollIntoView(element);
        element.sendKeys(mobileNumber);
    }

    public void pressRegisterButton(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Register_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(Register_button_Locator).click();
    }

    public String getRegisteredInName(){
        String loggedInName = "";

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(WelcomeMessage_text_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Cst_account_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        loggedInName = driver.findElement(Cst_account_button_Locator).getText();
        return loggedInName;
    }




}
