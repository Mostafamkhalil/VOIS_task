package pages;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;
    public static int WaitTime = 15;
    private By Sign_in_button_Locator = By.xpath("//a[@title='Log in to your customer account']");
    private By Sign_out_button_Locator = By.xpath("//a[@title='Log me out']");
    private By Cst_account_button_Locator = By.xpath("//a[@title='View my customer account']");
    private By Logout_button_Locator = By.xpath("//a[@title='Log me out']");
    private By FirstProduct_hover_Locator = By.xpath("(//ul[@id='homefeatured'] //li)[1]");
    private By Name_FirstProduct_Locator = By.xpath("(//ul[@id='homefeatured'] //li)[1] //a[@class='product-name']");
    private By AddToCart_FirstProduct_button_Locator = By.xpath("(//ul[@id='homefeatured'] //li)[1] //a[@title='Add to cart']");
    private By ProceedToCheckout_button_Locator = By.xpath("//a[@title='Proceed to checkout']");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public AuthenticationPage navigateToAuthenticationPage(){

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Sign_in_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(Sign_in_button_Locator).click();
        return new AuthenticationPage(driver);
    }

    public String getLoggedInName(){
        String loggedInName = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Cst_account_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        loggedInName = driver.findElement(Cst_account_button_Locator).getText();
        return loggedInName;
    }

    public void logout(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Logout_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.findElement(Logout_button_Locator).click();
    }

    public void validateLoggedOutSuccessfully(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Sign_in_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void hoverOnFirstProduct(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(FirstProduct_hover_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement productHover = driver.findElement(FirstProduct_hover_Locator);
        scrollIntoView(productHover);
        Actions actions = new Actions(driver);
        actions.moveToElement(productHover).perform();
    }

    public String getFirstProductName(){
        return driver.findElement(Name_FirstProduct_Locator).getText();
    }

    public void clickOnAddToCart_firstProduct(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AddToCart_FirstProduct_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.findElement(AddToCart_FirstProduct_button_Locator).click();
    }

    public CartPage pressOnProceedToCheckout(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ProceedToCheckout_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.findElement(ProceedToCheckout_button_Locator).click();
        return new CartPage(driver);
    }

    private void scrollIntoView(WebElement element){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,element);
    }
}
