package cysec.mcq1;

import java.util.ArrayList;

class WildAnimal{
    String name = "Wild";
    String makeNoise() {return "Generic growl";}
}
class Lion extends WildAnimal{
    String name = "Lion";
    String makeNoise() {return "Roar";}
}
public class Zoo {
    public static void main(String[] args) {
        new Zoo().go();
    }
    void go(){
        WildAnimal wa = new Lion();
        System.out.println(wa.name + " " + wa.makeNoise());
    }
    
    // Q19
    ArrayList<WildAnimal> goAgain(){
//        return new ArrayList<Lion>(); // subtype
//        return new ArrayList<Object>();// supertype
        return new ArrayList<WildAnimal>();
    }    
}
