package cysec.mcq1;

class Beta{
    static String s = "";
    protected Beta(){ s +="beta ";}
}
class SubBeta extends Beta{
    private SubBeta() {s += "sub ";}
}
public class SubSubBeta extends Beta{
    private SubSubBeta() {s += "subsub";}
    
    public static void main(String[] args) {
        new SubSubBeta();
        System.out.println(s);// beta subsub
    }
}
