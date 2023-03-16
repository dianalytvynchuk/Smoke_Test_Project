package SmokeTestSuite;

import SmokeTestSuite.steps.BaseSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;

@Guice
public class BaseTest {
    WebDriver driver;
    @Inject
    BaseSteps baseSteps;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout =10000;
        driver.manage().window().maximize();

        baseSteps.goToHomePage();
    }
    //Before Method data for Selenium Grid
//@BeforeMethod
//public void setUp() throws MalformedURLException {
//    DesiredCapabilities caps = new  DesiredCapabilities();
//    caps.setCapability("demo_capability", true);
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("disable-infobars");
//    options.merge(caps);
//    driver = new RemoteWebDriver(new URL("http://192.168.31.74:4444"), options);
//    driver.manage().window().maximize();
//    WebDriverRunner.setWebDriver(driver);
//    Configuration.timeout = 10000;
//    baseSteps.goToHomePage();
//}
    @AfterMethod
    public void turnDown(){
        driver.quit();
    }
}
