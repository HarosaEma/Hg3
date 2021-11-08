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

    /**
     * method for register the student and the course
     * @param course
     * @param student
     * @return
     */
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

    /**
     * this method  retrieve courses with free places
     * @return
     */
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

    /**
     * this method retrieve students enrolled for a course
     * @param course
     * @return
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        int i=0;
        while(i<courseRepository.courseList.size()){
            if(courseRepository.courseList.get(i).courseID==course.courseID){
               return courseRepository.courseList.get(i).studentsEnrolled;
            }
            i++;
        }
        return null;
    }

    /**
     * this method get all courses
     * @return
     */
    public List<Course> getAllCourses(){
        int i=0;
        List<Course> auxCourses=new ArrayList<>();
        while(i<courseRepository.courseList.size()){
            auxCourses.add(courseRepository.courseList.get(i));
            i++;
        }
        return auxCourses;
    }

    /**
     * this method print all courses
     * @param courseList list of courses
     */
    static void printAllCourses(List<Course> courseList){
        int i=0;
        List<Course> auxCourses=new ArrayList<>();
        while(i<courseList.size()) {
            System.out.print(courseList.get(i).courseID +" "+ courseList.get(i).name);
            System.out.println();
            i++;
        }
    }

    /**
     * this method print all students enrolled for a course
     * @param studentList list of students
     */
    static void printAllStudentsEnrolledForACourse(List<Student> studentList) {
        int i = 0;
        List<Student> auxStudents = new ArrayList<>();
        while (i < studentList.size()) {
            System.out.print(studentList.get(i).firstName + " " + studentList.get(i).lastName);
            System.out.println();
            i++;
        }
    }
}
