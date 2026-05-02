package com.example.studentapp.config;

import com.example.studentapp.entity.Course;
import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.CourseRepository;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(CourseRepository courseRepository, StudentRepository studentRepository) {
        return args -> {
            if (courseRepository.count() == 0) {
                Course course1 = new Course();
                course1.setCourseName("Computer Science");
                
                Course course2 = new Course();
                course2.setCourseName("Mathematics");

                Course course3 = new Course();
                course3.setCourseName("Physics");

                Course course4 = new Course();
                course4.setCourseName("Chemistry");

                Course course5 = new Course();
                course5.setCourseName("Biology");

                Course course6 = new Course();
                course6.setCourseName("History");

                Course course7 = new Course();
                course7.setCourseName("Literature");

                Course course8 = new Course();
                course8.setCourseName("Geography");

                Course course9 = new Course();
                course9.setCourseName("Economics");

                Course course10 = new Course();
                course10.setCourseName("Philosophy");

                courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4, course5, course6, course7, course8, course9, course10));

                Student student1 = new Student();
                student1.setName("Alice");
                student1.setEmail("alice@example.com");
                student1.setCourse(course1);

                Student student2 = new Student();
                student2.setName("Bob");
                student2.setEmail("bob@example.com");
                student2.setCourse(course1);

                Student student3 = new Student();
                student3.setName("Charlie");
                student3.setEmail("charlie@example.com");
                student3.setCourse(course2);

                Student student4 = new Student();
                student4.setName("David");
                student4.setEmail("david@example.com");
                student4.setCourse(course2);

                Student student5 = new Student();
                student5.setName("Eve");
                student5.setEmail("eve@example.com");
                student5.setCourse(course3);

                Student student6 = new Student();
                student6.setName("Frank");
                student6.setEmail("frank@example.com");
                student6.setCourse(course3);

                Student student7 = new Student();
                student7.setName("Grace");
                student7.setEmail("grace@example.com");
                student7.setCourse(course1);

                Student student8 = new Student();
                student8.setName("Heidi");
                student8.setEmail("heidi@example.com");
                student8.setCourse(course2);

                Student student9 = new Student();
                student9.setName("Ivan");
                student9.setEmail("ivan@example.com");
                student9.setCourse(course3);

                Student student10 = new Student();
                student10.setName("Judy");
                student10.setEmail("judy@example.com");
                student10.setCourse(course1);

                studentRepository.saveAll(Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10));
            }
        };
    }
}
