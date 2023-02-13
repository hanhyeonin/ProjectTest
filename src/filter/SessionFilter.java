package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import vo.NewMemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebFilter(servletNames = {"FrontController"})
public class SessionFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		List<String> nosessions  = List.of("/member/join", "/login", "/test");
		List<String> logins = List.of("/community/update", "/community/delete", "/community/comments", "/community/write");
		//List.of �޼ҵ�� java 9 ���� ����մϴ�. �Һ��÷���(�߰�/ ���� ���ϴ� ����Ʈ) ����
		
		//request������ response�� HttpServletRequest�� ��ȯ�� ��������
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		//��û���� servletPath�� ���
		logger.info("::::::::��û �� SessionFilter: {} ::::::::::", httpRequest.getServletPath());
		//���� request�������� session�� �����´�
		HttpSession session = httpRequest.getSession();
		//������ ���ǿ� user��� ���� �����´� (�α��� ������ vo��ü�� user��� �̸����� ��Ҵ�)
		//NewMember user = (NewMember)session.getAttribute("user");
		//�������� (List<String>)nosession���� ��û���� servletPath(/������Ʈ���/�Ʒ�)�� ���ԵǾ� �ְ� �׸��� user�� null�� �ƴϸ� ��
		//�Ǵ� (List<String>)logins���� contextPath(/������Ʈ���/)�� ���ԵǾ��ְ� �׸��� user �� null�̸� ��
//		if(nosessions.contains(httpRequest.getServletPath()) && user != null || logins.contains(httpRequest.getServletPath()) && user == null) {
//			httpResponse.sendRedirect(httpRequest.getContextPath());
//			return;	//���� ���� �������� �ʵ��� ����
//		}
		chain.doFilter(httpRequest, httpResponse);
		logger.info("::::::::::::::: ��û �� SessionFilter: {} ::::::::::::::", httpRequest.getServletPath());
	}
	
}