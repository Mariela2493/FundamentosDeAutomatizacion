package selenium;

import PageObjects.BaseClass;
import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAccount extends BaseClass {

    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "mariela.sanchez.fallas@ucreaativa.com";
        String password = "12345";

        //Go To Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();


        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Description("Validate that the login is working with non valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful(){



        LoginPage loginPage = new LoginPage(driver);
        String username = "mariela.sanchez.fallas@ucreaativa.com";
        String password = "12345";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage.GoTo();
        loginPage.login(username, password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }

    @Test
    public void Test_Create_New_Account(){
        //SETUP
        String firstName = "Mariela";
        String lastName = "Sanchez";
        String email = "mariesafa@email.com";
        String telephone = "22222222";
        String password = "12345";
        String expectedMessage = "Your Account Has Been Created!";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetConfirmationMessage(), expectedMessage);
    }


}
