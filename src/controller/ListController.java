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
		int currentPage = 1;		//���� ������ �ʱⰪ
		
		
		//db���� �۸�� ��������
		ProductDao dao = ProductDao.getInstance();
//		request.setAttribute("list", dao.list());
//			�� �Ʒ� ������ ������ �����մϴ�.
		
		String page=request.getParameter("page");
		if(page != null) currentPage = Integer.parseInt(page);		//list.jsp �� page �Ķ���͸� ã�ƺ�����.
		int pageSize=5;		//pageSize �� 15 �Ǵ� 10���� �����ؼ� ������ ���ô�.
		int totalCount = dao.count();
		
		//���� ������ �̿��ؼ� Paging ��ü�� �����ϸ鼭 �ٸ� �ʵ尪�� ����մϴ�.
		Paging paging = new Paging(currentPage, totalCount, pageSize);
		
		//pagelist() �޼ҵ带 �����ϱ� ���� Map�� �����մϴ�.
		Map<String,Integer> map = new HashMap<>();
		map.put("start",paging.getStartNo());
		map.put("end",paging.getEndNo());

		//�޼ҵ� �����ϰ� ��Ʈ����Ʈ �����մϴ�.
		request.setAttribute("list", dao.pagelist(map));
		
		//������ ����� ȭ�鱸���ϱ� ���� ��Ʈ����Ʈ�� �����մϴ�.
		request.setAttribute("paging", paging);
		
		// ���� ��¥ �ð� ���� - ������� 2�� �� �ϳ� ���� �񱳰�
		request.setAttribute("today", LocalDate.now());
		
		// ��û ��ũ�� /community/list ���� ���ϴ� jsp�� community ������ �����Ƿ� ������ ����.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}


