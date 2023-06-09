import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Order{
    //public constructor function with the parameters: ArrayList of Cupcake and ArrayList of Drink
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {

        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        //new scanner to take user input
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();

        //new arraylist of objects that can contain any object of various types
        ArrayList<Object> order = new ArrayList<Object>();

        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());

            System.out.println("Here is the menu");

            //CUPCAKES ORDER
            System.out.println("CUPCAKES");
            //initial item number variable
            int itemNumber = 0;
            //loop that iterates through each index of the cupcakeMenu arrayList
            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber += 1;
                System.out.println(itemNumber);
                //output the type of cupcake at cupcakeMenu at i by calling the type method
                cupcakeMenu.get(i).type();
                //print price of that cupcake
                System.out.println("Price: " + cupcakeMenu.get(i).price);
                //print a new line
                System.out.println("\n");
            }
            //DRINKS ORDER
            System.out.println("Drinks");

            for (int i = 0; i < drinkMenu.size(); i++) {
                itemNumber += 1;
                System.out.println(itemNumber);
                drinkMenu.get(i).type();
                System.out.println("Price: " + drinkMenu.get(i).price);
                System.out.println("\n");
            }

            //boolean variable
            boolean ordering = true;
            //while loop that continues as long as ordering = true
            while (ordering){
                System.out.println("What would you like to order? Please use the number associated with each item to order.");

                int orderChoice = input.nextInt();
                input.nextLine();

                //if statements to check if orderChoice equals 1-6, if so add the correct item from cupcake menu to the order ArrayList and print "item added to order"
                if (orderChoice == 1) {
                    order.add(cupcakeMenu.get(0));
                    System.out.println("Item added to order");
                } else if (orderChoice == 2) {
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Item added to order");
                } else if (orderChoice == 3) {
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Item added to order");
                } else if (orderChoice == 4) {
                    order.add(drinkMenu.get(0));
                    System.out.println("Item added to order");
                } else if (orderChoice == 5) {
                    order.add(drinkMenu.get(1));
                    System.out.println("Item added to order");
                } else if (orderChoice == 6) {
                    order.add(drinkMenu.get(2));
                    System.out.println("Item added to order");
                } else {
                    System.out.println("Sorry we don't have that on the menu.");
                    }

            //check if user wants to keep ordering
                System.out.println("Would you like to continue ordering? (Y/N)");
                placeOrder = input.nextLine();
                if(!placeOrder.equalsIgnoreCase("Y")) {
                    ordering = false;
                }
            }
            //generate a receipt of all items the customer ordered
            System.out.println(order.get(0));
            System.out.println(order.get(1));
            //create double variable named subtotal
            double subtotal = 0.0;
            //for loop that starts at i = 2, incrementing by 1, while i is less than order size
            for (int i = 2; i<order.size(); i++){
                //check if order at i is equal to cupcakeMenu at 0
                if(order.get(i) == cupcakeMenu.get(0)){
                    //run type method on value
                    cupcakeMenu.get(0).type();
                    //print price of cupcake
                    System.out.println(cupcakeMenu.get(0).getPrice());
                    //set subtotal = to subtotal plus cupcake price
                    subtotal += cupcakeMenu.get(0).getPrice();
                } else if(order.get(i) == cupcakeMenu.get(1)){
                    //run type method on value
                    cupcakeMenu.get(1).type();
                    //print price of cupcake
                    System.out.println(cupcakeMenu.get(1).getPrice());
                    //set subtotal = to subtotal plus cupcake price
                    subtotal += cupcakeMenu.get(1).getPrice();
                } else if(order.get(i) == cupcakeMenu.get(2)){
                    //run type method on value
                    cupcakeMenu.get(2).type();
                    //print price of cupcake
                    System.out.println(cupcakeMenu.get(2).getPrice());
                    //set subtotal = to subtotal plus cupcake price
                    subtotal += cupcakeMenu.get(2).getPrice();
                } else if(order.get(i) == drinkMenu.get(0)){
                    //run type method on value
                    drinkMenu.get(0).type();
                    //print price of drink
                    System.out.println(drinkMenu.get(0).getPrice());
                    //set subtotal = to subtotal plus drink price
                    subtotal += drinkMenu.get(0).getPrice();
                } else if(order.get(i) == drinkMenu.get(1)){
                    //run type method on value
                    drinkMenu.get(1).type();
                    //print price of drink
                    System.out.println(drinkMenu.get(1).getPrice());
                    //set subtotal = to subtotal plus drink price
                    subtotal += drinkMenu.get(0).getPrice();
                } else if(order.get(i) == drinkMenu.get(2)){
                    //run type method on value
                    drinkMenu.get(2).type();
                    //print price of drink
                    System.out.println(drinkMenu.get(2).getPrice());
                    //set subtotal = to subtotal plus drink price
                    subtotal += drinkMenu.get(2).getPrice();
                }
                System.out.println("subtotal: " + subtotal);
            }
            //call constructor functions for CreateFile class and WriteToFileClass
            new CreateFile();
            new WriteToFile(order);


        } else {
            System.out.println("Have a nice day then");
        }

    }
    //createFile class
    public static class CreateFile{
        //create a public constructor function
        public CreateFile() {
            //try catch block with parameter of IOException e
            try {
                //create a file object named salesData
                File salesData = new File("salesData.txt");
                if (salesData.createNewFile()) {
                    //if file is created print the name
                    System.out.println("File created: " + salesData.getName());
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.out.println("An error occurred");
            }

        }
    }
    //create a class named WriteToFile
    public static class WriteToFile{
        //public constructor function with parameter
        public WriteToFile(ArrayList<Object> order){
            try {
                //new FileWriter object with parameters name and boolean
                //boolean true is an option for appending to the file
                FileWriter fw = new FileWriter("salesData.txt", true);
                //new PrintWriter object with fw as parameter
                PrintWriter salesWriter = new PrintWriter(fw);
                //iterate through each element in order using a for loop to print the values
                for (int i = 0; i< order.size(); i++){
                    salesWriter.println(order.get(i));
                }
                //close salesWriter so it cannot continue to be run
                salesWriter.close();
                System.out.println("Successfully wrote to the file");
            } catch (IOException e) {
                System.out.println("An error occurred");
            }


        }
    }
}