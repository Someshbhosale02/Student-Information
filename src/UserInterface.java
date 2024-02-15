//This class will contain the menue for the uer interaction 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Create an infinite loop to repeat the menu
        while (true) {

        System.out.println("\nSelect an operation to perform : ");
        System.out.println("1. Add Student Details");
        System.out.println("2. Update Student Details");
        System.out.println("3. Delete Student Details");
        System.out.println("4. Display Student Details");
        System.out.println("5. Display All Student Details");
        System.out.println("6. Display All Stuent Details Sorted By Name");
        System.out.println("7. Display All Stuent Details Sorted By Age");
        System.out.println("8. Display All Stuent Details Sorted By Marks");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");

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
                System.out.print("Enter Name: ");
                name = sc.next();
                System.out.print("Enter Age: ");
                age = sc.nextInt();
                System.out.print("Enter Marks: ");
                marks = sc.nextDouble();
               
                stud = new Student(name, age, marks);
                Operations.addStudent(stud);

                break;
            case 2:
                System.out.println("Enter the ID of the Stuent: ");
                id = sc.nextInt();
                stud = Operations.getStudent(id);
                if (stud == null) 
                    System.out.println("Student does not exists!");
                else
                    System.out.println("What do you want to update? ");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("3. Marks");
                    System.out.print("Enter your choice: ");
                    cohice = sc.nextInt();

                    switch (cohice) {
                        case 1: System.out.print("Enter New Name: ");
                                name = sc.next();
                                stud.setName(name);
                                break;
                        case 2: System.out.print("Enter New Age: ");
                                age = sc.nextInt();
                                stud.setAge(age);
                                break;
                        case 3: System.out.print("Enter New Marks: ");
                                marks = sc.nextDouble();
                                stud.setMarks(marks);
                                break;        
                        default:
                                System.out.println("Please Enter a valid Choice...");
                                break;
                    }
                    System.out.println(Operations.updateStudent(stud)+"\n");
                break;
            case 3:
                System.out.println("Enter the ID of the Stuent: ");
                id = sc.nextInt();
                stud = Operations.getStudent(id);
                if (stud == null) 
                    System.out.println("Student does not exists");
                else
                    System.out.println(Operations.deleteStudent(id));
                break;
            case 4:
                System.out.println("Enter the ID of the student: ");
                id = sc.nextInt();
                stud = Operations.getStudent(id);
                if (stud == null) 
                    System.out.println("Student does not exit");
                else
                    System.out.println(stud);
                break;
            case 5:
                List<Student> students = 
                        new ArrayList<>(Operations.getAllStudents());
                        if (students.isEmpty()) 
                            System.out.println("No Student Record Found");
                        else
                            students.forEach(s -> System.out.println(s));
                break;
            case 6:
                students = new ArrayList<>(Operations.getAllStudents());
                if (students.isEmpty()) 
                    System.out.println("No Student Recor Found!");
                else
                    students.stream()
                            .sorted((s1,s2)-> {
                                String name1 = s1.getName();
                                String name2 = s2.getName();
                                return name1.compareTo(name2);
                            })
                            .forEach(s -> System.out.println(s));
                break;
                
            case 7:
            students = new ArrayList<>(Operations.getAllStudents());
            if (students.isEmpty()) 
                System.out.println("No Student Recor Found!");
            else
                students.stream()
                        .sorted((s1,s2)-> {
                            Integer age1 = s1.getAge();
                            Integer age2 = s2.getAge();
                            return age1.compareTo(age2);
                        })
                        .forEach(s -> System.out.println(s));
                break;
            case 8: 
            students = new ArrayList<>(Operations.getAllStudents());
            if (students.isEmpty()) 
                System.out.println("No Student Recor Found!");
            else
                students.stream()
                        .sorted((s1,s2)-> {
                            Double marks1 = s1.getMarks();
                            Double marks2 = s2.getMarks();
                            return marks1.compareTo(marks2);
                        })
                        .forEach(s -> System.out.println(s));
            default:
                System.out.println("Please Enter a valid Choice...");
                break;
        }
        }
        sc.close();
    }
}
