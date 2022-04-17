package com.example.soupoftheday;
import java.util.ArrayList;
import java.util.Random;

public class Store {
    private float satisfaction;
    private ArrayList shelves;
    private ArrayList pots;
    private int daily;
    public Store(Player player, ArrayList<Customer> customers){
      SatisCalc(player, customers);
      DailyCustomers();

    }
    public int getDaily() {
        return daily;
    }
    public void setShelves(ArrayList shelves) {
        this.shelves = shelves;
    }

    public void setPots(ArrayList pots) {
        this.pots = pots;
    }

    public ArrayList getShelves() {
        return shelves;
    }

    public ArrayList getPots() {
        return pots;
    }

    public float getSatisfaction() {
        return satisfaction;
    }

    public void SatisCalc(Player player, ArrayList<Customer> customers){
        for (int i = 0; i<customers.size(); i++){
            float a = customers.get(i).getSatisfaction();
            this.satisfaction = (this.satisfaction/2 + (float)(a*player.getLevel()/100));
        }
        if (this.satisfaction>=100){
            this.satisfaction=100;
        }
    }

   public void DailyCustomers(){
        if (this.satisfaction<=25){
          this.daily = rnd.nextInt(8,17);
        }
        else if (this.satisfaction<=50){
            this.daily=rnd.nextInt(16,25);
        }
        else if (this.satisfaction<=75){
            this.daily=rnd.nextInt(24,33);
        }
        else{
            this.daily=32;
        }
   }


Random rnd = new Random();
}
