package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import front.Handle;
import vo.ProductVo;

public class ProductListController implements Handle{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVo vo = new ProductVo();
		ProductDao dao = ProductDao.getInstance();
		List<ProductVo> list = dao.ProductList();
		request.setAttribute("list", list);
		String photo = list.get(1).getPhotofile();
		request.setAttribute("photo", photo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}
}
