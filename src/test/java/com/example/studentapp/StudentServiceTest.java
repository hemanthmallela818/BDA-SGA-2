package com.example.studentapp;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;
import com.example.studentapp.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testGetAllStudents() {
        Student s1 = new Student();
        s1.setName("Jane");
        when(studentRepository.findAllStudentsWithCourse()).thenReturn(Arrays.asList(s1));

        List<Student> result = studentService.getAllStudents();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Jane");
    }
}
