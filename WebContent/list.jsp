<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�츮 ��ī��</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/booklist.css?v=3">
<!-- ������ -->

<!-- ����δ� ../css/community.css �Դϴ�. request��ü�� contextPath�� el�� ������ ������ ���� jsp ��ü pageContext �� ����ؾ� �մϴ�. -->

</head>

<body>

	<main id="list">
		<h3>���γ��� å</h3>
		<p>�� ���� ���� ���� å�� �Ұ��մϴ�.</p>
		<hr style="color: white;">
		<div style="width: 900px; margin: auto; overflow: hidden; border: 1px solid gray;">
			<c:forEach var="vo" items="${ProductVo }">
				<div class="gallery">
					<div>
						<a href=""> <img src="/����׽�Ʈ��/${photo }"
							alt="${vo.title }"> <!-- �̹����� ����� ������ ���Ͻý��� ��δ� url /upload �� ������ �ؾ��մϴ�.
					 server.xml ���� �Ϸ� ���ϴ�.
			<Context docBase="d:\iclass1020\upload" path="/upload" reloadable="true"/>
			</Host>�ٷ����� �ۼ��ϱ� 
				 -->
						</a>
					</div>
					<p>${vo.title }</p>
				</div>
			</c:forEach>
		</div>
		<div style="float: right; margin: 40px; padding-right: 100px;">
			<a href="new" class="button">����</a> <a
				href="${pageContext.request.contextPath}" class="button">Ȩ</a>
		</div>
	</main>
</body>
</html>
<!-- ������ textarea ���̺귯�� ���� : https://shxrecord.tistory.com/122 -->
<!-- 
			StringBuffer sb = new StringBuffer();
			//���� ���ε带 ������ �Ҷ��� �Ʒ��� �����մϴ�.
			@SuppressWarnings("unchecked")
			Enumeration<String> files = multi_request.getFileNames();	//file Ÿ�� ���ϸ� ��� ��������
			while(files.hasMoreElements()) {
				String f = files.nextElement();			
				String name= multi_request.getFilesystemName(f);		//���ε�� ���ϸ� ��������
				sb.append(name).append(",");		//���ϸ� �������� , ���� �����ؼ� �� �÷��� ����
			}
			//������� ���ε� ���ϰ��� ��ŭ �ݺ�����
			String title= multi_request.getParameter("title"); 
			vo = new NewBooks(0, title, summary, null, sb.toString(), "admin");
			adao.insert(vo);    //���ε��� ������ ���̺� �÷� ������ ����.
*���� : db ���� �������� ���� , ��ȣ�� �и��ؼ� List �Ǵ� �迭�� ��ȯ�Ͽ� ���
 -->

