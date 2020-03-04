package cysec.mcq1;

class Singer{
    public static String sing(){ return "ray";}
}
public class Tenor extends Singer{
    public static String sing(){ return "doh";}
    
    public static void main(String[] args) {
        Tenor t  = new Tenor();
        Singer s = new Singer();
        System.out.println(t.sing() + " " + s.sing());
        
       // Singer s2 = new Tenor();
       // System.out.println(s2.sing());
    }
}
