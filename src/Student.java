//This is POJO (Plain Old Java Object)
//here we define only the properties of the
//object that we will be saving in the 
//collection. We will also define getter/setter
//methods, constructors, toString() method
public class Student {

    private int id;
    private String name;
    private int age;
    private double marks;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
    }

    public static void main(String[] args) {
        
    }
}
