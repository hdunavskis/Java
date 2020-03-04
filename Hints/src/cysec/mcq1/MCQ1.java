package cysec.mcq1;

// MCQ1.java        - Q's 1,2,3,4,5,6,8,10,12
// Armchair.java    - Q7
// Terrier.java     - Q9+
// Train.java       - Q11
// Tenor.java       - Q13
// Plane.java       - Q14
// SubSubBeta       - Q15
// Zoo              - Q16, Q19
// Remaining questions - things to note:
//  - the singleton pattern is a Creational pattern
//  -      enum SINGLETON{INSTANCE};
//  - java.util.ArrayList is a Collection class that 
//     provides indexed access to its elements (LOD)
//  - a Set is a Collection interface that stores unique 
//    objects in an unordered fashion (SUU)

// q4
enum Directions{NORTH, SOUTH};

// q1, q10
class A { void a(){} }
class B extends A{ void b(){} }
interface I1{}
interface I2 extends I1{}
//class C extends I1{}
//interface I3 extends A{}

// q5 - classes (including abstract ones) *extend* other classes
//      and *implement* interfaces. Also, a class can implement
//      many interfaces but extend from only one class.
abstract class D{}
class E extends D implements I1,I2{}

// q6 - an interface can extend from many other interfaces
//      note: as stated above, a class cannot extend from many
//      classes - multiple (class) inheritance is not allowed
interface I4 extends I1, I2{};

// q7 - see Armchair.java in this package
//      note: the compiler will not insert a default ctor if
//      a ctor is already present - be careful, as the compiler
//      inserts "super();" as the first line in a ctor (unless
//      "this();" is there already). 

// q2, q8
class R{    // Rocket/Shuttle
    // the following method is private and is thus NOT inherited
    // therefore, the sub-type version is not attempting to override
    // a "final" method - an error
    private final void go(){    // q8 - final
        System.out.println("R::go()");
    }
}
// q12
abstract interface X{ public void y (String s); }
class F implements X{
    public void y(String s){}
    public void y(Integer i){}
}
abstract class F2 implements X{} 

public class MCQ1 extends R{
    public static void main(String[] args) {
        //new MCQ1().go();  // q2
//        new MCQ1().switchExample();   // q3
        //new MCQ1().enumTest();  // q4
 //       new MCQ1().q10();  // q10
    }
    private void go(){  // q8 - no override here as parent method is private
        System.out.println("MCQ1::go()");
        //super.go();
    }
    // q3
    void switchExample(){
        String[] teams = {"Galway", "mayo"};
        for(String team:teams){
            switch(team){
                case "Galway":
                    System.out.println("Galway");
                    break;
                case "Mayo":
                    System.out.println("mayo");
                    break;
                default:
                    System.out.println("no match");
                    break;
            }
        }
    }
    void enumTest(){
        for(Directions d:Directions.values()){
            System.out.println(d);
        }
    }
    void q10(){
        A a1 = new A();
        A a2 = new A();
        B b1 = new B();
        
        
        // trying to call b() in B using the A ref 'a2'
        //a2.b();
        //(B)a2.b();
        ((B)a2).b();
    }
}
