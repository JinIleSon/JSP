package jboard.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jboard.service.UserService;

@WebServlet("/user/check.do")
public class CheckUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String col = req.getParameter("col");
		String value = req.getParameter("value");
		
		int count = userService.getUserCount(col, value);
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("count", count);		
		
		// JSON 출력 - 브라우저 주소창에 http://localhost:8080/jboard/user/check.do?col=uid&value=a101 테스트 확인
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}