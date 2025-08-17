package controller.account;

import java.io.IOException;
import java.util.List;

import dto.TransactionDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TransactionService;

@WebServlet("/account/check.do")
public class CheckController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private TransactionService service = TransactionService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String a_no = req.getParameter("a_no");
		
		List<TransactionDTO> dtoList = service.findCheckAll(a_no);
		
		req.setAttribute("dtoList", dtoList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/check.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
