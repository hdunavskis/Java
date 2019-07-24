package com.ait.StudentGrade;

public class StudentGrade {

	private char result;
	
	public int getGrade(int grade) {
		
		if(grade > 84) {
			result = 'A';
		}
		else if(grade > 69) {
			result = 'B';
		}
		else if(grade > 54) {
			result = 'C';
		}
		else if(grade > 39) {
			result = 'D';
		}
		else if(grade > 24) {
			result = 'E';
		}
		else if (grade < 25){
			result = 'F';
		}
		return this.result;
	}
}
