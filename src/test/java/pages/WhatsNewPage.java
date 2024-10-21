package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhatsNewPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class, 'product-item')]")
    private List<WebElement> products;

    @FindBy(xpath = "//a[@class='product-item-link']")
    private List<WebElement> productNames;

    @FindBy(xpath = "//span[@class='price']")
    private List<WebElement> productPrices;



    public List<Map<String, String>> getDisplayedProducts() {
        List<Map<String, String>> productList = new ArrayList<>();

        for (int i = 0; i < productNames.size(); i++) {
            Map<String, String> productData = new HashMap<>();
            productData.put("productName", productNames.get(i).getText());
            productData.put("price", productPrices.get(i).getText().replace("$", ""));
            productList.add(productData);
        }

        return productList;
    }
}
