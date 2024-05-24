import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product[] productsArray = {
                new Product("Молоко", 1.2, false),
                new PromotionalProduct("Хлеб", 0.8, true), // Акционный товар
                new Product("Сыр", 3.5, false)
        };

        DiscountCard card = new DiscountCard(10); // Картка со скидкой 10%

        List<Product> products = new ArrayList<>();
        products.add(productsArray[0]);
        products.add(productsArray[1]);
        products.add(productsArray[2]);

        ReceiptBuilder builder = new ReceiptBuilder();
        for (Product product: products){
             builder.addProduct(product,1);
        }
        builder.setDiscountCard(card);
        Receipt receipt = builder.build();

        System.out.println(receipt);
    }
}