package controller.student;

import java.io.IOException;

import dto.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.StudentService;

@WebServlet("/student/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private StudentService service = StudentService.INSTANCE;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String stdNo = req.getParameter("stdNo");
		String stdName = req.getParameter("stdName");
		
		StudentDTO studentDTO = service.findByIdAndName(stdNo, stdName);
		
		if (studentDTO != null) {
			HttpSession session = req.getSession();
			session.setAttribute("sessStudent", studentDTO);
			
			resp.sendRedirect("/ErdCollege/?login=success");
		}else {
			resp.sendRedirect("/ErdCollege/?login=fail");
		}
		
	}
}
