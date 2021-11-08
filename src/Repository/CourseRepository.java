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

    /**
     *  this method deletes the course by id
     * @param id
     */
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

    /**
     * this method update the course by id
     * @param id
     * @throws Exception
     */

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

    /**
     * method for create a new object, a new course and add in the list
     * @throws Exception
     */


    @Override
    public void create() throws Exception {
        throw new Exception();
    }

    public void create(long ID, String Name, int credits, Teacher teacher, int maxEnrollment) {
        Course auxCourse = new Course(ID,Name,credits,teacher,maxEnrollment);
        courseList.add(auxCourse);
    }

    /**
     * this method prints the list of courses
     * @param id
     */

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
