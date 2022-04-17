package com.example.soupoftheday;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class SoupoftheDay extends Application {
    public static void walletUpdate (Player player, Label wallet){
        wallet.setText("Cash: "+player.getWallet());
    }

    public static void RecipeSelect(Label i1, Label i2, Label i3, Label i4, ComboBox comboBox, Recipe[] recipes, Label soupName) {

            int a = comboBox.getSelectionModel().getSelectedIndex();
            i1.setText(recipes[a].getI1().getName());
            i2.setText(recipes[a].getI2().getName());
            i3.setText(recipes[a].getI3().getName());
            i4.setText(recipes[a].getI4().getName());
            soupName.setText(recipes[a].getName());

    }

    public static void PopulateList(Recipe[] r, ComboBox comboBox, int a) {
        comboBox.getItems().clear();

        for(int y = 0; y < a; ++y) {
            String s1 = r[y].getName();
            comboBox.getItems().add(s1);
        }

    }
    public static void PopulateList(Ingredient[] i, ComboBox comboBox, int a){
        comboBox.getItems().clear();

        for(int y = 0; y < a; ++y) {
            String s1 = i[y].getName();
            comboBox.getItems().add(s1);
    }
    }

public static Boolean DayCheck(ArrayList<Pots>pots) {
        boolean check = false;
        for (int i=0;i<pots.size(); i++){

        if (pots.get(i).getFlavor() !=null){
            check = true;
        }
    }
        return check;
    }

    public static void PopulateList (ArrayList<Shelves> shelves, ListView listView){
        listView.getItems().clear();
        for (int i=0; i< shelves.size(); i++){
        if (shelves.get(i).getiStock() != null){
        listView.getItems().add(shelves.get(i).toString());
        }
    }
    }
    public static void PopulateList (ArrayList<Pots> pots, ListView listView, int erase) {
        listView.getItems().clear();
        for (int i = 0; i < pots.size(); i++) {
            if (pots.get(i).getFlavor() != null) {
                listView.getItems().add(pots.get(i).toString());
                pots.get(i).clearPot();
            }
        }
    }
public Random rnd = new Random();
public void PopulateList(ArrayList<Customer> customer, ComboBox comboBox, int a){
        comboBox.getItems().clear();
    for (int i =0; i<a; i++){
        String s1 = customer.get(i).toString();
        comboBox.getItems().add(s1);
    }
}
public static void LevelChecker(Player player, Ingredient[] is, Recipe[] recipes, ComboBox unlockedSoups, ComboBox unlockedIng){

    //level checker
    if (player.getLevel()==1){
        PopulateList(recipes,unlockedSoups,2);
        PopulateList(is, unlockedIng, 4);
    }
    else if (player.getLevel()==2){
        PopulateList(recipes,unlockedSoups,5);
        PopulateList(is, unlockedIng, 7);
    }
    else if (player.getLevel()==3){
        PopulateList(recipes,unlockedSoups,9);
        PopulateList(is, unlockedIng, 10);
    }
    else if (player.getLevel()==4){
        PopulateList(recipes,unlockedSoups,13);
        PopulateList(is, unlockedIng, 15);
    }
    else if (player.getLevel()==5) {
        PopulateList(recipes,unlockedSoups,17);
        PopulateList(is, unlockedIng, 18);
    }
    else if (player.getLevel()==6){
        PopulateList(recipes,unlockedSoups,21);
        PopulateList(is, unlockedIng, 21);
    }
    else if (player.getLevel()==7){
        PopulateList(recipes,unlockedSoups,23);
        PopulateList(is, unlockedIng, 23);
    }
    else if (player.getLevel()==8){
        PopulateList(recipes,unlockedSoups,24);
        PopulateList(is, unlockedIng, 24);
    }
    else if (player.getLevel()==9){
        PopulateList(recipes,unlockedSoups,25);
        PopulateList(is, unlockedIng, 25);
    }
    else{
        PopulateList(recipes,unlockedSoups,26);
        PopulateList(is, unlockedIng, 26);

    }

}
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //first and last name arrays to generate customers
        String[] fNames={"James", "Mary", "Robert", "Patricia", "John", "Jennifer", "Michael", "Linda","William", "Elizabeth", "David", "Barbara", "Richard", "Susan", "Joseph", "Jessica", "Thomas", "Sarah", "Charles", "Karen", "Christopher", "Nancy", "Daniel", "Lisa", "Matthew", "Betty", "Anthony", "Margaret", "Mark", "Sandra", "Donald", "Ashley", "Steven", "Kimberly", "Paul","Emily", "Andrew", "Donna", "Joshua", "Michelle", "Kenneth", "Dorothy", "Kevin", "Carol", "Brian", "Amanda", "George", "Melissa", "Edward", "Deborah","Ronald", "Stephanie", "Timothy", "Rebecca", "Jason", "Sharon", "Jeffery", "Laura", "Ryan", "Cynthia", "Jacob", "Kathleen", "Gary", "Amy", "Nicholas", "Shirley", "Eric", "Angela", "Jonathan", "Helen", "Stephen", "Anna", "Larry", "Brenda","Justin", "Pamela", "Scott", "Nicole", "Brandon", "Emma", "Benjamin", "Samantha","Samuel", "Katherine", "Gregory", "Christine", "Frank", "Debra", "Alexander", "Rachel", "Raymond", "Catherine", "Patrick", "Carolyn", "Jack", "Janet", "Dennis", "Ruth", "Jerry", "Maria", "Tyler", "Heather", "Aaron", "Diane", "Jose","Virginia","Adam", "Julie", "Henry", "Joyce", "Nathan", "Victoria", "Douglas", "Olivia", "Zachary", "Kelly", "Peter", "Christina","Kyle", "Lauren", "Walter", "Joan", "Ethan", "Evelyn", "Jeremy", "Judith", "Harold", "Megan", "Keith", "Cheryl", "Christian", "Andrea", "Roger", "Hannah", "Noah", "Martha", "Gerald", "Jacqueline", "Carl", "Frances", "Terry", "Gloria", "Sean", "Ann", "Austin", "Teresa", "Arthur", "Kathryn", "Lawrence", "Sara", "Jesse", "Janice", "Dylan", "Jean", "Bryan", "Alice", "Joe", "Madison", "Jordan", "Doris", "Billy", "Abigail", "Bruce", "Julia" , "Albert", "Judy", "Willie", "Grace", "Gabriel", "Denise", "Logan", "Amber", "Alan", "Marilyn", "Juan", "Beverly", "Wayne", "Danielle", "Roy", "Theresa", "Ralph", "Sophia", "Randy", "Marie", "Eugene", "Diana", "Vincent", "Brittany", "Russell", "Natalie", "Elijah", "Isabella", "Louis", "Charlotte" , "Bobby", "Rose", "Philip", "Alexis", "Johnny", "Kayla"  };
        String[] lNames={"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzales", "Wilson", "Anderson", "Thomas", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson","Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker", "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts", "Gomez", "Phillips", "Evans", "Turner", "Diaz", "Parker", "Cruz", "Edwards", "Collins", "Reyes", "Stewart", "Morris", "Morales", "Murphy", "Cook", "Rogers", "Gutierrez", "Ortiz", "Morgan", "Cooper", "Peterson", "Bailey", "Reed", "Kelly", "Howard", "Ramos", "Kim", "Cox", "Ward", "Richardson", "Watson", "Brooks", "Chavez", "Wood", "James", "Bennet", "Grey", "Mendoza", "Ruiz", "Hughes", "Price", "Alvarez", "Castillo", "Sanders", "Patel", "Myers", "Long", "Ross", "Foster", "Jimenez" };

        //ingredient and recipe arrays
        Ingredient[] is={new Ingredient("Chicken", 8), new Ingredient("Pasta", 5), new Ingredient("Carrot", 4), new Ingredient("Celery", 4), new Ingredient("Onion", 4), new Ingredient("Tomato",4), new Ingredient("Beans", 5), new Ingredient("Beef", 10), new Ingredient("Pork",8), new Ingredient("Potato", 4), new Ingredient("Cheese", 6), new Ingredient("Cream", 6), new Ingredient("Butter", 6), new Ingredient("Bacon", 12), new Ingredient("Leek", 6), new Ingredient ("Corn", 5), new Ingredient("Peppers", 5), new Ingredient("Cabbage", 5), new Ingredient("Broccoli", 6), new Ingredient("Squash", 5), new Ingredient("Shellfish", 12), new Ingredient("Bok Choy",6), new Ingredient("Beets", 5), new Ingredient("Rice", 5), new Ingredient("Tortilla Strips", 6), new Ingredient("Fish",12)};
        Recipe[] recipes={new Recipe(is[0], is[1],is[2], is[3], "Chicken Noodle Soup", 5), new Recipe(is[0], is[1],is[2],is[3], "Chicken and Dumplings", 5), new Recipe(is[2],is[3], is[4], is[5], "Garden Vegetable Soup",5), new Recipe(is[2], is[4], is[5], is[6], "Lentil Soup", 5), new Recipe(is[1],is[2],is[5],is [6],"Minestrone", 5), new Recipe(is[5],is[6],is[7],is[8], "Chili", 9), new Recipe(is[1],is[5], is[6], is[7], "Pasta e Fagioli", 8), new Recipe(is[0],is[1],is[7], is[8], "Batchoy", 10), new Recipe(is[2],is[4], is[7], is[9], "Beef Stew",7), new Recipe(is[4],is[7],is[10],is[12], "French Onion Soup",9), new Recipe(is[9],is[10],is[11],is[13], "Baked Potato Soup",10), new Recipe(is[9],is[11],is[12],is[14], "Vichyssoise", 8), new Recipe(is[9],is[11],is[12],is[14], "Potato Leek Soup", 8), new Recipe(is[4],is[7],is[9],is[16], "Menudo",9), new Recipe(is[4],is[8],is[15],is[16], "Pozole",9), new Recipe(is[9],is[11], is[13], is[15], "Corn Chowder", 10), new Recipe(is[1], is[2], is[7], is[17], "Italian Wedding Soup",9), new Recipe(is[10],is[11],is[12],is[18],"Broccoli Cheddar Soup", 10), new Recipe(is[9],is[11],is[13], is[20], "Clam Chowder",14), new Recipe(is[4], is[11],is[12], is[19], "Butternut Squash Soup", 9), new Recipe(is[0],is[4],is[16], is[20], "Pepper Soup",12), new Recipe(is[7],is[11],is[17], is[22], "Borscht",11), new Recipe(is[1],is[4],is[7], is[21], "Beef Noodle Soup",11), new Recipe(is[0],is[11],is[12],is[23], "Chicken and Rice Soup",11), new Recipe(is[0],is[6],is[15], is[24],"Tortilla Soup",11), new Recipe(is[11],is[12],is[20],is[25], "Lobster Bisque", 18)};

        Player player = new Player("blank");


        //ArrayLists to generate the basic store


        //Generates customers
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i=0;i<65 ;i++){
            customers.add(new Customer(fNames, recipes, lNames));
        }

        //store setup








        //Scene setup
        Group root = new Group();
        Scene boot = new Scene(root);
        primaryStage.setTitle( "Soup of the Day" );
        AnchorPane aroot = new AnchorPane();
        AnchorPane saveMe = new AnchorPane();
        AnchorPane iShop = new AnchorPane();
        AnchorPane makeSoup = new AnchorPane();
        Scene soup = new Scene(makeSoup,800.0, 600.0);
        Scene ing = new Scene(iShop, 800.0, 600.0);
        Scene scene = new Scene(aroot, 800.0D, 600.0D);
        primaryStage.setScene( scene);
        primaryStage.show();
        Canvas canvas = new Canvas( 800, 600 );

        //start screen layout
        Button start = new Button("Start");
        AnchorPane.setBottomAnchor(start, 250.0);
        AnchorPane.setLeftAnchor(start, 360.0);

        Label gLb1 = new Label("What is your name?");
        AnchorPane.setBottomAnchor(gLb1, 250.0);
        AnchorPane.setLeftAnchor(gLb1, 320.0);

        TextField txt1= new TextField();
        AnchorPane.setLeftAnchor(txt1,320.0);
        AnchorPane.setBottomAnchor(txt1, 200.0);

        Button adv = new Button("Continue");
        AnchorPane.setLeftAnchor(adv, 320.0);
        AnchorPane.setBottomAnchor(adv, 200.0);

        //soup shop buttons
        Button soupTime = new Button("Make Soup!");
        AnchorPane.setRightAnchor(soupTime, 240.0);
        AnchorPane.setBottomAnchor(soupTime,200.0);

        Button shop = new Button("Buy Ingredients!");
        AnchorPane.setRightAnchor(shop, 240.0);
        AnchorPane.setBottomAnchor(shop, 160.0);

        Button startDay = new Button("Start Selling!");
        AnchorPane.setRightAnchor(startDay, 240.0);
        AnchorPane.setBottomAnchor(startDay, 120.0);

        Button sale = new Button("Sell Soup");
        AnchorPane.setRightAnchor(sale, 240.0);
        AnchorPane.setBottomAnchor(sale, 30.0);

        Button endDay = new Button("Close Shop");
        AnchorPane.setRightAnchor(endDay,320.0);
        AnchorPane.setBottomAnchor(endDay, 30.0);

        Label info = new Label("");
        AnchorPane.setBottomAnchor(info,120.0);
        AnchorPane.setRightAnchor(info, 110.0);


        //making soup scene setup
        Button cook = new Button("Make this soup?");
        AnchorPane.setBottomAnchor(cook,240.0);
        AnchorPane.setRightAnchor(cook,160.0);

        Button sell = new Button("Start Selling!");
        AnchorPane.setBottomAnchor(sell, 200.0);
        AnchorPane.setRightAnchor(sell, 160.0);

        Label soupStatus = new Label("Let's make some soup!");
        AnchorPane.setBottomAnchor(soupStatus, 80.0);
        AnchorPane.setRightAnchor(soupStatus, 200.0);

        Label s1 = new Label("Recipes");
        AnchorPane.setTopAnchor(s1,20.0);
        AnchorPane.setLeftAnchor(s1, 70.0);

        Label p1 = new Label ("Pot: ");
        AnchorPane.setTopAnchor(p1,40.0);
        AnchorPane.setRightAnchor(p1, 120.0);

        Label soupName = new Label("");
        AnchorPane.setBottomAnchor(soupName, 120.0);
        AnchorPane.setLeftAnchor(soupName, 290.0);

        Label i1 = new Label("");
        AnchorPane.setBottomAnchor(i1,100.0);
        AnchorPane.setLeftAnchor(i1, 270.0);

        Label i2 = new Label("");
        AnchorPane.setBottomAnchor(i2,80.0);
        AnchorPane.setLeftAnchor(i2, 270.0);

        Label i3 = new Label("");
        AnchorPane.setBottomAnchor(i3,60.0);
        AnchorPane.setLeftAnchor(i3, 270.0);

        Label i4 = new Label("");
        AnchorPane.setBottomAnchor(i4,40.0);
        AnchorPane.setLeftAnchor(i4, 270.0);

        //ingredient buying scene setup
        Button buy = new Button ("Buy");
        AnchorPane.setRightAnchor(buy,160.0);
        AnchorPane.setBottomAnchor(buy,240.0);

        Button goCook = new Button("Start cooking!");
        AnchorPane.setBottomAnchor(goCook,200.0);
        AnchorPane.setRightAnchor(goCook, 160.0);

        Label cashOn = new Label("");

        //spin
        Spinner<Integer> spinner = new Spinner<Integer>();
        AnchorPane.setBottomAnchor(spinner, 40.0);
        AnchorPane.setLeftAnchor(spinner, 90.0);


        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);
                spinner.setValueFactory(valueFactory);

        Label quantity = new Label("Quantity: ");
        AnchorPane.setBottomAnchor(quantity,40.0);
        AnchorPane.setLeftAnchor(quantity, 30.0);

        Label buyIng = new Label("Buy some ingredients!");
        AnchorPane.setBottomAnchor(buyIng, 30.0);
        AnchorPane.setRightAnchor(buyIng, 100.0);

        Label shelf = new Label ("Shelf: ");
        AnchorPane.setRightAnchor(shelf, 120.0);
        AnchorPane.setTopAnchor(shelf, 40.0);

        Label shopStock = new Label ("Ingredients");
        AnchorPane.setTopAnchor(shopStock,20.0);
        AnchorPane.setLeftAnchor(shopStock, 60.0);

        Label buyPrice = new Label("Price: ");
        AnchorPane.setTopAnchor(buyPrice, 40.0);
        AnchorPane.setLeftAnchor(buyPrice, 160.0);

        Label wallet = new Label("Cash: "+player.getWallet());
        AnchorPane.setLeftAnchor(wallet, 160.0);
        AnchorPane.setLeftAnchor(wallet, 80.0);
        //combo boxes for shopping and cooking scenes
        ObservableList<String> sOptions = FXCollections.observableArrayList();
        ComboBox unlockedSoups = new ComboBox<>(sOptions);
        AnchorPane.setTopAnchor(unlockedSoups, 40.0);
        AnchorPane.setLeftAnchor(unlockedSoups, 40.0);

        ObservableList<String> iOptions = FXCollections.observableArrayList();
        ComboBox unlockedIng = new ComboBox<>(iOptions);
        AnchorPane.setTopAnchor(unlockedIng, 40.0);
        AnchorPane.setLeftAnchor(unlockedIng, 40.0);

        ObservableList<String> shelfChoice = FXCollections.observableArrayList();
        ComboBox sChoice = new ComboBox<>(shelfChoice);
        AnchorPane.setTopAnchor(sChoice, 40.0);
        AnchorPane.setRightAnchor(sChoice, 40.0);

        ObservableList<String> potChoice = FXCollections.observableArrayList();
        ComboBox pChoice = new ComboBox<>(potChoice);
        AnchorPane.setTopAnchor(pChoice, 40.0);
        AnchorPane.setRightAnchor(pChoice, 40.0);

        ObservableList<String> customerChoice = FXCollections.observableArrayList();
        ComboBox cChoice = new ComboBox<>(customerChoice);
        AnchorPane.setTopAnchor(cChoice, 30.0);
        AnchorPane.setLeftAnchor(cChoice, 300.0);
        AnchorPane.setRightAnchor(cChoice, 300.0);

        ListView listView = new ListView<>();
        AnchorPane.setTopAnchor(listView, 30.0);
        AnchorPane.setLeftAnchor(listView, 300.0);
        AnchorPane.setRightAnchor(listView, 300.0);

        ListView listView1 =new ListView<>();
        AnchorPane.setTopAnchor(listView1, 30.0);
        AnchorPane.setLeftAnchor(listView1, 300.0);
        AnchorPane.setRightAnchor(listView1, 300.0);

        ListView listView2 = new ListView<>();
        AnchorPane.setRightAnchor(listView2,40.0);
        AnchorPane.setBottomAnchor(listView2,200.0);



        //populate shelves
        ArrayList<Shelves> shelves= new ArrayList<>();
        for (int i=0;i<16 ;i++){
            shelves.add(new Shelves());
            sChoice.getItems().add(String.valueOf(i+1));
        }
        //initial ingredients
        shelves.get(0).setiStock(is[0]);
        shelves.get(0).setQuantity(1);
        shelves.get(1).setiStock(is[1]);
        shelves.get(1).setQuantity(1);
        shelves.get(2).setiStock(is[2]);
        shelves.get(2).setQuantity(1);
        shelves.get(3).setiStock(is[3]);
        shelves.get(3).setQuantity(1);

        ArrayList<Pots> pots = new ArrayList<>();
        for (int i=0; i<4; i++){
            pots.add(new Pots());
            pChoice.getItems().add(String.valueOf(i+1));
        }

        //store setup
        Store store = new Store(player, customers);
        store.setPots(pots);
        store.setShelves(shelves);

        //canvas elements
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill( Color.BLANCHEDALMOND );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(.5);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 24 );
        gc.setFont( theFont );


        Image storeBG = new Image("C:\\Users\\James\\Documents\\College Papers\\2021-2022\\Spring 2022\\IT 2650\\Lab 6\\src\\main\\resources\\com\\example\\soupoftheday\\SoupofTheDayBG.jpg");


        //initialize scenes
        root.getChildren().add( saveMe);
        saveMe.getChildren().addAll(soupTime, shop, canvas, startDay, info);
        aroot.getChildren().add(start);
        canvas.toBack();

        //actually add things you moron
        iShop.getChildren().addAll(unlockedIng, sChoice, buy, goCook, spinner, quantity, buyIng, listView, shelf, shopStock, buyPrice, wallet);
        makeSoup.getChildren().addAll(unlockedSoups, pChoice, cook, sell, soupStatus, listView1, s1, p1, i1, i2, i3, i4, soupName);

        listView2.setPrefHeight(100.0);
        //start button action
        start.setOnAction(actionEvent -> {
            aroot.getChildren().remove(start);
            aroot.getChildren().addAll(gLb1, txt1);
        });

        //text limiter
        String a = "aaaaaaaaaa";

        //set player name
        txt1.setOnAction(actionEvent -> {
            player.setName(txt1.getText());

                if (player.getName().length()<=a.length()&& player.getName().length()>0){
                   gLb1.setText("Nice to meet you, " +player.getName());
                   aroot.getChildren().remove(txt1);
                   aroot.getChildren().add(adv);
                }
                else {
                    gLb1.setText("Try using a name with up to 10 characters.");
                }});

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // Clear the canvas
                gc.drawImage(storeBG,0,0);
                gc.setLineWidth(.5);

                String nameSlot = "Owner: " +player.getName();
                gc.fillText(nameSlot, 40,40);
                gc.strokeText(nameSlot, 40, 40);

                String walletTxt = "Cash: " + player.getWallet();
                gc.fillText(walletTxt, 40, 70);
                gc.strokeText(walletTxt, 40, 70 );


                String levelTxt = ("Level: " + player.getLevel());
                gc.fillText(levelTxt, 670,570);
                gc.strokeText(levelTxt, 670, 570);

            }
        }.start();


        LevelChecker(player,is,recipes,unlockedSoups, unlockedIng);

        //continue button
        AtomicInteger x = new AtomicInteger(0);

         adv.setOnAction(actionEvent -> {
             AnchorPane.setLeftAnchor(gLb1, 100.0);
             if (x.get() == 0) {

                 gLb1.setText("Let's get started. You'll be running this soup shop, Soup of the Day.");
                 x.incrementAndGet();

             }
             else if (x.get() == 1) {

                     gLb1.setText("Customers will come in every day to buy your delicious soups. You can only make a few soups right now.");
                     System.out.println(x.incrementAndGet());

             }
             else if (x.get() == 2) {

                     gLb1.setText("Each soup you make takes 4 ingredients. We'll start you off with chicken, pasta, carrots, and celery for now.");

                     x.incrementAndGet();


             }
             else if (x.get() == 3) {
                             gLb1.setText("After today, you'll need to buy your ingredients. Don't worry, we've given you a little cash to start as well.");
                             x.incrementAndGet();

             }

             else if (x.get() == 4) {

                     gLb1.setText("Try making a soup. Once you've made a pot of soup, you can open your shop.");
                     x.incrementAndGet();

             }

            else if (x.get() == 5) {


                     gLb1.setText("Each day, you'll serve until you run out of soup, or customers stop coming in.");
                     x.incrementAndGet();

             }

             else if (x.get() == 6) {


                     gLb1.setText("You won't get many customers at first, but do your best!");
                     x.incrementAndGet();


             }

           else if (x.get() == 7) {

                             primaryStage.setScene(boot);
                         }


         });


         //gameplay loop selling screen


                gc.setLineWidth(.5);
                String levelTxt = ("Level: " + player.getLevel());
                gc.fillText(levelTxt, 670,570);
                gc.strokeText(levelTxt, 670, 570);


        //ingredient buying scene actions
        shop.setOnAction(actionEvent -> {
            primaryStage.setScene(ing);
            PopulateList(shelves, listView);
            PopulateList(shelves, listView1);
        });
        goCook.setOnAction(actionEvent -> {
            primaryStage.setScene(soup);
            PopulateList(shelves, listView);
            PopulateList(shelves, listView1);
            buyIng.setText("Let's buy some ingredients!");
        });

        unlockedIng.setOnAction(actionEvent -> {
            int a1= unlockedIng.getSelectionModel().getSelectedIndex();
            int a2 =spinner.getValue();
            buyPrice.setText("Price: $"+is[a1].getPrice()*a2);
        });
        buy.setOnAction(actionEvent -> {
            int s=sChoice.getSelectionModel().getSelectedIndex();
            int i=unlockedIng.getSelectionModel().getSelectedIndex();
            buyIng.setText(shelves.get(s).BuyIngredients(player,is[i],spinner.getValue()));
            PopulateList(shelves, listView);
            PopulateList(shelves, listView1);
            walletUpdate(player, wallet);
        });

        //soup making scene actions
        soupTime.setOnAction(actionEvent -> {
            primaryStage.setScene(soup);
            PopulateList(shelves, listView1);
        });

        cook.setOnAction(actionEvent -> {
        int p = pChoice.getSelectionModel().getSelectedIndex();
        int s = unlockedSoups.getSelectionModel().getSelectedIndex();
        soupStatus.setText(pots.get(p).makeSoup(shelves,recipes[s]));
        for (int i=0; i<shelves.size();i++){
            shelves.get(i).ClearShelf();
        }
            PopulateList(shelves, listView1);
        });

        sell.setOnAction(actionEvent -> {
            primaryStage.setScene(boot);

            soupStatus.setText("Let's make some soup!");
        });
unlockedSoups.setOnAction(actionEvent -> {
    RecipeSelect(i1,i2,i3,i4,unlockedSoups, recipes, soupName);
});

// oh god, gameplay
    startDay.setOnAction(actionEvent -> {
    if (DayCheck(pots)==false){
        info.setText("Try making soup first.");
    }
    else {
        store.SatisCalc(player,customers);
        store.DailyCustomers();
        saveMe.getChildren().removeAll(soupTime,shop, startDay);
        PopulateList(pots, listView2, 0);
        PopulateList(customers,cChoice, store.getDaily());
        saveMe.getChildren().addAll(cChoice, listView2, sale, endDay);
    }
    });

    sale.setOnAction(actionEvent -> {
            info.setText(customers.get(cChoice.getSelectionModel().getSelectedIndex()).Purchase(pots,player));
            player.levelUp();
            PopulateList(pots,listView2, 0);


    });
    endDay.setOnAction(actionEvent -> {
        LevelChecker(player,is,recipes,unlockedSoups, unlockedIng);
        info.setText("Let's do our best today!");
        saveMe.getChildren().addAll(soupTime,shop, startDay);
        saveMe.getChildren().removeAll(cChoice, listView2, sale, endDay);

        for (int i= 0; i<customers.size(); i++){
            customers.get(i).resetBoughtSoup();
        }

    });

        primaryStage.show();
    }


}