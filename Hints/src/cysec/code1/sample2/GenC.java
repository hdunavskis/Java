package cysec.code1.sample2;

public class GenC<T> {
    private T t;
       
    public T get(){
        return t;
    }
    public void add(T t){
        this.t = t;
    }
}
