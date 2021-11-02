package Model;

import Model.Person;
import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    public String name;
    public Person teacher;
    public int maxEnrollment;
    public List<Student> studentsEnrolled;
    public int credits;
    public long courseID;

    public Course(long ID, String name,int credits,Person teacher,int maxEnrollment){
        this.courseID=ID;
        this.name=name;
        this.credits=credits;
        this.teacher=teacher;
        this.maxEnrollment=maxEnrollment;
        this.studentsEnrolled=new ArrayList<Student>();
    }
}
