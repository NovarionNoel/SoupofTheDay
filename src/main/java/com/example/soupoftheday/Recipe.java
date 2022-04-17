package com.example.soupoftheday;

import java.util.ArrayList;

public class Recipe {
    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Ingredient i4;
    private String name;
    private int price;


    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




    public Recipe(Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4, String name, int price) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.name = name;
        this.price = price;

    }


    public Ingredient getI1() {
        return i1;
    }

    public Ingredient getI2() {
        return i2;
    }

    public Ingredient getI3() {
        return i3;
    }

    public Ingredient getI4() {
        return i4;
    }

    public String getName() {
        return name;
    }


}


