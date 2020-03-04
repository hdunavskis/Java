package cysec.mcq1;

class Aircraft {
    Aircraft() {System.out.println("b");}
    Aircraft(String s){System.out.println("bn "+s);}
 }
class Plane extends Aircraft{
    Plane(){
        // super(); will be inserted here by the compiler
        System.out.println("h ");
    }
    Plane(String s){ // s == "x "
        this(); // call to Plane()
        System.out.println("hn "+s);
    }
    public static void main(String[] args) {
        new Plane("x ");
    }
}
