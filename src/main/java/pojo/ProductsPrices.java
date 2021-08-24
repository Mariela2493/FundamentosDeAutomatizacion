package pojo;

public class ProductsPrices {
        private String product;
        private String imageURL;
        private double dolarsPrice;
        private double poundsPrice;
        private double euroPrice;

    public ProductsPrices(String product, String imageURL, double dolarsPrice, double poundsPrice, double euroPrice) {
        this.product = product;
        this.imageURL = imageURL;
        this.dolarsPrice = dolarsPrice;
        this.poundsPrice = poundsPrice;
        this.euroPrice = euroPrice;
    }

    public String getProduct() {
        return product;
    }

    public String getImageURL() {
        return imageURL;
    }

    public double getDolarsPrice() {
        return dolarsPrice;
    }

    public double getPoundsPrice() {
        return poundsPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }
}
