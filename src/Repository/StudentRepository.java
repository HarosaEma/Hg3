package Repository;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IRepository {
    public StudentRepository(){
        studentList=new ArrayList<Student>();
    }
    public List<Student> studentList;

    /**
     * this method deletes the student by id
     * @param id
     */
    @Override
    public void delete(long id) {
        int i=0;
        while(i<studentList.size()){
            i++;
            if(studentList.get(i).studentID==id){
                studentList.remove(i);
            }
        }
    }

    /**
     * this method updates the student by id
     * @param id
     * @throws Exception
     */
    @Override
    public void update(long id) throws Exception {
        throw new Exception();
    }
    public void update(long id,String Name,String Surname){
        int i=0;
        while(i<studentList.size()){
            i++;
            if(studentList.get(i).studentID==id){
                studentList.set(i,new Student(id,Name,Surname));
            }
        }
    }

    /**
     * method for create a new object, a new student and add in the list
     * @throws Exception
     */
    @Override
    public void create() throws Exception {
        throw new Exception();
    }

    public void create(int ID, String Name, String Surname ) {
        Student auxStudent = new Student(ID,Name,Surname);
        studentList.add(auxStudent);
    }

    /**
     * this method prints the list of students
     * @param id
     */
    @Override
    public void read(long id) {
        int i=0;
        while(i<studentList.size()){
            i++;
            if(studentList.get(i).studentID==id){
                System.out.println(studentList.get(i));
                i=studentList.size()+1;
            }
        }
    }
}
