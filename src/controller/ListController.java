package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import front.Handle;
import vo.Paging;

public class ListController implements Handle {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;		//현재 페이지 초기값
		
		
		//db에서 글목록 가져오기
		ProductDao dao = ProductDao.getInstance();
//		request.setAttribute("list", dao.list());
//			ㄴ 아래 페이지 만들기로 변경합니다.
		
		String page=request.getParameter("page");
		if(page != null) currentPage = Integer.parseInt(page);		//list.jsp 에 page 파라미터를 찾아보세요.
		int pageSize=5;		//pageSize 를 15 또는 10으로 변경해서 실행해 봅시다.
		int totalCount = dao.count();
		
		//위의 값들을 이용해서 Paging 객체를 생성하면서 다른 필드값을 계산합니다.
		Paging paging = new Paging(currentPage, totalCount, pageSize);
		
		//pagelist() 메소드를 실행하기 위한 Map을 생성합니다.
		Map<String,Integer> map = new HashMap<>();
		map.put("start",paging.getStartNo());
		map.put("end",paging.getEndNo());

		//메소드 실행하고 애트리뷰트 저장합니다.
		request.setAttribute("list", dao.pagelist(map));
		
		//페이지 목록을 화면구현하기 위한 애트리뷰트를 저장합니다.
		request.setAttribute("paging", paging);
		
		// 현재 날짜 시간 저장 - 출력형식 2개 중 하나 고를때 비교값
		request.setAttribute("today", LocalDate.now());
		
		// 요청 링크가 /community/list 였고 원하는 jsp도 community 폴더에 있으므로 다음과 같음.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}


