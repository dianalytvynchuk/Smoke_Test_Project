package SmokeTestSuite;

import SmokeTestSuite.steps.ProductSearchingSteps;
import com.google.inject.Inject;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ProductSearchingTest extends BaseTest{
    private static final String PRODUCT_NAME = "Гантелі для фітнесу Neo Sport 2 кг 2 шт. (NS2KGX2)";
    private static final String VALID_SEARCH_DATA = "гантелі  Neo Sport 2 кг";
    private static final String INVALID_SEARCH_DATA = "гантелі  Neo Sport 2 ru";
    private static final String MESSAGE_TEXT = "За заданими параметрами не знайдено жодної моделі";
    @Inject
    ProductSearchingSteps productSearchingSteps;
    @Test
    public void successfulProductSearchingTest(){
        productSearchingSteps.fillSearchInputWithData(VALID_SEARCH_DATA);
        String productName = productSearchingSteps.getProductNameFromSearchResultsPage();
        assertThat(productName).isEqualTo(PRODUCT_NAME);
    }
    @Test
    public void unsuccessfulProductSearchingTest() {
        productSearchingSteps.fillSearchInputWithData(INVALID_SEARCH_DATA);
        String textMessage = productSearchingSteps.getTextMessageFromSearchResultsPage();
        AssertionsForClassTypes.assertThat(textMessage).contains(MESSAGE_TEXT);
    }
}
