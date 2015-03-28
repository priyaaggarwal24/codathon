package web.codathon.domain;

public class Offer {
    private Product product;
    private String offerString;
    private float offerPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOfferString() {
        return offerString;
    }

    public void setOfferString(String offerString) {
        this.offerString = offerString;
    }

    public float getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(float offerPrice) {
        this.offerPrice = offerPrice;
    }
}
