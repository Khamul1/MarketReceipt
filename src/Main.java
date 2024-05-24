import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product[] productsArray = {

                new Product("Молоко", 1.2, false),
                new PromotionalProduct("Хлеб", 0.8, true), // Акционный товар
                new Product("Сыр", 3.5, false),
                new Product("Кефир", 1.5, false),
                new PromotionalProduct("Яблоки", 1.8, true), // Акционный товар
                new Product("Бананы", 2.5, false),
                new Product("Картофель", 1.0, false),
                new Product("Лук", 0.8, false),
                new PromotionalProduct("Морковь", 1.0, true), // Акционный товар
                new Product("Куриное филе", 4.5, false),
                new Product("Гречка", 2.2, false),
                new Product("Рис", 1.8, false),
                new Product("Макароны", 1.5, false),
                new PromotionalProduct("Томатная паста", 0.9, true), // Акционный товар
                new Product("Соль", 0.5, false),
                new Product("Сахар", 1.3, false)
        };

        DiscountCard card = new DiscountCard(10); // Картка со скидкой 10%

        List<Product> products = new ArrayList<>();
        products.add(productsArray[0]);
        products.add(productsArray[1]);
        products.add(productsArray[2]);

        ReceiptBuilder builder = new ReceiptBuilder();
        for (int i = 0; i < productsArray.length; i++) {
            builder.addProduct(productsArray[i], 1);
        }

        builder.setDiscountCard(card);
        Receipt receipt = builder.build();

        System.out.println(receipt);
    }
}