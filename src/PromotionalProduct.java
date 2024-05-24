public class PromotionalProduct extends Product{

    public PromotionalProduct(String name, double price, boolean isPromotional){
        super(name, price, isPromotional);
    }

    @Override
    public  double getPrice(int quantity) {
        double basePride = super.getPrice();
        if (quantity >5 && isPromotional()) {
            return basePride * 0.9; // Скидка 10%
        }else {
            return basePride;
        }
    }
}
