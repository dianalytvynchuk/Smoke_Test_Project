package SmokeTestSuite.steps;

import org.testng.annotations.Guice;

@Guice
public class ProductSearchingSteps extends BaseSteps{
   public void fillSearchInputWithData(String searchData) {
      basePage.fillSearchInputWithData(searchData);
   }
   public String getTextMessageFromSearchResultsPage() {
   return searchResultsPage.getTextMessage();
   }

   public String getProductNameFromSearchResultsPage() {
      return searchResultsPage.getProductNameFromSearchResultsPage();
   }
}
