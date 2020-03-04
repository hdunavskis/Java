package cysec.code1.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Cat{}

public class CodeOneSample {
    public static void main(String[] args) {
        //sort();
        lambdas();
        //generics();
    }
    public static void generics(){
        Other<String> otherS  = new Other<>();
        Other<Integer> otherI = new Other<>();
        Other<Dog> otherD     = new Other<>();
        Other<Object> otherO     = new Other<>();

        otherO.add("ABC");
        System.out.println(otherO.get());
        
        otherS.add("SK");
        System.out.println(otherS.get());

        otherI.add(3); // boxed as an Integer
        System.out.println(otherI.get()); // 3 -> "3"

        otherD.add(new Dog(4, "Captain")); 
        System.out.println(otherD.get()); 
    }
    public static void lambdas(){
        List<Dog> dogs = new ArrayList<>();
        
        dogs.add(new Dog(3, "Spot"));
        dogs.add(new Dog(2, "Rex"));
        dogs.add(new Dog(5, "Tyson"));
        dogs.add(new Dog(8, "Brownie"));
//        dogs.add(new Cat());
        
        // List::sort(Comparator<Dog>)
        // lamba implements the Comparator
        dogs.sort( 
                (d1, d2) ->  d1.getAge().compareTo(d2.getAge()) 
        );
        
        for(Dog dog:dogs){
            System.out.println(dog);
        }

        System.out.println("name...");
        dogs.sort( 
                (d1, d2) ->  d1.getName().compareTo(d2.getName()) 
        );
        
        for(Dog dog:dogs){
            System.out.println(dog);
        }
        

    }


    public static void sort(){
        Set<Dog> dogs = new TreeSet<>();
//        List<Dog> dogs = new ArrayList<>();
        
        dogs.add(new Dog(3, "Spot"));
        dogs.add(new Dog(2, "Rex"));
        dogs.add(new Dog(5, "Tyson"));
        dogs.add(new Dog(8, "Brownie"));
        
        for(Dog dog:dogs){
            System.out.println(dog);
        }
    }
    
}
