package controller.shop.product;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/modify.do")
public class ModifyController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String pno = req.getParameter("pno");
		
		ProductDTO ProductDTO = service.findById(pno);
		
		req.setAttribute("ProductDTO", ProductDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/product/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDTO dto = new ProductDTO();
		
		String pno = req.getParameter("pno");
		String pname = req.getParameter("pname");
		String stock = req.getParameter("stock");
		String price = req.getParameter("price");
		String company = req.getParameter("company");
		
		dto.setPno(pno);
		dto.setPname(pname);
		dto.setStock(stock);
		dto.setPrice(price);
		dto.setCompany(company);
		System.out.println(dto);
		service.modify(dto);
		
		
		
		resp.sendRedirect("/ch10/shop/product/list.do");
		
	}
}
