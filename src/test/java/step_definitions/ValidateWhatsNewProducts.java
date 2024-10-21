package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LumaHomePage;
import pages.WhatsNewPage;
import pojos.Product;
import utilities.QaDataReader;

import java.util.List;
import java.util.Map;

public class ValidateWhatsNewProducts {

    private static final Logger log = LoggerFactory.getLogger(ValidateWhatsNewProducts.class);

    LumaHomePage lumaHomePage = new LumaHomePage();
    WhatsNewPage whatsNewPage = new WhatsNewPage();

    @Given("the user is on the Luma homepage")
    public void the_user_is_on_the_luma_homepage() {
        log.info("Navigating to Luma homepage.");
        lumaHomePage.logIn("");
        log.info("User logged in successfully");
    }

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
        log.info("User clicks on the '{}' link.", linkText);
        if (linkText.equalsIgnoreCase("What's New")) {
            lumaHomePage.clickWhatsNew();
            log.info("Clicked on 'What's New' link." );
        }
    }

    @Then("the following products should be displayed:")
    public void the_following_products_should_be_displayed(DataTable dataTable) {
        log.info("Validating displayed products.");
        List<Map<String, String>> expectedProducts = dataTable.asMaps(String.class, String.class);

        List<Map<String, String>> actualProducts = whatsNewPage.getDisplayedProducts();

        Assert.assertEquals("Number of products displayed does not match!", expectedProducts.size(), actualProducts.size());
        log.info("Number of products displayed matches expected count.");

        for (int i = 0; i < expectedProducts.size(); i++) {
            Map<String, String> expectedProduct = expectedProducts.get(i);
            Map<String, String> actualProduct = actualProducts.get(i);

            Assert.assertEquals("Product name mismatch at index " + i, expectedProduct.get("productName"), actualProduct.get("productName"));
            Assert.assertEquals("Product price mismatch at index " + i, expectedProduct.get("price"), actualProduct.get("price"));
            log.info("Product '{}' matched with price '{}'.", expectedProduct.get("productName"), expectedProduct.get("price"));
        }
    }

    @Then("the product prices should match the JSON data")
    public void the_product_prices_should_match_the_json_data() {
        log.info("Loading expected products from JSON for 'whatsNew' category.");
        List<Product> expectedProducts = QaDataReader.getProductsByCategory("whatsNew");

        List<Map<String, String>> actualProducts = whatsNewPage.getDisplayedProducts();

        Assert.assertEquals("Number of products mismatch!", expectedProducts.size(), actualProducts.size());
        log.info("Number of products displayed matches expected count from JSON.");

        for (int i = 0; i < expectedProducts.size(); i++) {
            Product expected = expectedProducts.get(i);
            Map<String, String> actual = actualProducts.get(i);

            Assert.assertEquals("Product name mismatch!", expected.getProductName(), actual.get("productName"));

            double actualPrice = Double.parseDouble(actual.get("price"));

            Assert.assertEquals("Product price mismatch!", expected.getPrice(), actualPrice, 0.01); // Allow a small margin for floating-point comparison
            log.info("Product '{}' has a matching price of '{}'.", expected.getProductName(), expected.getPrice());
        }
    }


}
