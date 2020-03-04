package cysec.code1.sample;

public class Dog implements Comparable<Dog>{
    private Integer age;
    private String name; // sort by name

    public Dog(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" + "age=" + age + ", name=" + name + '}';
    }
    
    @Override
    public int compareTo(Dog otherDog){
        return this.getName().compareTo(otherDog.getName());
    }
    
}
