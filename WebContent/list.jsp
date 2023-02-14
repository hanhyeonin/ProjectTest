<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소리스트</title>
<style type="text/css">
	div.gallery{
		width:320px;
		height: 250px;
		padding-left: 8%;
		align-items: left;
	}
	div.user-image a{
		width:310px;
		height: 230px;
		display: flex;
		background-size:320px; 250px;
		align-items: left;
	}
	div.user-image img{
		width:310px;
		height: 230px;
		background-size: 310px, 230px;
		display: flex;
		border-radius: 15%;
		text-align: center;
		position: relative;
	}
	div.user-text nth:nth-child(1) {
		position: absolute;
		color:white;
		transform : translate(-50%, -50%);
	}
	
</style>
</head>
<body> 

	<main id="list">
		<c:forEach var="vo" items="${lists }">
			<div class="gallery">
				<div class="user-image">
					<a href=""><img src="/upload/${vo.photofile[0]}" alt=""></a>
					<div class="user-text"><span>${vo.pname }</span></div>
				</div>
			</div>
		</c:forEach>
		<div
			style="width: 700px; margin: auto; padding: 10px; text-align: center;">
			전체 글 개수 :
			<c:out value="${paging.totalCount }" />
			<br>
			<hr>
			<a class="pagenum" href="?page=1">&lt;&lt;</a>
			<!--(1) 첫번째 페이지 1번으로 이동 -->
			<!--(2) 이 부분이 제일 복잡합니다. 실행하면서 파악해보세요. -->
			<!-- 요청은 ListController가 받음. page파라미터 변경됨 -->
			<a class="pagenum" href="?page=${paging.startPage-1 }"
				style='<c:if test="${paging.startPage==1 }">display:none;</c:if>'>&lt;</a>
			<!--(3) 페이지 범위 startPage 부터 endPage 까지 반복 -->
			<c:forEach var="i" begin="${paging.startPage }"
				end="${paging.endPage }">
				<a class="pagenum ieach" href="?page=${i }"><c:out value="${i }" /></a>
			</c:forEach>
			<!--(4) 이 부분이 제일 복잡합니다. 실행하면서 파악해보세요. -->
			<a class="pagenum" href="?page=${paging.endPage+1 }"
				style='<c:if test="${paging.endPage==paging.totalPage }">display:none;</c:if>'>&gt;</a>
			<a class="pagenum" href="?page=${paging.totalPage }">&gt;&gt;</a>
			<!--(5) 가장 마지막 페이지로 이동 -->
		</div>
	</main>
	<script type="text/javascript">
		const pnums = document.querySelectorAll('.ieach');
		pnums.forEach(function(item) {
			console.log(item);
			/* item 번호가 현재 페이지 이면 글꼴 스타일을 다르게함. */
			if (item.innerHTML == '${paging.currentPage}') {
				item.style.color = 'black';
				item.style.fontWeight = 'bold';
			} else {
				item.style.color = '#37966f';
			}
		});
	</script>
</body>
</html>
<!-- 위지윅 textarea 라이브러리 참고 : https://shxrecord.tistory.com/122 -->
<!-- 
			StringBuffer sb = new StringBuffer();
			//파일 업로드를 여러개 할때는 아래와 같이합니다.
			@SuppressWarnings("unchecked")
			Enumeration<String> files = multi_request.getFileNames();	//file 타입 파일명 모두 가져오기
			while(files.hasMoreElements()) {
				String f = files.nextElement();			
				String name= multi_request.getFilesystemName(f);		//업로드된 파일명 가져오기
				sb.append(name).append(",");		//파일명 여러개를 , 으로 구분해서 한 컬럼에 저장
			}
			//여기까지 업로드 파일개수 만큼 반복실행
			String title= multi_request.getParameter("title"); 
			vo = new NewBooks(0, title, summary, null, sb.toString(), "admin");
			adao.insert(vo);    //업로드한 파일을 테이블 컬럼 값으로 저장.
*참고 : db 에서 가져왔을 때는 , 기호로 분리해서 List 또는 배열로 변환하여 사용
 -->