package Services;

import Model.Course;
import Model.Student;
import Repository.CourseRepository;
import Repository.StudentRepository;
import Repository.TeacherRepository;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    TeacherRepository teacherRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;
    public RegistrationSystem(TeacherRepository teacherrepo, StudentRepository studentrepo, CourseRepository courserepo){
        this.teacherRepository=teacherrepo;
        this.studentRepository=studentrepo;
        this.courseRepository=courserepo;
    }
    public boolean register(Course course, Student student){
        int i=0;
        while(i<courseRepository.courseList.size()){

            if(courseRepository.courseList.get(i).courseID==course.courseID){
                courseRepository.courseList.get(i).studentsEnrolled.add(student);
                return true;

            }
            i++;
        }
        return false;


    };
    public List<Course> retrieveCoursesWithFreePlaces() {
        List<Course> auxList=new ArrayList<Course>();
        int i = 0;
        while (i< courseRepository.courseList.size()) {

            if (courseRepository.courseList.get(i).maxEnrollment != courseRepository.courseList.get(i).studentsEnrolled.size()) {
                auxList.add(courseRepository.courseList.get(i));
            }
            i++;
        }
        return auxList;
    }
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        int i=0;
        while(i<courseRepository.courseList.size()){

            if(courseRepository.courseList.get(i).courseID==course.courseID){
               return courseRepository.courseList.get(i).studentsEnrolled;
            }
            i++;
        }
        return null;
    };
}
