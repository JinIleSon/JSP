package controller.product;

import java.io.IOException;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션 사용자 정보 가져오기(로그인을 안했으면 null)
		HttpSession session = req.getSession();
		Object sessUser = (CustomerDTO) session.getAttribute("sessUser");
		
		// request 공유
		req.setAttribute("sessUser", sessUser);
		
		// 뷰 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
