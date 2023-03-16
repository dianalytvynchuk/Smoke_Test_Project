package SmokeTestSuite.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchResultsPage extends BasePage{

    private static final String PRODUCT_TITLE = "//a[@title='Гантелі для фітнесу Neo Sport 2 кг 2 шт. (NS2KGX2)']";
    private static final String TITLE_ATTRIBUTE = "title";
    private static final String MESSAGE_TEXT_BLOCK = "//div[@class = 'catalog-empty']";
    private static final String SORT_BY_PRICE_FROM_LOWEST_TO_HIGHEST_OPTION = "//option[text()='Від дешевих до дорогих']";
    private static final String PRICE_VALUE_BLOCK = "//span[@class='goods-tile__price-value']";
    private static final String SORT_BY_PRICE_FROM_HIGHEST_TO_LOWEST_OPTION = "//option[text()='Від дорогих до дешевих']";
    public String getTextMessage() {
        return $x(MESSAGE_TEXT_BLOCK).getText();
    }

    public void sortProductsByPriceFromLowestToHighest() {
        $x(SORT_BY_PRICE_FROM_LOWEST_TO_HIGHEST_OPTION).shouldBe(interactable).click();
    }

    public void checkProductsAreSortedByPriceFromLowestToHighest() {
        ElementsCollection priceList = $$x(PRICE_VALUE_BLOCK);
        List<String> productPriceList = new ArrayList<>();
        for(SelenideElement price: priceList){
            productPriceList.add(price.getText());
        }
        List<String> productPriceListExpected = productPriceList;
        Collections.sort(productPriceListExpected);
        assertThat(productPriceList).isEqualTo(productPriceListExpected);
    }

    public void sortProductsByPriceFromHighestToLowest() {
        $x(SORT_BY_PRICE_FROM_HIGHEST_TO_LOWEST_OPTION).shouldBe(interactable).click();
    }

    public void checkProductsAreSortedByPriceFromHighestToLowest() {
        ElementsCollection priceList = $$x(PRICE_VALUE_BLOCK);
        List<String> productPriceList = new ArrayList<>();
        for(SelenideElement price: priceList){
            productPriceList.add(price.getText());
        }
        List<String> productPriceListExpected = productPriceList;
        Collections.sort(productPriceListExpected, Collections.reverseOrder());
        assertThat(productPriceList).isEqualTo(productPriceListExpected);
    }

    public String getProductNameFromSearchResultsPage() {
       return $x(PRODUCT_TITLE).getAttribute(TITLE_ATTRIBUTE);
    }
}
