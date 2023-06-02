package model;

import java.io.Serializable;

/*
 * 生徒に関する情報を持つJavaBeans
 */
public class Student implements Serializable{
	String studentId;		// 生徒番号
	String passNumber;		// 暗証番号
	String name;			// 氏名
	String grade;			// 学年コード
	String sendMail;		// 電子メール連絡
	String mailAddress;		// 電子メールアドレス


	public Student(){};


	public Student(String studentId, String passNumber, String name, String grade, String sendMail, String mailAddress) {
		this.studentId = studentId;
		this.passNumber = passNumber;
		this.name = name;
		this.grade = grade;
		this.sendMail = sendMail;
		this.mailAddress = mailAddress;
	}

	// ゲッター
	public String getStudentId() {
		return studentId;
	}


	public String getPassNumber() {
		return passNumber;
	}


	public String getName() {
		return name;
	}


	public String getGrade() {
		return grade;
	}


	public String getSendMail() {
		return sendMail;
	}


	public String getMailAddress() {
		return mailAddress;
	}

}
