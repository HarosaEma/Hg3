package Repository;
import Model.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements IRepository {
    public TeacherRepository(){
        teacherList=new ArrayList<Teacher>();
    }
    public List<Teacher> teacherList;

    /**
     * this method deletes the teacher by id
     * @param id
     */
    @Override
    public void delete(long id) {
        int i=0;
        while(i<teacherList.size()){
            i++;
            if(teacherList.get(i).teacherID==id){
                teacherList.remove(i);
            }
        }
    }

    /**
     * this method updates the teacher by id
     * @param id
     * @throws Exception
     */

    @Override
    public void update(long id) throws Exception{
        throw new Exception();
    }

    public void update(long id,String Name,String Surname){
        int i=0;
        while(i<teacherList.size()){
            i++;
            if(teacherList.get(i).teacherID==id){
                teacherList.set(i, new Teacher(id, Name, Surname));
            }
        }
    }

    /**
     *  method for create a new object, a new teacher and add in the list
     * @throws Exception
     */


    @Override
    public void create() throws Exception{
        throw new Exception();
    }

    public void create(int ID, String Name, String Surname) throws IOException {
        Teacher auxTeacher = new Teacher(ID,Name, Surname);
        teacherList.add(auxTeacher);

    }

    /**
     * this method prints the list of teachers
     * @param id
     */

    @Override
    public void read(long id) {

        int i=0;
        while(i<teacherList.size()){
            i++;
            if(teacherList.get(i).teacherID==id){
                System.out.println(teacherList.get(i));

                i=teacherList.size()+1;
            }
        }


    }

}
