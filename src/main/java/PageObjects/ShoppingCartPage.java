package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BaseClass{

    public String ProductNameLocator = "//table/tbody/tr/td/a[text()='<name>']";
    public By ProductQuantityLocator = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input");
    private By errorCheckingOut = By.xpath ("//*[@id='checkout-cart']/div[1]");
    private By totalAmount= By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]");


    public ShoppingCartPage(WebDriver _driver){
        this.driver = _driver;
    }

    public boolean isProductNameDisplayed(String name){
        return driver.findElement(By.xpath(ProductNameLocator.replace("<name>", name))).isDisplayed();
    }
    public int getProductQuantity(){
        return Integer.parseInt(driver.findElement(ProductQuantityLocator).getAttribute("value"));
    }
    public String checkOutMessage(){
        String errorMessage=  driver.findElement(errorCheckingOut).getText();
        System.out.println(errorMessage);
        return errorMessage;
    }

    public String catchProductPriceOnShoppingCart(){
        String TotalAmount=  driver.findElement(totalAmount).getText();
        return TotalAmount;

    }
}
