package com.exalt.training;

import com.exalt.training.dao.StudentDAO;
import com.exalt.training.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			Integer id = createStudent(studentDAO);
			readStudent(studentDAO, id);
		};
	}

	private Integer createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student ...");
		Student tmpStudent = new Student("Riham", "Katout", "test@gmail.com");
		System.out.println("Saving the student ...");
		studentDAO.save(tmpStudent);
		System.out.println("Saved student. Generated id: " + tmpStudent.getId());
		return tmpStudent.getId();
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {
		Student myStudent = studentDAO.findById(id);
		System.out.println("Found the student: "+myStudent);
	}
}
