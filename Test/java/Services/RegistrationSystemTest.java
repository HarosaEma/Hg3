package Services;

import Model.Course;
import Model.Student;
import Repository.CourseRepository;
import Repository.StudentRepository;
import Repository.TeacherRepository;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {

    void runAllTests() throws IOException {
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository=new TeacherRepository();
        CourseRepository courseRepository=new CourseRepository();
        studentRepository.create(1,"Ion","Pop");
        studentRepository.create(2,"Ionela","Popa");
        teacherRepository.create(1,"Ioana","Popescu");
        teacherRepository.create(2,"Ionelia","Apopii");
        courseRepository.create(1,"Biologie",15,teacherRepository.teacherList.get(0),10);
        courseRepository.create(2,"Fizica Cuantica",10,teacherRepository.teacherList.get(1),1);
        RegistrationSystem registrationSystem=new RegistrationSystem(teacherRepository,studentRepository,courseRepository);

        register(registrationSystem,courseRepository,studentRepository);
    }
    @Test
    void register(RegistrationSystem registrationSystem, CourseRepository courseRepository, StudentRepository studentRepository) {
        registrationSystem.register(courseRepository.courseList.get(0),studentRepository.studentList.get(0) );
        registrationSystem.register(courseRepository.courseList.get(0),studentRepository.studentList.get(1) );
    }

    @Test
    void retrieveCoursesWithFreePlaces(RegistrationSystem registrationSystem) {
        registrationSystem.retrieveCoursesWithFreePlaces();
    }

    @Test
    void retrieveStudentsEnrolledForACourse(RegistrationSystem registrationSystem,CourseRepository courseRepository) {
        registrationSystem.retrieveStudentsEnrolledForACourse(courseRepository.courseList.get(0));
    }

    @Test
    void getAllCourses(RegistrationSystem registrationSystem) {
        registrationSystem.getAllCourses();
    }
}