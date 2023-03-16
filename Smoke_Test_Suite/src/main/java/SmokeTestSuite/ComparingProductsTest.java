package SmokeTestSuite;

import SmokeTestSuite.steps.CompareProductsSteps;
import com.google.inject.Inject;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparingProductsTest extends BaseTest{
    private static final String FIRST_PRODUCT_HEADING = "Ноутбук Acer Aspire 7 A715-42G-R3EZ (NH.QBFEU.00C) Charcoal Black";
    private static final String SECOND_PRODUCT_HEADING = "Ноутбук ASUS TUF Gaming A15 FA506ICB-HN119 (90NR0667-M00KT0) Graphite Black";
    private static final String MESSAGE_TEXT = "Недостатньо товарів для порівняння";
    @Inject
    CompareProductsSteps compareProductsSteps;
    @DataProvider(name = "productsOfOneCategorySearchingData")
    public Object[][] productsOfOneCategorySearchingData() {
        return new Object[][]{
                {"Ноутбук Acer Aspire 7 A715-42G-R3EZ/ RAM 16 ГБ",
                 "Ноутбук ASUS TUF Gaming A15 FA506ICB-HN119/ RAM 16 ГБ"},
        };
    }
    @Test(dataProvider = "productsOfOneCategorySearchingData")
    public void compareProductsOfOneCategoryTest(String firstProduct, String secondProduct) {
        compareProductsSteps.addFirstProductToCompareProductsPage(firstProduct);
        compareProductsSteps.addSecondProductToCompareProductsPage(secondProduct);
        compareProductsSteps.openCompareProductsPage();
        String firstProductName = compareProductsSteps.getFirstProductName();
        assertThat(firstProductName).contains(FIRST_PRODUCT_HEADING);
        String secondProductName = compareProductsSteps.getSecondProductName();
        assertThat(secondProductName).contains(SECOND_PRODUCT_HEADING);
    }
    @DataProvider(name = "productsOfDifferentCategoriesSearchingData")
    public Object[][] productsOfDifferentCategoriesSearchingData() {
        return new Object[][]{
                {"Ноутбук Acer Aspire 7 A715-42G-R3EZ/ RAM 16 ГБ",
                 "Гантелі для фітнесу Neo Sport 2 кг 2 шт. (NS2KGX2)"},
        };
    }
    @Test(dataProvider = "productsOfDifferentCategoriesSearchingData")
    public void compareProductsOfDifferentCategoriesTest(String firstProduct, String secondProduct){
        compareProductsSteps.addFirstProductToCompareProductsPage(firstProduct);
        compareProductsSteps.addSecondProductToCompareProductsPage(secondProduct);
        compareProductsSteps.openCompareProductsPage();
        String messageText = compareProductsSteps.getMessageTextFromCompareProductsPage();
        AssertionsForClassTypes.assertThat(messageText).contains(MESSAGE_TEXT);
    }
}
