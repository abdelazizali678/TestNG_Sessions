package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
// @Test(enabled = false)  //enabled property for the whole class
public class Assertions {

    private SoftAssert softAssert;
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    // @Ignore   //Ignore annotation as same as enabled property
    @Test(priority = 2 ,groups = {"Regression"})
    public void HardAssertValidLoginTestCase(){
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        //Hard Assert
        Assert.assertTrue(expected,"Assert True that expected value is true");

    }

    @Test(priority = 1)
    public void SoftAssertValidLoginTestCase(){
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        softAssert = new SoftAssert();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        softAssert.assertTrue(expected,"Assert True that expected value is true"); //softAssert
        softAssert.assertAll();

    }

    @Test(priority = 3,groups = {"Regression"})
    public void inValidLoginTestCaseUsingInvalidUsername(){
        driver.findElement(By.id("inputUsername")).sendKeys("ahmed"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        driver.switchTo().alert().accept();
        //hard Assert
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

    }

    @AfterMethod(alwaysRun = true)
    public void quit(){

        driver.quit();
    }
}
