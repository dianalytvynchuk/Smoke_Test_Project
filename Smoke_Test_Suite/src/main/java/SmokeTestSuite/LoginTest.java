package SmokeTestSuite;

import SmokeTestSuite.steps.LoginSteps;
import com.google.inject.Inject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Inject
    LoginSteps loginSteps;
    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {"lytvynchukdiana0@gmail.com", "Qwertyuiop1"},
                {"0507414938", "Qwertyuiop1"},
        };
    }
    @Test(dataProvider = "validLoginData")
public void successfulLoginTest(String userLogin, String userPassword){
    loginSteps.goToHomePage();
    loginSteps.clickUserIcon();
    loginSteps.enterLoginData(userLogin, userPassword);
    loginSteps.checkThatCaptchaIsDisplayed();
    }
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"", "Qwertyuiop1"},
                {"lytvynchukdiana0@gmail.com", ""},
        };
    }
    @Test(dataProvider = "invalidLoginData")
    public void unsuccessfulLoginTest(String userLogin, String userPassword) {
        loginSteps.goToHomePage();
        loginSteps.clickUserIcon();
        loginSteps.enterLoginData(userLogin, userPassword);
        loginSteps.checkThatInputBorderColorIsChanged();
    }
}
