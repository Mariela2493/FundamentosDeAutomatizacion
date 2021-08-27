package selenium;

import PageObjects.*;
import dataProviders.ProductPricesProvider;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ProductsPrices;
import pojo.UserAccount;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){

        int quantity = 5;

        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());
        headerPage.clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(shoppingCartPage.getProductQuantity(), quantity, "Quantity is not matching");

    }
    //Segundo caso de Prueba
    @Test
    public void elementCantBeCheckOut(){
        String searchTestCriteria= "macbook air";
        String expectedMessageAddingToCart= "Success: You have added MacBook Air to your shopping cart!";
        String expectedErrorMessageCheckOut= "Products marked with *** are not available in the desired quantity or not in stock!";
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct(searchTestCriteria);
        SearchResultsPage searchResultsPage = new  SearchResultsPage(driver);
        searchResultsPage.clickAddToCart();
        Assert.assertTrue(searchResultsPage.catchProductAddedToCartMessage().contains(expectedMessageAddingToCart));
        searchResultsPage.ShoppingCartPreview();
        searchResultsPage.clickCheckOutLink();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.checkOutMessage().contains(expectedErrorMessageCheckOut));
    }

    //Tercer  caso de Prueba Proyecto
    @Test(dataProvider = "getProductPricesDataFromJson", dataProviderClass = ProductPricesProvider.class)
    public void Test_Currency_Values(ProductsPrices testProduct) {

        int quantity = 1;
        HomePage homePage =new HomePage(driver);
        homePage.searchForProduct(testProduct.getProduct());
        ProductPage productPage= new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String name = homePage.selectFirstProductAndGetName();
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        headerPage().clickOnCartButton();

        headerPage().changeCurrencyToDollar();
        String dollarTotalAmount = shoppingCartPage.catchProductPriceOnShoppingCart();
        headerPage().changeCurrencyToEuro();
        String euroTotalAmount =shoppingCartPage.catchProductPriceOnShoppingCart();
        headerPage().changeCurrencyToPound();
        String poundTotalAmount=shoppingCartPage.catchProductPriceOnShoppingCart();

        //Assertions
        double dolar= Utils.returnDouble(dollarTotalAmount);
        double euro =Utils.returnDouble(euroTotalAmount);
        double pound=Utils.returnDouble(poundTotalAmount);
        Assert.assertEquals(dolar,testProduct.getDolarsPrice());
        Assert.assertEquals(euro,testProduct.getEuroPrice());
        Assert.assertEquals(pound,testProduct.getPoundsPrice());
    }

}
