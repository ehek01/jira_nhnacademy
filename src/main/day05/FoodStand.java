package day05;

import java.util.ArrayList;
import java.util.Objects;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public boolean existFood(ArrayList<BuyList.Item> buyList) {
        // item 갯수만큼 돌면서, buyList 의 상품갯수보다 매대에 있는 상품 갯수가 더 많아야 함.
        for (BuyList.Item item : buyList) {
            for (Food food : foods) {
                // 상품매대에 해당 상품이 존재하는지 하면서, 갯수가 구매하려는 갯수보다 크거나 같아야함.
                if (Objects.equals(item.getName(), food.getName()) && getFoodAmount(food.getName()) >= item.getAmount()) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getFoodAmount(String foodName) {
        int amount = 0;
        for (Food food : foods) {
            if (Objects.equals(food.getName(), foodName)) {
                amount++;
            }
        }
        return amount;
    }

    public int getFoodPrice(String foodName) {
        for (Food food : foods) {
            if (Objects.equals(food.getName(), foodName)) {
                return food.getPrice();
            }
        }

        System.out.println("해당 상품이 존재하지 않습니다.");
        return 0;
    }
}
