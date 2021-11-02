package Repository;

import Model.Course;
import Model.Student;
import Model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements IRepository {
    public CourseRepository(){
        courseList=new ArrayList<Course>();
    }
   public List<Course> courseList;

    @Override
    public void delete(long id) {
        int i=0;
        while(i<courseList.size()){
            i++;
            if(courseList.get(i).courseID==id){
                courseList.remove(i);
            }
        }
    }

    @Override
    public void update(long id) throws Exception {
        throw new Exception();
    }
    public void update(long id, String Name, int credits, Teacher teacher, int maxEnrollment){
        int i=0;
        while(i<courseList.size()){
            i++;
            if(courseList.get(i).courseID==id){
                courseList.set(i, new Course(id, Name,credits,teacher,maxEnrollment));
            }
        }
    }


    @Override
    public void create() throws Exception {
        throw new Exception();
    }

    public void create(long ID, String Name, int credits, Teacher teacher, int maxEnrollment) {
        Course auxCourse = new Course(ID,Name,credits,teacher,maxEnrollment);
        courseList.add(auxCourse);
    }


    @Override
    public void read(long id) {
        int i=0;
        while(i<courseList.size()){
            i++;
            if(courseList.get(i).courseID==id){
                System.out.println(courseList.get(i));
                i=courseList.size()+1;
            }
        }

    }
}
