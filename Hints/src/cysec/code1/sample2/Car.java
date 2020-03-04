package cysec.code1.sample2;

public class Car implements Comparable<Car>{
    private String make;
    private String model; 

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" + "make=" + make + ", model=" + model + '}';
    }
   
    
    @Override
    public int compareTo(Car otherCar){
        return this.getMake().compareTo(otherCar.getMake());
    }
    
}

