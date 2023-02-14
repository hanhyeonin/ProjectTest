package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import front.Handle;
import vo.Paging;
import vo.ProductVo;
import vo.ProductVo2;

public class ListController implements Handle{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;		//���� ������ �ʱⰪ
		ProductDao dao = ProductDao.getInstance();
		List<ProductVo> list = dao.selectList();
		List<ProductVo2> list2 = new ArrayList<>();
		
		String page=request.getParameter("page");
		if(page != null) currentPage = Integer.parseInt(page);	
		int pageSize=5;		
		int totalCount = dao.count();
		
		Paging paging = new Paging(currentPage, totalCount, pageSize);
		
		Map<String,Integer> map = new HashMap<>();
		
		map.put("start",paging.getStartNo());
		map.put("end",paging.getEndNo());

		//�޼ҵ� �����ϰ� ��Ʈ����Ʈ �����մϴ�.
		list = dao.pagelist(map);
		
		for(int i=0; i<list.size();i++) {
			list2.add(new ProductVo2(
					list.get(i).getPno(),
					list.get(i).getPname(),
					list.get(i).getPrice(),
					list.get(i).getPhotofile().split(","),
					list.get(i).getRoomcnt(),
					list.get(i).getAddress(),
					list.get(i).getSubaddress(),
					list.get(i).getDetailadd(),
					list.get(i).getRcount(),
					list.get(i).getPcategory()
					));
			
		}
		request.setAttribute("lists", list2);
		request.setAttribute("paging", paging);
		// ��û ��ũ�� /community/list ���� ���ϴ� jsp�� community ������ �����Ƿ� ������ ����.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}
}
