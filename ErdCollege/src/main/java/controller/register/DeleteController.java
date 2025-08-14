package controller.register;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.RegisterService;

@WebServlet("/register/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private RegisterService service = RegisterService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String regStdNo = req.getParameter("regStdNo");
		String regLecNo = req.getParameter("regLecNo");
		
		int regLecNoInt = 0;
		if (regLecNo != null) 
			regLecNoInt = Integer.parseInt(regLecNo);
		
		service.delete(regStdNo, regLecNoInt);
		
		resp.sendRedirect("/ErdCollege/register/list.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
