package web.codathon.domain;

public class SearchResult {
    private String productName;
    private String offerString;
    private float price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOfferString() {
        return offerString;
    }

    public void setOfferString(String offerString) {
        this.offerString = offerString;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
