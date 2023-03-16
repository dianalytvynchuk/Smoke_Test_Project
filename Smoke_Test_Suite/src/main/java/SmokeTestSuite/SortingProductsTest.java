package SmokeTestSuite;

import SmokeTestSuite.steps.SortingSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

public class SortingProductsTest extends BaseTest {
    private static final String SEARCH_DATA = "Мобільні телефони";
    @Inject
    SortingSteps sortingSteps;
    @Test
    public void sortProductsByPriceFromLowestToHighestTest() {
        sortingSteps.searchProductsUsingSearchInput(SEARCH_DATA);
        sortingSteps.sortProductsByPriceFromLowestToHighest();
        sortingSteps.checkProductsAreSortedByPriceFromLowestToHighest();
    }
    @Test
    public void sortProductsByPriceFromHighestToLowestTest() {
        sortingSteps.searchProductsUsingSearchInput(SEARCH_DATA);
        sortingSteps.sortProductsByPriceFromHighestToLowest();
        sortingSteps.checkProductsAreSortedByPriceFromHighestToLowest();
    }
}
