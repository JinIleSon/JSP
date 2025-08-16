package controller.customer;

import java.io.IOException;

import dto.customerDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.customerService;

@WebServlet("/customer/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private customerService service = customerService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String custid = req.getParameter("custid");
		
		customerDTO customerDTO = service.findById(custid);
		
		if (customerDTO != null) {
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", customerDTO);
			
			resp.sendRedirect("/shopApp_copy/product/list.do?login=success");
		}else {
			resp.sendRedirect("/shopApp_copy/product/list.do?login=fail");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
