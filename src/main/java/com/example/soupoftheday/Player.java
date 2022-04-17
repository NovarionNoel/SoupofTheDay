package com.example.soupoftheday;

public class Player {
    private int wallet;
    private int level;
    private int experience =1;
    private String name;

    public int purchase(int price){
        this.wallet-=price;

        return this.wallet;
    }

    public void sale (){
        this.experience++;
    }

    public void levelUp(){
        double a = Math.pow(this.level,3.0);
            if (this.experience == (int)a) {

                this.experience = 1;
                this.level++;

            }

            else if (this.experience > (int) a) {
                this.experience = (int) (this.experience-a);
                this.level++;

            }
        else if (this.level>=10){
           this.level=10;
        }

    }


    public int getWallet() {
        return wallet;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.wallet= 100;
    }

}
