package com.example.soupoftheday;

import javafx.scene.control.Spinner;

public class Shelves {
    private Ingredient iStock;
    private int space;

    public Ingredient getiStock() {
        return iStock;
    }

    public void setiStock(Ingredient iStock) {
        this.iStock = iStock;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public Shelves() {
        this.space = 20;

    }
    public void UseIngredients(Ingredient r1) {
        if (r1 == this.iStock) {
            this.quantity--;
        }
    }

    public void ClearShelf(){
        if (this.quantity==0){
            this.iStock=null;
        }
    }
    public String BuyIngredients (Player player, Ingredient i, int quantity) {
        int a = i.getPrice() * quantity;

        if ((this.iStock == null || this.iStock == i) && this.space - quantity > 0 && player.getWallet()>=a) {
            int x = player.getWallet() - a;
            player.setWallet(x);
            this.space=this.space-quantity;
            System.out.println(player.getWallet());
            this.quantity+=quantity;
            this.iStock=i;
            return "You bought " + quantity + " " + i.getName() + ".";

        }

        else if (this.iStock !=i && this.iStock != null) {
          return "You already have a different ingredient here.";
        }

        else if (space - quantity<0){
            return "You can't have more than 20 " + i.getName()+".";
        }

        else if (player.getWallet()<a){
            return "You can't afford "+quantity+" "+i.getName()+".";
        }

        return null;
    }

    @Override
    public String toString() {
        return this.iStock.getName()+" "+ this.quantity;
    }
}

