package com.linkedin.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	void testGetStudentByName_returnsStudentDetails() {
		// GIVEN
		// Student savedStudent = studentRepository.save(new Student(null, "Mark"));
		Student savedStudent = testEntityManager.persistFlushFind(new Student(null, "Mark"));

		// WHEN
		Student student = studentRepository.getStudentByName("Mark");

		// THEN
		then(student.getId()).isNotNull();
		then(student.getName()).isEqualTo(savedStudent.getName());
	}

}
