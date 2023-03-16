package SmokeTestSuite.steps;

import org.testng.annotations.Guice;

@Guice
public class CompareProductsSteps extends BaseSteps{
    public void addFirstProductToCompareProductsPage(String firstProduct) {
      basePage.fillSearchInputWithData(firstProduct);
      productPage.addProductToCompareProductsPage();
    }
    public void addSecondProductToCompareProductsPage(String secondProduct) {
        basePage.fillSearchInputWithData(secondProduct);
        productPage.addProductToCompareProductsPage();
    }

    public void openCompareProductsPage() {
        basePage.openCompareProductsWindow();
        basePage.openCompareProductsPage();
    }
    public String getMessageTextFromCompareProductsPage() {
        return  compareProductsPage.getMessageText();
    }

    public String getFirstProductName() {
        return compareProductsPage.getFirstProductName();
    }

    public String getSecondProductName() {
        return compareProductsPage.getSecondProductName();
    }
}
