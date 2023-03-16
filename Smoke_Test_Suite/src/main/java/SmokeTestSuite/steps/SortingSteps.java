package SmokeTestSuite.steps;

import org.testng.annotations.Guice;

@Guice
public class SortingSteps extends BaseSteps{
    public void searchProductsUsingSearchInput(String searchData) {
        basePage.fillSearchInputWithData(searchData);
    }

    public void sortProductsByPriceFromLowestToHighest() {
        searchResultsPage.sortProductsByPriceFromLowestToHighest();
    }

    public void checkProductsAreSortedByPriceFromLowestToHighest() {
        searchResultsPage.checkProductsAreSortedByPriceFromLowestToHighest();
    }

    public void sortProductsByPriceFromHighestToLowest() {
        searchResultsPage.sortProductsByPriceFromHighestToLowest();
    }

    public void checkProductsAreSortedByPriceFromHighestToLowest() {
        searchResultsPage.checkProductsAreSortedByPriceFromHighestToLowest();
    }
}
