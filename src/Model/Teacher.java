package Model;

import Model.Person;

import java.util.List;

public class Teacher extends Person {
    private List<Course> courses;
    public long teacherID;
    public  String Name;
    public String Surname;
    public Teacher(long ID, String Name, String Surname){
        this.teacherID=ID;
        this.Name=Name;
        this.Surname=Surname;
    }

}
