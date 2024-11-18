package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        // click on Sign In button
        driver.findElement(By.linkText("Sign In")).click();

        //verify the Welcome Back text
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//article[@class = 'sign-in__form']/h2")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Welcome Back text not verify", expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {

        // click on Sign In button
        driver.findElement(By.linkText("Sign In")).click();

        // Enter the required details
        driver.findElement(By.id("user[email]")).sendKeys("abc@test.com");
        driver.findElement(By.id("user[password]")).sendKeys("asdcvbn");

        // click on Sign in button
        driver.findElement(By.xpath("//button[@class = 'button button-primary g-recaptcha']")).click();

        //getting error message
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.className("form-error__list-item")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Error message is not match", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
