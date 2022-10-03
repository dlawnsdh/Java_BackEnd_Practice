package org.example;

import java.util.Objects;

public class Cook {
    private final String foodName;
    private final int price;

    public Cook(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
    }

    public Cook(MenuItem menuItem) {
        this.foodName = menuItem.getFoodName();
        this.price = menuItem.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(foodName, cook.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, price);
    }

    public String getFoodName() {
        return foodName;
    }
}
