package Model;

import Model.Person;

import java.util.List;

public class Student extends Person {
    public long studentID;
    private int totalCredits;
    private List<Course> enrolledCourse;
    public Student(long ID, String Name, String Surname){
        this.studentID=ID;
        this.firstName=Name;
        this.lastName=Surname;
        totalCredits=0;
    }
}
