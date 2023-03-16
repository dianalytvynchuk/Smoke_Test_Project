package SmokeTestSuite.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class SubcategoryPage extends BasePage{
    private static final String PRODUCT_PAGE_TITLE= "[title='%s']";
    private static final String COMPUTER_MOUSE_PAGE_TITLE = "Миша HyperX Pulsefire Haste USB Black";
    public void openComputerMouseProductPage(String productName) {
        $(String.format(PRODUCT_PAGE_TITLE, productName)).click();
        title().contains(COMPUTER_MOUSE_PAGE_TITLE);
    }
}
