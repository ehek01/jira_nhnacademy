package day05;

public class Customer {
    private final BuyList buyList;
    private Basket basket;
    private int money;

    public Customer(BuyList buyList, int money) {
        this.buyList = buyList;
        this.money = money;
    }

    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void pickFoods(FoodStand foodStand) {
        // foodStand 에서 이름으로 비교한 뒤, 같은게 있으면 바구니안에 넣어주자.
        if (!foodStand.existFood(buyList.getItems())) {
            System.out.println("상품매대에 음식 수량이 부족합니다.");
            return;
        }

        for (BuyList.Item item : buyList.getItems()) {
            for (int i = 0; i < item.getAmount(); i++) {
                basket.add(new Food(item.getName(),foodStand.getFoodPrice(item.getName())));
            }
        }
    }

    public void payTox(Counter counter) {
        int totalPrice = counter.getTotalPrice(basket);
        if (money < totalPrice) {
            System.out.println("잔액이 부족합니다.");
        }

        System.out.println("총 가격은 " + totalPrice + " 입니다.");
        money = money - totalPrice;
        System.out.println("고객님 결제 후 잔액 : " + money);
    }
}
