package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(servletNames = { "FrontController" })
public class SetEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//doFilter �޼ҵ��� ���� request�� Ÿ���� HttpServletRequest(�������̽�) �� �ƴմϴ�
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		httpRequest.setCharacterEncoding("UTF-8");
		chain.doFilter(httpRequest, response);	//���ͺz ü������ ������ �� �����Ƿ� ���� ���� ����
	}
	//�� ���ʹ� ��� ��û�� ���� �������ڵ��� UTF-8�� �մϴ�. ���� ��������
	//httpRequest.setCharacterEncoding("UTF-8"); �ڵ��� �ۼ� ���ص� �˴ϴ�.
}