package org.example;

public class Customer {
    public void order(String foodName, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(foodName);
        Cook cook = cooking.makeCook(menuItem);
        System.out.printf("주문하신 %s 나왔습니다. 맛있게 드세요!", cook.getFoodName());
    }
}
