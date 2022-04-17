package com.example.soupoftheday;

public class Ingredient {
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    private String name;
    private int price;

    public Ingredient(String name, int price) {
        this.name = name;
        this.price = price;
    }


}
