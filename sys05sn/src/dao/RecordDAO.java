package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Record;

public class RecordDAO {
	private final String URL = "jdbc:postgresql://localhost:5432/sys05sn";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

////////// コンストラクタ //////////
	public RecordDAO() {
		/* JDBCドライバの準備 */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//////////// 複数の生徒のレコードを検索する処理 //////////
//
//	public  List<Record> searchAllByStudentId() {
//
//		List<Student> studentList = new ArrayList<>();
//
//		/* 1) SQL文の準備 */
//		String sql = "SELECT * FROM student ORDER BY student_id ;";
//
//		/* 2) PostgreSQLへの接続 */
// 		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
// 			PreparedStatement pStmt = con.prepareStatement(sql);) {
//
//		    /* SELECT文の実行 */
//			ResultSet rs = pStmt.executeQuery();
//
//			/* 結果をリストに移し替える */
//			while(rs.next()) {
//
//				 String studentId = rs.getString("student_id");
//				 String passNumber = rs.getString("pass_number");
//				 String name = rs.getString("name");
//				 String grade = rs.getString("grade");
//				 String sendMail = rs.getString("send_mail");
//				 String mailAddress = rs.getString("mail_address");
//
//				Student student  = new Student(studentId, passNumber, name, grade, sendMail, mailAddress);
//				studentList.add(student);
//
//			}
//		} catch(Exception e) {
//			System.out.println("DBアクセス時にエラーが発生しました。");
//			e.printStackTrace();
//		}
// 		return studentList;
//
//	}
//
//
////////////全生徒を検索する（学年順）処理 //////////
//
//public  List<Student> searchAllByGrade() {
//
//	List<Student> studentList = new ArrayList<>();
//
//	/* 1) SQL文の準備 */
//	String sql = "SELECT * FROM student ORDER BY grade, student_id;";
//
//	/* 2) PostgreSQLへの接続 */
//	try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//		PreparedStatement pStmt = con.prepareStatement(sql);) {
//
//	    /* SELECT文の実行 */
//		ResultSet rs = pStmt.executeQuery();
//
//		/* 結果をリストに移し替える */
//		while(rs.next()) {
//
//			 String studentId = rs.getString("student_id");
//			 String passNumber = rs.getString("pass_number");
//			 String name = rs.getString("name");
//			 String grade = rs.getString("grade");
//			 String sendMail = rs.getString("send_mail");
//			 String mailAddress = rs.getString("mail_address");
//
//			Student student  = new Student(studentId, passNumber, name, grade, sendMail, mailAddress);
//			studentList.add(student);
//
//		}
//	} catch(Exception e) {
//		System.out.println("DBアクセス時にエラーが発生しました。");
//		e.printStackTrace();
//	}
//	return studentList;
//
//}
//
//////////// 複数の生徒を検索する処理 //////////
//
//public List<Student> searchStudents(List<String> studentIdList) {
//
//	List<Student> studentList = new ArrayList<>();
//	for(String student_id: studentIdList) {
//
//		Student student = searchAStudent(student_id);
//		studentList.add(student);
//	}
//
//	return studentList;
//}

////////// 生徒1人のレコードを検索する処理 //////////

	public  List<Record> searchAStudentRecord(String student_id) {

		List<Record> recordList = new ArrayList<>();

		/* 1) SQL文の準備 */
		String sql = "SELECT * FROM record WHERE student_id = '" + student_id + "' ORDER BY record_id DESC ;";

		/* 2) PostgreSQLへの接続 */
 		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
 			PreparedStatement pStmt = con.prepareStatement(sql);) {

		    /* SELECT文の実行 */
			ResultSet rs = pStmt.executeQuery();

			/* 結果をリストに移し替える */
			while(rs.next()) {

				 String recordId = rs.getString("record_id");
				 String studentId = rs.getString("student_id");
				 String record = rs.getString("record");
				 String recordDate = rs.getString("record_date");
				 String emailText = rs.getString("email_text");
				 String point = rs.getString("point");

				Record newRecord = new Record(recordId, studentId, record, recordDate, emailText, point);
				recordList.add(newRecord);

			}
		} catch(Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}

		return recordList;


	}
}
