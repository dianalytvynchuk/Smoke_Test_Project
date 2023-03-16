package SmokeTestSuite.steps;

import SmokeTestSuite.pages.*;
import com.google.inject.Inject;
import org.testng.annotations.Guice;



@Guice
public class BaseSteps {
  @Inject
    BasePage basePage;
   @Inject
    HomePage homePage;
    @Inject
    CategoriesPage categoriesPage;
   @Inject
    SubcategoryPage subcategoryPage;
   @Inject
    ProductPage productPage;
   @Inject
    CompareProductsPage compareProductsPage;
   @Inject
    SearchResultsPage searchResultsPage;

    public void goToHomePage() {
        homePage.open();
    }
}
