package cysec.code1.sample2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Driver {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int LAMBDAS = 1, GENERICS = 2, SORT_NATURAL_ORDER = 3, EXIT = 4;
        String userContinue = "y";

        while (userContinue.equalsIgnoreCase("y")) {
            switch (userChoice()) {
                case LAMBDAS:
                    lambdas();
                    break;
                case GENERICS:
                    generics();
                    break;
                case SORT_NATURAL_ORDER:
                    sortNaturalOrder();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    userContinue = "n";
                    break;
                default:
                    System.out.println("Unknown entry : ");
                    break;
            }
        }
    }

    public static void lambdas(){
        // Sort the cars by Model
        
        // Declaring the 'cars' reference - this must be left as is.
        List<Car> cars = new ArrayList<>();
        
        // Inserting the cars - this order must be left as is.
        cars.add(new Car("Fiat", "Panda"));
        cars.add(new Car("BMW", "X5"));
        cars.add(new Car("VW", "Passat"));
        cars.add(new Car("Toyota", "Camry"));

        //  Using a lambda expression, sort the cars by model alphabetically
        cars.sort( (car1, car2) -> car1.getModel().compareTo(car2.getModel()));

        
        // Outputting the cars afterwards.
        System.out.println("\nSorted by Model (alphabetically) :");
        for(Car car:cars){
            System.out.println(car);
        }
                
    }
    
    public static void sortNaturalOrder(){
        /*  Question - declare a collection and add some Car objects to it.
            This question is all about :
                a) setting up the Car class correctly and 
                b) declaring/using the correct Collection so that it sorts automatically.

        Note:
            a) The Car class specifies that it wants to sort by make alphabetically
            b) The collection type used here to add Car objects to, sorts 
               automatically according to the rules specified by Car.

           
        */

        // 1. Declare a 'cars' reference which holds Car objects only. 
        //    In addition:
        //      a) the reference type (which is an interface type) does not 
        //         allow duplicates (unique) 
        //      b) the object type (which implements the interface used for the
        //         reference) sorts automatically
        //      c) use type inference (the diamond operator)
        Set<Car> cars = new TreeSet<>();

        
        // Inserting the cars - this order must be left as is.
        cars.add(new Car("Renault", "Megane"));
        cars.add(new Car("Nissan", "Micra"));
        cars.add(new Car("Mercedes", "C-Class"));

        // Outputting the cars afterwards.
        System.out.println("\nSorted by Make (alphabetically) :");
        for(Car car:cars){
            System.out.println(car);
        }
        
    }

    public static void generics(){
        /* Question -   
            Create a generic GenC type. Demonstrate the generic in action.
                
        */
        
        // 1. After creating the GenC type, create the required instances 
        //    of GenC: 
        //          - one that accepts String's only, call it 'genS'
        //          - one that accepts Car's only, call it 'genCar'. 
        GenC<String> genS    = new GenC<>(); 
        GenC<Car> genCar     = new GenC<>(); 

        
        // 2. The String version - using the add() method, insert the String "Java is easy!" 
        //    into 'genS'. Then, using the generic's get() method, output it's  
        //    contents in a System.out.println() statement.
        genS.add("Java is easy!");             
        System.out.println(genS.get());

        
        // 3. The Car version - using the add() method, insert the following car
        // into 'genCar' - make is "Ford", model is "Focus".
        // Then, using the generic's get() method, output it's  contents in a 
        // System.out.println() statement.
        genCar.add(new Car("Ford", "Focus"));
        System.out.println(genCar.get());
        
    }
   
    public static int userChoice() {
        System.out.println("What do you want to do ?");
        System.out.println("1. Lambdas");
        System.out.println("2. Generics");
        System.out.println("3. Sort");
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
}
