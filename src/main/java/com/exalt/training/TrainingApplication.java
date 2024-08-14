package com.exalt.training;

import com.exalt.training.dao.AppDAO;
import com.exalt.training.dao.StudentDAO;
import com.exalt.training.entity.Instructor;
import com.exalt.training.entity.InstructorDetail;
import com.exalt.training.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			Integer id = createStudent(studentDAO);
//			readStudent(studentDAO, id);
//			readAllStudents(studentDAO);
//			findStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudentWithId(studentDAO);
//			deleteAllStudents(studentDAO);

			createInstructor(appDAO);
			System.out.println(findInstructorById(appDAO));
//			deleteInstructorById(appDAO);

			System.out.println(findInstructorDetailById(appDAO));
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

	private void findStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("find student with last name = `Katout`");
		List<Student> students = studentDAO.findByLastName("Katout");
		System.out.println("These students where found:");
		for(Student student : students)
			System.out.println(student);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.findAll();
		System.out.println("These students where found:");
		for(Student student : allStudents)
			System.out.println(student);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		System.out.println("Getting student with id = " + id);
		Student student = studentDAO.findById(id);
		System.out.println("Student: " + student);
		student.setLastName("Muneer");
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}


	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Number of deleted students: " + studentDAO.deleteAll());
	}

	private void deleteStudentWithId(StudentDAO studentDAO) {
		System.out.println("Deleting student with id = 3");
		studentDAO.deleteById(3);
	}


	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("riham", "katout", "test18@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("riham.youtube", "Sleeping");
		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
		System.out.println(instructor);
	}

	private Instructor findInstructorById(AppDAO appDAO){
		return appDAO.findInstructorById(1);
	}
	private void deleteInstructorById(AppDAO appDAO){
		appDAO.deleteInstructorById(3);
	}

	private InstructorDetail findInstructorDetailById(AppDAO appDAO){
		return appDAO.findInstructorDetailById(2);
	}
}
