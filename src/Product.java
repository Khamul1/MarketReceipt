public class Product {
    private String name;
    double price;
    boolean isPromotional;

    public String getName() {
        return name;
    }

    public Product(String name, double price, boolean isPromotional) {
        this.name = name;
        this.price = price;
        this.isPromotional = isPromotional;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPromotional() {
        return isPromotional;
    }

    public void setPromotional(boolean promotional) {
        isPromotional = promotional;
    }

    public double getPrice(int quantity) {
        return price;
    }
}
