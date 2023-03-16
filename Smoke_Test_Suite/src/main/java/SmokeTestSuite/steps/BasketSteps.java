package SmokeTestSuite.steps;

import org.testng.annotations.Guice;

@Guice
public class BasketSteps extends BaseSteps{
    public void openComputerMouseProductPage(String subcategoryName, String productName) {
        basePage.openCategoriesWindow();
        basePage.pickComputersNotebooksCategory();
        categoriesPage.openKeyboardMouseSubcategoryPage(subcategoryName);
        subcategoryPage.openComputerMouseProductPage(productName);
    }

    public void addProductToBasket() {
        productPage.addProductToBasket();
    }

    public String getProductNameFromBasketWindow() {
        basePage.openBasketWindow();
        return productPage.getProductTitleFromBasketWindow();
    }

    public void openFirstProductPage(String firstProduct) {
        basePage.fillSearchInputWithData(firstProduct);
    }

    public void openSecondProductPage(String secondProduct) {
        basePage.fillSearchInputWithData(secondProduct);
    }

    public String getTotalCostFromBasketWindow() {
        basePage.openBasketWindow();
        return productPage.getTotalCostFromBasketWindow();
    }
}
