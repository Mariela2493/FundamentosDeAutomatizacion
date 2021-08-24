package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private  By currencyChangeLocator = By.xpath("//*[@id=\"form-currency\"]/div/button");
    private By dollarCurrencyLocator= By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");
    private By euroCurrencyLocator= By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    private By poundCurrencyLocator= By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");

    public HeaderPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }

    public void clickChangeCurrency(){
        driver.findElement(currencyChangeLocator).click();
    }

    public void changeCurrencyToDollar(){
        clickChangeCurrency();
        driver.findElement(dollarCurrencyLocator).click();
    }
    public void changeCurrencyToEuro(){
        clickChangeCurrency();
        driver.findElement(euroCurrencyLocator).click();
    }
    public void changeCurrencyToPound(){
        clickChangeCurrency();
        driver.findElement(poundCurrencyLocator).click();
    }
}
