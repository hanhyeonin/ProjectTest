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
		int currentPage = 1;		//현재 페이지 초기값
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

		//메소드 실행하고 애트리뷰트 저장합니다.
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
		// 요청 링크가 /community/list 였고 원하는 jsp도 community 폴더에 있으므로 다음과 같음.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}
}
