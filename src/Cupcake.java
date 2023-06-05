public class Cupcake {
    public double price;

    //public function with no parameters that returns price
    public double getPrice() {
        return price;
    }
    //public function that returns void and takes in one parameter
    public void setPrice(double price){
        this.price = price;
        return;
    }
    //public function that returns void and prints a statement
    public void type(){
        System.out.println("A basic, generic cupcake, with vanilla frosting");
        return;
    }
}

//child class that will inherit rom CupCake
class RedVelvet extends Cupcake {
    //new type method that will override the parent class type method
    public void type(){
        System.out.println("A red velvet based cupcake, with cream cheese frosting");
    }
}

class Chocolate extends Cupcake {
    public void type(){
        System.out.println("A chocolate based cupcake, with chocolate frosting");
    }
}

