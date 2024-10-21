package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import pojos.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QaDataReader {

    private final static String path = "src/test/resources/test_data/qaData.json"; // Updated the file name

    /**
     * Retrieves a single product based on the program code.
     *
     * @param programCode The program code of the product to retrieve.
     * @return The product with the specified program code, or null if not found.
     */
    public static Product getSingleProduct(String programCode) {
        Product product = null;
        for (Product eachProduct : getAllProducts()) {
            if (eachProduct.getProgramCode().equalsIgnoreCase(programCode)) {
                product = eachProduct;
            }
        }
        return product;
    }

    /**
     * Retrieves a list of products based on the specified category.
     *
     * @param category The category name to filter products.
     * @return A list of products belonging to the specified category.
     */
    public static List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(file);
            JsonNode categoryNode = rootNode.path("categories").path(category).path("products");

            for (JsonNode productNode : categoryNode) {
                Product product = mapper.treeToValue(productNode, Product.class);
                products.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    /**
     * Retrieves all products from the JSON file.
     *
     * @return A list of all products stored in the JSON file.
     */
    public static List<Product> getAllProducts() {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Product.class);
        List<Product> products = null;

        try {
            products = mapper.readValue(file, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
