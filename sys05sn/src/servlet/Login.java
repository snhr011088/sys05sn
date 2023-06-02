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

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 00 TOP（ログイン）画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_password = request.getParameter("user_password");

		// ログイン成功時の処理
		if(user_password.equals("1111")) {
			// 01 通常画面（入退室等操作機能）へリダイレクト
			response.sendRedirect("/sys05sn/Operation");
		}else if(user_password.equals("8888")) {
			// 02 管理画面（管理機能）へリダイレクト
			response.sendRedirect("/sys05sn/Management");


		// ログイン失敗時の処理
		}else {
			// メッセージリストを作成
			List<String> messageList = new ArrayList<String>();
			messageList.add("パスワードが異なります。");

			//リクエストスコープにメッセージを保存
			request.setAttribute("messageList", messageList);

			//メッセージ表示画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
			dispatcher.forward(request, response);

		}

	}

}
