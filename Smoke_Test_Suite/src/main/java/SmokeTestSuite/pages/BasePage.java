package SmokeTestSuite.pages;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private static final String USER_ICON = "//rz-user/button";
    private static final String SEARCH_INPUT = "//input[@name = 'search']";
    private static final String SEARCH_BUTTON = "//form/button";
    private static final String CATALOG_BUTTON = "//button[@id='fat-menu']";
    private static final String COMPUTERS_NOTEBOOKS_CATEGORY_LINK = "a[href^='https://rozetka.com.ua/ua/computers-notebooks/c80253/']";
    private static final String COMPUTERS_NOTEBOOKS_CATEGORY_PAGE_TITLE = "Комп'ютери та ноутбуки";
    private static final String COMPARE_ICON = "[aria-label='Списки порівнянь']";
    private static final String COMPARISON_MODAL_LINK = "[class='comparison-modal__link']";
    private static final String BASKET_ICON = "//rz-cart/button";
    public void openLoginForm() {

        $x(USER_ICON).click();
    }

    public void fillSearchInputWithData(String searchData) {
        $x(SEARCH_INPUT).shouldBe(interactable).sendKeys(searchData);
        $x(SEARCH_BUTTON).click();
    }

    public void openCategoriesWindow() {

        $x(CATALOG_BUTTON).click();
    }
    public void pickComputersNotebooksCategory() {
        $(COMPUTERS_NOTEBOOKS_CATEGORY_LINK).click();
        title().contains(COMPUTERS_NOTEBOOKS_CATEGORY_PAGE_TITLE);
    }

    public void openCompareProductsWindow() {
        $(COMPARE_ICON).click();
    }

    public void openCompareProductsPage() {
        $(COMPARISON_MODAL_LINK).click();
    }

    public void openBasketWindow() {
        $x(BASKET_ICON).click();
    }
}
