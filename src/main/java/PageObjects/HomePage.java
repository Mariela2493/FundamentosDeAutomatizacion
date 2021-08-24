package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass{
    //Elementos
    private By searchBar = By.name("search");
    private By searchButton = By.xpath("//div[@id='search']/span/button");

    public HomePage(WebDriver _driver){
        this.driver = _driver;
    }

    public String getFirstProductName(){
        return driver.findElement(HomePageLocators.FirstProductTitleSelector).getText();
    }
    public void selectProductByName(String name){
        driver.findElement(By.xpath(HomePageLocators.FirstH4Locator.replace("<name>", name))).click();
    }
    public String selectFirstProductAndGetName(){
        String name = getFirstProductName();
        selectProductByName(name);
        return name;
    }

    public void  searchForProduct( String searchTestCriteria){
        WebElement searchInput = driver.findElement(searchBar);
        searchInput.sendKeys(searchTestCriteria);
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

    }
}
