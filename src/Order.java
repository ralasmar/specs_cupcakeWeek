import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

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
                }
            //check if user wants to keep ordering
                System.out.println("Would you like to continue ordering? (Y/N)");
                placeOrder = input.nextLine();
                if(!placeOrder.equalsIgnoreCase("Y")){
                    ordering = false;
            }


        } else {
            System.out.println("Have a nice day then");
        }

    }
}