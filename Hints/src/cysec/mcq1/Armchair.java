package cysec.mcq1;

class Chair{
    // Note: as there is a constructor here, the compiler will
    // NOT insert the default constructor:
    //          Chair(){
    //             super();
    //          }
    Chair(String s){}
}
public class Armchair extends Chair{
    Armchair(String s){
        //super(); // Chair()
    }
    
    public static void main(String[] args) {
        new Armchair("SK");
    }
}
