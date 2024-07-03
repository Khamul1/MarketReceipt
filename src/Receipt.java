import java.util.List;
import java.util.Map;

public class Receipt {

    private List<Product> products;// Список товаров в чеке
    private Map<Product, Integer> quantities; // Количество каждого товара
    private DiscountCard discountCard = null;
    private double discountSum;
    private double totalSum;

    public Receipt(List<Product> products, Map<Product, Integer> quantities, DiscountCard discountCard) {
        this.products = products;
        this.quantities = quantities;
        this.discountCard = discountCard;
        this.discountSum = discountSum;
        this.totalSum = totalSum;
    }

    public double calculateTotalSum() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * quantities.get(product);
        }
        return total;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public double getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(double discountSum) {
        this.discountSum = discountSum;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<Product, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Product, Integer> quantities) {
        this.quantities = quantities;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        double totalSum = 0;
        double discountSum = 0;
        double vatRate = 0.2; // Ставка НДС 20%

        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------\n");
        sb.append("                Чек\n");
        sb.append("-------------------------------------\n");

        for (Product product : products) {
            int quantity = quantities.get(product);
            double productPrice = product.getPrice(quantity);
            double productSum = productPrice * quantity;
            sb.append(String.format("%-20s x %-5d = %.2f\n",
                    product.getName(), quantity, productSum));
        }

        sb.append("-------------------------------------\n");
        sb.append(String.format("Сумма:      %.2f\n", this.totalSum)); // Используем this.totalSum
        sb.append(String.format("Скидка:     %.2f\n", this.discountSum)); // Используем this.discountSum
        sb.append(String.format("Итого:      %.2f\n", this.totalSum - this.discountSum)); // Используем this.totalSum и this.discountSum
        sb.append("-------------------------------------\n");
        return sb.toString();
    }
}