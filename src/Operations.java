//This class will contain the collection in which
//we will save the data/objects and will also 
//contain the methods of each CRUD operation

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Operations {

    //Let's create the collection Map
    //where key is the id of the Student object
    //and value is the complete Student object
    static Map<Integer, Student> studentMap = new HashMap<>();


    //We want the id of the student object be auto-generated
    //for which we can use AtomicInteger class
    static AtomicInteger atomic = new AtomicInteger(); //initial value is 0


    //Method for Add Student
    public static String addStudent(Student stud){
        stud.setId(atomic.incrementAndGet());
        studentMap.put(stud.getId(), stud);
        return "Student Object Added Successfully";
    }


    //Method for Display All Student Details
    public static Collection<Student> getAllStudents(){
        return studentMap.values();
    }

    //return single student object based on id in the map
    public static Student getStudent(int id){
        return studentMap.get(id);
    }

    //delete the student and return the delete message
    public static String deleteStudent(int id) {
        studentMap.remove(id);
        return "Student Object Deleted Successfully";
    }

    //update the student and return the update message
    public static String updateStudent(Student stud) {
        studentMap.put(stud.getId(), stud);
        return "Student Object Updated Successfully";
    }


}
