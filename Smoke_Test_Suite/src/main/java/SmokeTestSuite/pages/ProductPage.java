package SmokeTestSuite.pages;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage {

    private static final String COMPARE_PRODUCT_BUTTON = "//rz-app-compare-button[@class ='medium']";
    private static final String PRODUCT_BUY_BUTTON = "//app-buy-button/button";
    private static final String CLOSE_WINDOW_BUTTON = "//button[@class='modal__close']";
    private static final String PRODUCT_TITLE_IN_BASKET = "//a[@class='cart-product__title']";
    private static final String TITLE_ATTRIBUTE = "title";
    private static final String TOTAL_PRICE_BLOCK = "//div[@class='cart-receipt__sum-price']/span";
    public void addProductToCompareProductsPage() {
        $x(COMPARE_PRODUCT_BUTTON).shouldBe(interactable).click();
    }

    public void addProductToBasket() {
        $x(PRODUCT_BUY_BUTTON).shouldBe(interactable).click();
        $x(CLOSE_WINDOW_BUTTON).shouldBe(interactable).click();
    }

    public String getProductTitleFromBasketWindow() {
        return $x(PRODUCT_TITLE_IN_BASKET).getAttribute(TITLE_ATTRIBUTE);
    }

    public String getTotalCostFromBasketWindow() {
        return $x(TOTAL_PRICE_BLOCK).getText();
    }
}
