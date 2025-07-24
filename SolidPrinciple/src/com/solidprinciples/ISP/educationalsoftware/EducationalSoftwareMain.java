package com.solidprinciples.ISP.educationalsoftware;

public class EducationalSoftwareMain {
	public static void main(String[] args) {

		IStudent student = new Student();
		ITeacher teacher = new Teacher();
		IExamCell exam = new ExamCell();

		teacher.createQuestionBank();

		exam.assignTeacher();

		student.startExam();

		teacher.gradeExam();

	}

}
