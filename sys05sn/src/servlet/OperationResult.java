package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.EmailLogic;
import model.Student;

@WebServlet("/OperationResult")
public class OperationResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String mode = request.getParameter("mode");
		String modeName = request.getParameter("modeName");
//		String student_id = request.getParameter("student_id");
		String[] studentIdList = request.getParameterValues("studentIdList[]");
		String kokugo = request.getParameter("kokugo");
		String sugaku = request.getParameter("sugaku");
		String eigo = request.getParameter("eigo");
		String shakai = request.getParameter("shakai");
		String rika = request.getParameter("rika");
		String emailText = request.getParameter("emailText");

		System.out.println(emailText);

		// 生徒リスト（学年順）を取得して、リクエストスコープに保存
		StudentDAO dao = new StudentDAO();
		List<Student> studentList = new ArrayList<>();
		for(String student_id: studentIdList) {
			studentList.add(dao.searchAStudent(student_id));
		}

		request.setAttribute("studentList", studentList);
		request.setAttribute("mode", mode);
		request.setAttribute("modeName", modeName);

		// Email表示用のテキストを取得して、リクエストスコープに保存
		EmailLogic emailLogic = new EmailLogic();
		String testText = emailLogic.createTestText(kokugo, sugaku, eigo, shakai, rika);
		emailText = emailLogic.createEmailText(emailText);

		request.setAttribute("testText", testText);
		request.setAttribute("emailText", emailText);

		// 01_01～05_02　操作完了画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operationResult.jsp");
		dispatcher.forward(request, response);
	}

}
