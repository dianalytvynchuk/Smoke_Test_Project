package SmokeTestSuite.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePage extends BasePage{

    private static final String ROZETKA_URL = "https://rozetka.com.ua/ua/";
    private static final String LOGIN_INPUT = "[formcontrolname='login']";
    private static final String PASSWORD_INPUT = "[formcontrolname='password']";
    private static final String SUBMIT_BUTTON = "button.button--large.button--green.auth-modal__submit";
    private static final String CAPTCHA_FRAME = "[title='reCAPTCHA']";
    private static final String CAPTCHA_CONTAINER = "#rc-anchor-container";
    private static final String CAPTCHA_CONTAINER_ID = "id";
    private static final String CAPTCHA_CONTAINER_ID_ATTRIBUTE = "rc-anchor-container";
    private static final String VALIDATION_TYPE_ERROR = "//div[@class='form__row validation_type_error']";

    public void open() {
        Selenide.open(ROZETKA_URL);
    }

    public void enterUserLogin(String userLogin) {
        $(LOGIN_INPUT).sendKeys(userLogin);
    }
    public void enterUserPassword(String userPassword) {
        $(PASSWORD_INPUT).sendKeys(userPassword);
    }
    public void clickSubmitButton() {
        $(SUBMIT_BUTTON).click();
    }

    public void verifyThatCaptchaIsDisplayed() {
        WebElement iframeCaptcha = $(CAPTCHA_FRAME);
        switchTo().frame(iframeCaptcha);
        String captchaId = $(CAPTCHA_CONTAINER).getAttribute(CAPTCHA_CONTAINER_ID);
        assertThat(captchaId).contains(CAPTCHA_CONTAINER_ID_ATTRIBUTE);
    }

    public void verifyThatInputBorderColorIsChanged() {
        $x(VALIDATION_TYPE_ERROR);
    }

}
