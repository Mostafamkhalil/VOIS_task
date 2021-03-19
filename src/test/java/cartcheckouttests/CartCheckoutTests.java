package cartcheckouttests;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartCheckoutTests extends BaseTest {

    CartPage cartPage;

    @Test
    public void userCanCheckoutCart(){
        String ExpectedProductName;
        String ProductNameInCart;
        String pageTitle;
        homePage.hoverOnFirstProduct();
        ExpectedProductName = homePage.getFirstProductName();
        homePage.clickOnAddToCart_firstProduct();
        cartPage = homePage.pressOnProceedToCheckout();
        cartPage.waitUntilCartPageLoads();
        ProductNameInCart = cartPage.getProductNameInCart();
        Assert.assertEquals(ProductNameInCart,ExpectedProductName,"The Product in the cart has the same name");
        cartPage.summaryProceed();
        pageTitle = cartPage.getPageTitle();
        Assert.assertEquals(pageTitle,"ADDRESSES");
        cartPage.addressProceed();
        pageTitle = cartPage.getPageTitle();
        Assert.assertEquals(pageTitle,"SHIPPING");
        cartPage.agreeOnTermsAndConditions();
        cartPage.shippingProceed();
        pageTitle = cartPage.getPageTitle();
        Assert.assertEquals(pageTitle,"PLEASE CHOOSE YOUR PAYMENT METHOD");
        cartPage.payByBankWire();
        pageTitle = cartPage.getPageTitle();
        Assert.assertEquals(pageTitle,"ORDER SUMMARY");
        cartPage.confirmOrder();
        pageTitle = cartPage.getPageTitle();
        Assert.assertEquals(pageTitle,"ORDER CONFIRMATION");
        System.out.println(pageTitle);
    }
}
