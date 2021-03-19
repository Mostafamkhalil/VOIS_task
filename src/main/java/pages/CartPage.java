package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.HomePage.WaitTime;

public class CartPage {
    WebDriver driver;
    private By cartSummaryTitle_text_Locator = By.id("cart_title");
    private By pageTitle_text_Locator = By.xpath("//h1[@class='page-heading']");
    private By Name_FirstProductInCart_text_Locator =
            By.xpath("(//table[@id='cart_summary'] //p[@class='product-name'])[1]");
    private By Proceed_Summary_button_Locator =
            By.xpath("//div[@id='center_column'] //a[@title='Proceed to checkout']");
    private By Proceed_Address_button_Locator =
            By.xpath("//button[@name='processAddress']");
    private By Proceed_Shipping_button_Locator =
            By.xpath("//button[@name='processCarrier']");
    private By AgreeOnTerms_checkBox_Locator =
            By.xpath("//input[@type='checkbox']");
    private By PayWithBankWire_button_Locator = By.xpath("//a[@class='bankwire']");
    private By confirmOrder_button_Locator = By.xpath("//div[@id='center_column'] //button[@type='submit']");


    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    public void waitUntilCartPageLoads(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartSummaryTitle_text_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getProductNameInCart(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(Name_FirstProductInCart_text_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return driver.findElement(Name_FirstProductInCart_text_Locator).getText();
    }

    public void summaryProceed(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(Proceed_Summary_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement proceedButton = driver.findElement(Proceed_Summary_button_Locator);
        scrollIntoView(proceedButton);
        proceedButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.invisibilityOf(proceedButton));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getPageTitle(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(pageTitle_text_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return driver.findElement(pageTitle_text_Locator).getText();
    }

    public void addressProceed(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(Proceed_Address_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement proceedButton = driver.findElement(Proceed_Address_button_Locator);
        scrollIntoView(proceedButton);
        proceedButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.invisibilityOf(proceedButton));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void agreeOnTermsAndConditions(){
        WebElement checkbox = driver.findElement(AgreeOnTerms_checkBox_Locator);
        scrollIntoView(checkbox);
        checkbox.click();
    }

    public void shippingProceed(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(Proceed_Shipping_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement proceedButton = driver.findElement(Proceed_Shipping_button_Locator);
        scrollIntoView(proceedButton);
        proceedButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.invisibilityOf(proceedButton));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void payByBankWire(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(PayWithBankWire_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement proceedButton = driver.findElement(PayWithBankWire_button_Locator);
        scrollIntoView(proceedButton);
        proceedButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.invisibilityOf(proceedButton));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void confirmOrder(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(confirmOrder_button_Locator)));
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement proceedButton = driver.findElement(confirmOrder_button_Locator);
        scrollIntoView(proceedButton);
        proceedButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, WaitTime);
            wait.until(ExpectedConditions.invisibilityOf(proceedButton));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void scrollIntoView(WebElement element){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,element);
    }

}
