package SmokeTestSuite.steps;

import org.testng.annotations.Guice;

@Guice
public class LoginSteps extends BaseSteps{
    public void clickUserIcon() {
        basePage.openLoginForm();
    }

    public void enterLoginData(String userLogin, String userPassword) {
        homePage.enterUserLogin(userLogin);
        homePage.enterUserPassword(userPassword);
        homePage.clickSubmitButton();
    }
    public void checkThatCaptchaIsDisplayed() {
        homePage.verifyThatCaptchaIsDisplayed();
    }
    public void checkThatInputBorderColorIsChanged() {
        homePage.verifyThatInputBorderColorIsChanged();
    }
}
