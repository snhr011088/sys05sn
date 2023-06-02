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
import model.Student;

@WebServlet("/Operation")
public class Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String mode = request.getParameter("mode");

		if(null == mode) {

			// 01 通常画面（入退室等操作機能）へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operation.jsp");
			dispatcher.forward(request, response);

		}else {

			// リクエストスコープにモードを保存
			request.setAttribute("mode", mode);

			// 生徒リスト（学年順）を取得して、リクエストスコープに保存
			StudentDAO dao = new StudentDAO();
			List<Student> studentList = dao.searchAllByGrade();
			request.setAttribute("studentList", studentList);

			// 01_01～05　生徒選択画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selectStudent.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String mode = request.getParameter("mode");
		String modeName = request.getParameter("modeName");
		String[] studentIdList = request.getParameterValues("studentIdList[]");

		// 生徒リスト（学年順）を取得して、リクエストスコープに保存
		StudentDAO dao = new StudentDAO();
		List<Student> studentList = new ArrayList<>();
		for(String student_id: studentIdList) {
			studentList.add(dao.searchAStudent(student_id));
		}

		request.setAttribute("studentList", studentList);
		request.setAttribute("studentIdList[]", studentIdList);
		request.setAttribute("mode", mode);
		request.setAttribute("modeName", modeName);

		// 01_01～05_01　確認画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirmOperation.jsp");
		dispatcher.forward(request, response);
	}

}
