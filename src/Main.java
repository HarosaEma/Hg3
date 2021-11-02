import Repository.StudentRepository;
import Repository.TeacherRepository;
import Repository.CourseRepository;
import Services.RegistrationSystem;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository=new TeacherRepository();
        CourseRepository courseRepository=new CourseRepository();
        studentRepository.create(1,"Ion","Pop");
        studentRepository.create(2,"Ionela","Popa");
        teacherRepository.create(1,"Ioana","Popescu");
        teacherRepository.create(2,"Ionelia","Apopii");
        courseRepository.create(1,"Biologie",15,teacherRepository.teacherList.get(0),10);
        courseRepository.create(2,"Fizica Cuantica",10,teacherRepository.teacherList.get(1),1);
        RegistrationSystem plm=new RegistrationSystem(teacherRepository,studentRepository,courseRepository);
        plm.register(courseRepository.courseList.get(0),studentRepository.studentList.get(0) );
        plm.retrieveCoursesWithFreePlaces();
        plm.retrieveStudentsEnrolledForACourse(courseRepository.courseList.get(0));

    }
}
