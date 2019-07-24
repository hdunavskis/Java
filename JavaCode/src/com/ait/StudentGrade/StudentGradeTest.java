package com.ait.StudentGrade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StudentGradeTest {

	StudentGrade s = new StudentGrade();
	@Test
	void testStudentGradeBoundaries86() {
	
		assertEquals('A', s.getGrade(86));
	}
	@Test
	void testStudentGradeBoundaries84() {
	
		assertEquals('B', s.getGrade(84));
	}
	@Test
	void testStudentGradeBoundaries85() {
	
		assertEquals('A', s.getGrade(85));
	}
	@Test
	void testStudentGradeBoundaries70() {
	
		assertEquals('B', s.getGrade(70));
	}
	@Test
	void testStudentGradeBoundaries71() {
	
		assertEquals('B', s.getGrade(71));
	}
	@Test
	void testStudentGradeBoundaries69() {
	
		assertEquals('C', s.getGrade(69));
	}
	@Test
	void testStudentGradeBoundaries55() {
	
		assertEquals('C', s.getGrade(55));
	}
	@Test
	void testStudentGradeBoundaries54() {
	
		assertEquals('D', s.getGrade(54));
	}
	@Test
	void testStudentGradeBoundaries56() {
	
		assertEquals('C', s.getGrade(56));
	}
	@Test
	void testStudentGradeBoundaries40() {
	
		assertEquals('D', s.getGrade(40));
	}
	@Test
	void testStudentGradeBoundaries41() {
	
		assertEquals('D', s.getGrade(41));
	}
	@Test
	void testStudentGradeBoundaries39() {
	
		assertEquals('E', s.getGrade(39));
	}
	@Test
	void testStudentGradeBoundaries25() {
	
		assertEquals('E', s.getGrade(25));
	}
	@Test
	void testStudentGradeBoundaries26() {
	
		assertEquals('E', s.getGrade(26));
	}
	@Test
	void testStudentGradeBoundaries24() {
	
		assertEquals('F', s.getGrade(24));
	}
	

}
