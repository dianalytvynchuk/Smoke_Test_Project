package SmokeTestSuite.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class CategoriesPage extends BasePage{
    private static final String KEYBOARD_MOUSE_SUBCATEGORY_PAGE_TITLE = "Клавіатури та миші";
    private static final String SUBCATEGORY_PAGE_TITLE= "[title='%s']";
    public void openKeyboardMouseSubcategoryPage(String subcategoryName) {
      $(String.format(SUBCATEGORY_PAGE_TITLE, subcategoryName)).click();
      title().contains(KEYBOARD_MOUSE_SUBCATEGORY_PAGE_TITLE);
    }
}
