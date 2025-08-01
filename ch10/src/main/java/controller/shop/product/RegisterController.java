package controller.shop.product;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/product/register.jsp");
		dispatcher.forward(req, resp);
		
		try {
			
			
			
		}catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pno = req.getParameter("pno");
		String pname = req.getParameter("pname");
		String stock = req.getParameter("stock");
		String price = req.getParameter("price");
		String company = req.getParameter("company");
		
		System.out.println(pno);
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPno(pno);
		productDTO.setPname(pname);
		productDTO.setStock(stock);
		productDTO.setPrice(price);
		productDTO.setCompany(company);
		
		logger.warn(productDTO.toString());
		
		service.register(productDTO);
		
		resp.sendRedirect("/ch10/shop/product/list.do");
	}
}
