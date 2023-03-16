package SmokeTestSuite;

import SmokeTestSuite.steps.BasketSteps;
import com.google.inject.Inject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class BasketTest extends BaseTest{
    private static final String PRODUCT_TITLE = "Миша HyperX Pulsefire Haste USB Black";
    private static final String TOTAL_COST = "41 898";
    @Inject
    BasketSteps  basketSteps;

    @DataProvider(name = "addProductToBasketData")
    public Object[][] addProductToBasketData() {
        return new Object[][]{
                {"Клавіатури та миші",
                 "Миша HyperX Pulsefire Haste USB Black (HMSH1-A-BK/G/4P5P9AA)"},
        };
    }
    @Test(dataProvider = "addProductToBasketData")
    public void addProductToBasketTest(String subcategoryName, String productName){
        basketSteps.openComputerMouseProductPage(subcategoryName, productName);
        basketSteps.addProductToBasket();
        String productTitle = basketSteps.getProductNameFromBasketWindow();
        assertThat(productTitle).contains(PRODUCT_TITLE);
    }
    @DataProvider(name = "addProductsToBasketData")
    public Object[][] addProductsToBasketData() {
        return new Object[][]{
                {"Планшет Samsung Galaxy Tab A7 Lite LTE 32GB Grey (SM-T225NZAASEK)",
                 "Ноутбук ASUS TUF Gaming A15 FA506ICB-HN119/ RAM 16 ГБ"},
        };
    }
    @Test(dataProvider = "addProductsToBasketData")
    public void calculateTotalCostOfProductsInBasketTest(String firstProduct, String secondProduct){
        basketSteps.openFirstProductPage(firstProduct);
        basketSteps.addProductToBasket();
        basketSteps.openSecondProductPage(secondProduct);
        basketSteps.addProductToBasket();
        String totalCost = basketSteps.getTotalCostFromBasketWindow();
        assertThat(totalCost).contains(TOTAL_COST);
    }

}
