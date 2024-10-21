package pojos;

public class Product {
    private String productName;
    private String productId;
    private double price;
    private String currency;
    private String programCode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProgramCode() { 
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }
}
