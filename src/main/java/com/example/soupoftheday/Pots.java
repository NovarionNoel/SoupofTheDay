package com.example.soupoftheday;

import java.util.ArrayList;

public class Pots {
    private Recipe flavor;
    private int quantity;

    public Recipe getFlavor() {
        return flavor;
    }

    public void setFlavor(Recipe flavor) {
        this.flavor = flavor;
    }




    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Pots() {
        this.quantity=0;

    }
   public void Sold (){
    this.quantity--;
   }

   public void fillPot(Recipe r){
    this.quantity=8;
    this.flavor = r;
   }

   public void clearPot(){
        if(this.quantity==0){
          this.flavor=null;
        }
   }

    public String makeSoup(ArrayList<Shelves> shelves, Recipe flavor){
        int pass =0;
        for (int i=0; i< shelves.size(); i++){
            if (shelves.get(i).getQuantity()!=0){
                if (flavor.getI1() == shelves.get(i).getiStock() ||flavor.getI2()== shelves.get(i).getiStock()|| flavor.getI3()== shelves.get(i).getiStock() || flavor.getI4()== shelves.get(i).getiStock() ){
                    pass++;
                }
            }
        }
        if (pass==4 && this.quantity==0){
            fillPot(flavor);
            for (int x=0; x< shelves.size(); x++) {
                shelves.get(x).UseIngredients(flavor.getI1());
                shelves.get(x).UseIngredients(flavor.getI2());
                shelves.get(x).UseIngredients(flavor.getI3());
                shelves.get(x).UseIngredients(flavor.getI4());

            }
            return "You just made "+this.flavor.getName()+ ".";

        }
        else if (this.quantity!=0){
            return "You already have soup in this pot!";
        }
        return "You don't have enough ingredients to make "+flavor.getName()+ ".";
    }

    @Override
    public String toString() {
        return flavor.getName() + " " + quantity;
    }
}
