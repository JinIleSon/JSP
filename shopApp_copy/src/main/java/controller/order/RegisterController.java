package controller.order;

import java.io.IOException;

import dto.customerDTO;
import dto.orderDTO;
import dto.productDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.orderService;
import service.productService;

@WebServlet("/order/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private orderService service = orderService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		String prodCount = req.getParameter("prodCount");
		
		HttpSession session = req.getSession();
		customerDTO customerDTO = (customerDTO) session.getAttribute("sessUser");

		orderDTO dto = new orderDTO();
		
		dto.setOrderId(customerDTO.getCustid());
		dto.setOrderProduct(prodNo);
		dto.setOrderCount(prodCount);
		
		service.register(dto);
		
		resp.sendRedirect("/shopApp_copy/order/list.do");
	}
}
