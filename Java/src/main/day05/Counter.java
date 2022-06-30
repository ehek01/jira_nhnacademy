package day05;

public class Counter {
    private int totalPrice;

    public int getTotalPrice(Basket basket) {
        for (Food food : basket.getFoods()) {
            totalPrice += food.getPrice();
        }

        return totalPrice;
    }
}
