import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //new array list that contains Cupcake objects named cupcakeMenu
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();
        //new objects, (format: className objName = new className();)
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        //new scanner to accept the user's input
        Scanner input = new Scanner(System.in);

        //DECIDING PRICE FOR STANDARD CUPCAKE
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        //call type method
        cupcake.type();

        System.out.println("How much would you like to charge for the cupcake? (Enter a numerical number taken to 2 decimal places)");

        //new variable set equal to user input
        String priceText = input.nextLine();
        //accepted price as a string so we can convert it into a double
        double price = Double.parseDouble(priceText);
        //call setPrice method with a parameter of price
        cupcake.setPrice(price);

        //DECIDING PRICE FOR RED VELVET CUPCAKE
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description: ");
        //call type method on redVelvet
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");

        //same input to variable
        String priceTextRedVelvet = input.nextLine();
        double priceRedVelvet = Double.parseDouble((priceTextRedVelvet));

        //call set price method with parameter price
        redVelvet.setPrice(priceRedVelvet);

        //DECIDING PRICE FOR CHOCOLATE CUPCAKE
        System.out.println("We are deciding the price for our chocolate cupcake. Here is the description: ");
        chocolate.type();

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");

        String priceTextChocolate = input.nextLine();
        double priceChocolate = Double.parseDouble(priceTextChocolate);

        chocolate.setPrice(priceChocolate);

        //add each cupcake object to the cupcakeMenu arraylist
        ((ArrayList<Cupcake>) cupcakeMenu).add(cupcake);
        ((ArrayList<Cupcake>) cupcakeMenu).add(redVelvet);
        ((ArrayList<Cupcake>) cupcakeMenu).add(chocolate);
    }
}