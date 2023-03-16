package SmokeTestSuite.pages;

import static com.codeborne.selenide.Selenide.$x;

public class CompareProductsPage extends BasePage{
    private static final String MESSAGE_TEXT_BLOCK = "//rz-products-section/div";
    private static final String FIRST_PRODUCT_LINK = "//a[@href='https://rozetka.com.ua/ua/acer_nh_qbfeu_00c/p288376303/']";
    private static final String SECOND_PRODUCT_LINK = "//a[@href='https://rozetka.com.ua/ua/asus-90nr0667-m00kt0/p362023689/']";
    private static final String ATTRIBUTE = "innerHTML";

    public String getMessageText() {
        return $x(MESSAGE_TEXT_BLOCK).getText();
    }
    public String getFirstProductName() {
        return $x(FIRST_PRODUCT_LINK).getAttribute(ATTRIBUTE);
    }
    public String getSecondProductName() {
        return $x(SECOND_PRODUCT_LINK).getAttribute(ATTRIBUTE);
    }
}
