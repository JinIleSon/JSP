package sub1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L; // Servlet 고유 번호
	
	@Override
	public void init() throws ServletException {
		// 서블릿이 최초 생성될 때 초기화 메서드
		System.out.println("helloServlet init...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet get 요청!!!");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet post 요청!!!");
	}
}
