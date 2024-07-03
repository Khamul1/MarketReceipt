import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptBuilder {
    private List<Product> products = new ArrayList<>();
    private Map<Product, Integer> quantities = new HashMap<>();
    private DiscountCard discountCard;
    private double discountSum;
    private double totalSum;

    public ReceiptBuilder addProduct(Product product, int quantity) {
        products.add(product);
        quantities.put(product, quantity);
        return this;
    }

    public ReceiptBuilder removeProduct(Product product) {
        products.remove(product);
        quantities.remove(product);
        return this;
    }

    public ReceiptBuilder updateQuantity(Product product, int newQuantity) {
        int delta = newQuantity - quantities.get(product);
        quantities.put(product, newQuantity);
        return this;
    }

    public ReceiptBuilder setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
        return this;
    }

    public Receipt build() {
        Receipt receipt = new Receipt(products, quantities, discountCard);
        calculateDiscount(receipt);
        calculateTotalSum(receipt);
        return receipt;
    }

    private void calculateDiscount(Receipt receipt) {
        if (receipt.getDiscountCard() != null) {
            double discountSum = receipt.calculateTotalSum() * receipt.getDiscountCard().getDiscountPercentage() / 100;
            receipt.setDiscountSum(discountSum);
        }

        double totalSum = receipt.calculateTotalSum();
        if (totalSum > 100) {
            double totalDiscount = totalSum * 0.2;
            receipt.setDiscountSum(receipt.getDiscountSum() + totalDiscount);
        }
    }

    private void calculateTotalSum(Receipt receipt) {
        double totalSum = receipt.calculateTotalSum();
        receipt.setTotalSum(totalSum);
    }
}
