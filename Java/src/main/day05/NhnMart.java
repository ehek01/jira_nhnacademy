package day05;

import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        System.out.print("nhn 마트에 오신것을 환영합니다. 사고싶은 물건을 입력해주세요. ex) 양파 2 계란 3\n> ");
        BuyList buyList = inputBuyListFromShell();

        Customer jordan = new Customer(buyList, 20000); // 고객의 구매목록을 처음받고,
        jordan.bring(mart.provideBasket());     // 장바구니는 그 이후에 이루어 진다.

        // 식품을 담는다.
        jordan.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        jordan.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        Scanner scanner = new Scanner(System.in);
        BuyList buyList = new BuyList();

        String[] inputBuyList = scanner.nextLine().split(" ");

        for (int i = 0; i < inputBuyList.length; i = i+2) {
            buyList.add(new BuyList.Item(inputBuyList[i], Integer.parseInt(inputBuyList[i+1])));
        }

        return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 3_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return this.foodStand;
    }

    public Counter getCounter() {
        return new Counter();
    }
}