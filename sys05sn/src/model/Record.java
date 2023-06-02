package model;

import java.io.Serializable;

/*
 * 入退室記録とメールに関する情報を持つJavaBeans
 */
public class Record implements Serializable{
	String recordId;		// レコードID
	String studentId;		// 生徒番号
	String record;			// 入退室記録
	String recordDate;		// 記録日時
	String emailText;		// 連絡内容
	String point;			// ポイント


	public Record(){};


	public Record(String recordId, String studentId, String record, String recordDate, String emailText, String point) {
		this.recordId = recordId;
		this.studentId = studentId;
		this.record = record;
		this.recordDate = recordDate;
		this.emailText = emailText;
		this.point = point;
	}


	// ゲッター

	public String getRecordId() {
		return recordId;
	}


	public String getStudentId() {
		return studentId;
	}


	public String getRecord() {
		return record;
	}


	public String getRecordDate() {
		return recordDate;
	}


	public String getEmailText() {
		return emailText;
	}


	public String getPoint() {
		return point;
	}

}

