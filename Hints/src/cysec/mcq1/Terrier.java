package cysec.mcq1;

class Animal{
    {System.out.println("b1");}             // 4
    Animal(){System.out.println("b2");}     // 5
            
}
class Dog extends Animal{
    static {System.out.println("r1");}      // 1
    Dog(){System.out.println("r2");}        // 7
    {System.out.println("r3");}             // 6
    static {System.out.println("r4");}      // 2
}
class Terrier extends Dog{
    public static void main(String[] args) {
        System.out.println("pre");          // 3
        new Terrier();
        System.out.println("Terrier");      // 8
    }
}
