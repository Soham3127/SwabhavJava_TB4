package com.solidprinciples.ISP.educationalsoftware;

public class Teacher  implements ITeacher{

	@Override
	public void gradeExam() {
		System.out.println("Teacher grades the exam....");
		
	}

	@Override
	public void createQuestionBank() {
		System.out.println("Teacher creates the Question Bank....");
	}

}
