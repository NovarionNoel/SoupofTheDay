package com.example.soupoftheday;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class Customer {
    private String fName;
    private String lName;
    private Recipe fave;
    private float satisfaction;
    private boolean boughtSoup = false;

    public String getfName() {
        return fName;
    }

    public String getlName(){return lName;}

    public Recipe getFave() {
        return fave;
    }

    public void resetBoughtSoup() {
        this.boughtSoup = false;
    }

    public float getSatisfaction() {
        return satisfaction;
    }



    public Customer(String[] fNames, Recipe[] recipes, String[] lNames) {
        this.satisfaction = 0;
        int x = rnd.nextInt(0, recipes.length);
        this.fave = recipes[x];
        x = rnd.nextInt(0, fNames.length);
        this.fName= fNames[x];
        x =rnd.nextInt(0, lNames.length);
        this.lName= lNames[x];
    }

    public String Purchase(ArrayList<Pots> pots, Player player){
        int a = player.getWallet();

        for (int i= 0; i<pots.size();i++){

            if (pots.get(i).getQuantity()!=0 && pots.get(i).getFlavor()==this.fave && boughtSoup==false){
                a = a + fave.getPrice()+1;
                pots.get(i).Sold();
                this.satisfaction++;
                player.sale();
                boughtSoup=true;
                player.setWallet(a);
                return this.fName +  " "+this.lName + " just bought a bowl of "+ pots.get(i).getFlavor().getName()+" for  $" +(pots.get(i).getFlavor().getPrice()+1)+".";
                }
            else if (boughtSoup==false) {
                int x =rnd.nextInt(0, pots.size());

                if(pots.get(x).getQuantity() != 0) {
                 a = a + pots.get(x).getFlavor().getPrice();
                 pots.get(x).Sold();
                 player.sale();
                    boughtSoup=true;
                 player.setWallet(a);
                 this.satisfaction= (float) (this.satisfaction + 0.2);
                 return this.fName +" "+this.lName+ " just bought a bowl of "+ pots.get(x).getFlavor().getName()+" for $" +pots.get(x).getFlavor().getPrice()+".";
             }
                 else  {
                    for (int i2=0; i2<pots.size(); i2++){
                            if (pots.get(i2).getQuantity()!=0){
                                a = a + pots.get(i2).getFlavor().getPrice();
                            pots.get(i2).Sold();
                            player.sale();
                            player.setWallet(a);

                                boughtSoup=true;
                            this.satisfaction= (float) (this.satisfaction + 0.2);
                            return this.fName +" "+ this.lName+ " just bought a bowl of "+ pots.get(i2).getFlavor().getName()+" for $" +pots.get(i2).getFlavor().getPrice()+".";

                            }
                }
             }

            }
            else if (boughtSoup=true){
                return this.fName + " "+ this.lName +" already bought soup today.";
            }
        }

        if (this.satisfaction>=5){
            this.satisfaction=5;
        }

        return "No more soup! Time to close up shop.";
    }

    @Override
    public String toString() {
        return  fName + ' ' + lName + "   Fave: " + fave.getName()+ ' ';
    }

    Random rnd = new Random();
}
