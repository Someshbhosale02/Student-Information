//This class will contain the menue for the uer interaction 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Create an infinite loop to repeat the menu
        while (true) {

        System.out.println("Select an operation to perform : ");
        System.out.println("1. Add Student Details");
        System.out.println("2. Update Student Details");
        System.out.println("3. Delete Student Details");
        System.out.println("4. Display Student Details");
        System.out.println("5. Display All Student Details");
        System.out.println("0. Exit");
        System.out.println("/nEnter your choice: ");

        int cohice = sc.nextInt();

        //For quitting the menu
        if (cohice == 0) {
            break;
        }

        String name;
        int age, id;
        double marks;
        Student stud;


        switch (cohice) {
            case 1:
                System.out.println("Enter Name: ");
                name = sc.next();
                System.out.println("Enter Age: ");
                age = sc.nextInt();
                System.out.println("Enter Marks: ");
                marks = sc.nextDouble();
               
                stud = new Student(name, age, marks);
                Operations.addStudent(stud);

                break;
            case 2:
                System.out.println("Update Student");
                break;
            case 3:
                System.out.println("Delete Student");
                break;
            case 4:
                System.out.println("Enter the ID of the student: ");
                id = sc.nextInt();
                stud = Operations.gStudent(id);
                if (stud == null) {
                    System.out.println("Student does not exit");
                }else{
                    System.out.println(stud);
                }
                break;
            case 5:
                List<Student> students = 
                        new ArrayList<>(Operations.getAllStudents());
                        students.forEach(s -> System.out.println(s));
                break;
            default:
                System.out.println("Please Enter a valid Choice...");
                break;
        }
        }
        sc.close();
    }
}
