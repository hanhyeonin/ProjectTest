<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�׽�Ʈ��</title>
</head>
<body>
<main id="list">
<table>
	<tbody>
		<c:forEach var="vo" items="${list }">
			<c:out value="${list.photofile }"/>
		</c:forEach>
	</tbody>
</table>
<div style="width:700px;margin: auto;padding: 10px;text-align: center;">
	��ü �� ���� : <c:out value="${paging.totalCount }"/> <br>
	<hr>
	<a class="pagenum" href="?page=1">&lt;&lt;</a>   <!--(1) ù��° ������ 1������ �̵� -->

	<!--(2) �� �κ��� ���� �����մϴ�. �����ϸ鼭 �ľ��غ�����. -->	<!-- ��û�� ListController�� ����. page�Ķ���� ����� -->
	<a class="pagenum" href="?page=${paging.startPage-1 }"      
			style='<c:if test="${paging.startPage==1 }">display:none;</c:if>' >&lt;</a>

	<!--(3) ������ ���� startPage ���� endPage ���� �ݺ� -->
	<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
		<a class="pagenum ieach" href="?page=${i }"><c:out value="${i }"/></a>
	</c:forEach>

	<!--(4) �� �κ��� ���� �����մϴ�. �����ϸ鼭 �ľ��غ�����. -->
	<a class="pagenum" href="?page=${paging.endPage+1 }"
			style='<c:if test="${paging.endPage==paging.totalPage }">display:none;</c:if>'	>&gt;</a>

	<a class="pagenum" href="?page=${paging.totalPage }">&gt;&gt;</a>  <!--(5) ���� ������ �������� �̵� -->
</div>
</main>
<script type="text/javascript">
	const pnums = document.querySelectorAll('.ieach');
	pnums.forEach(function(item){
		console.log(item);
		/* item ��ȣ�� ���� ������ �̸� �۲� ��Ÿ���� �ٸ�����. */
		if(item.innerHTML=='${paging.currentPage}') {    
			item.style.color = 'black';
			item.style.fontWeight = 'bold';
		}else{
			item.style.color = '#37966f';
		}
	});
</script>
</body>
</html>