<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Goods List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa; /* 배경색 추가 */
}

.container {
	width: 80%; /* 컨테이너 너비 설정 */
	margin: 0 auto; /* 중앙 정렬 */
	background: white; /* 배경 흰색 */
	padding: 20px; /* 내부 여백 */
	border-radius: 10px; /* 모서리 둥글게 */
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 그림자 추가 */
}

.container1 {
	width: 80%; /* 컨테이너 너비 설정 */
	margin: 0 auto; /* 중앙 정렬 */
	padding: 20px; /* 내부 여백 */
}

.header {
	display: flex;
	justify-content: space-between; /* 제목과 삭제 버튼 사이 간격 조정 */
	align-items: center; /* 세로 가운데 정렬 */
	margin-bottom: 20px;
}

table {
	width: 100%; /* 테이블 너비 조절 */
	margin: 0 auto; /* 가운데 정렬 */
	border-collapse: separate; /* 셀 간격을 두고 테이블을 둥글게 만듦 */
	border-radius: 10px; /* 테이블의 모서리 둥글게 */
	overflow: hidden; /* 둥근 모서리가 셀에 영향을 주도록 처리 */
}

th, td {
	padding: 10px; /* 셀 패딩 */
	font-size: 14px; /* 글자 크기 */
	border: 1px solid #dee2e6; /* 얇은 테두리 */
}

#map {
	width: 100%;
	height: 350px; /* 지도 높이 */
	margin-top: 20px;
	border-radius: 10px; /* 지도의 모서리 둥글게 */
	border: 2px solid #ddd; /* 지도 테두리 */
}

.btn-rounded {
	border-radius: 25px; /* 버튼 둥글게 */
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="header">
			<h1>펀드 상품 목록</h1>
		</div>
		<div class="container1">
			<a class="btn btn-outline-primary btn-rounded btn-sm mx-1" href="${pageContext.request.contextPath}/goods/list">모든 상품</a> <a class="btn btn-outline-primary btn-rounded btn-sm mx-1" href="${pageContext.request.contextPath}/goods/Depositlist">예금 상품</a> <a class="btn btn-outline-primary btn-rounded btn-sm mx-1" href="${pageContext.request.contextPath}/goods/Fundlist">펀드 상품</a> <a class="btn btn-outline-primary btn-rounded btn-sm mx-1" href="${pageContext.request.contextPath}/goods/Exchangelist">외환 상품</a> <a class="btn btn-outline-primary btn-rounded btn-sm mx-1" href="${pageContext.request.contextPath}/goods/Stocklist">주식 상품</a>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>상품코드</th>
					<th>상품명</th>
					<th>상품제공기관</th>
					<th>펀드유형</th>
					<th>금일기준가</th>
					<th>최근3일수익률</th>
					<th>자세히보기</th>
					<th>투자하기</th>
				</tr>
			</thead>
			<tbody>
				<!-- Loop through the list of goodsVO and display each property -->
				<c:forEach var="goods" items="${goodsList}">
					<tr>
						<td>${goods.goods.goods_code}</td>
						<td>${goods.goods.goods_name}</td>
						<td>${goods.provider.provider_name}</td>
						<td><c:choose>
								<c:when test="${goods.goods.invest_gubun == 1}">주식형</c:when>
								<c:when test="${goods.goods.invest_gubun == 2}">채권형</c:when>
								<c:when test="${goods.goods.invest_gubun == 3}">혼합형</c:when>
								<c:otherwise>알 수 없음</c:otherwise>
							</c:choose></td>
						<td>${goods.baseprice.trbase_price}</td>
						<td>임의값</td>
						<td><a class="btn btn-primary btn-rounded btn-sm" href="${pageContext.request.contextPath}/goods/goods_view?goods_code=${goods.goods.goods_code}">보기</a></td>
						<td><a class="btn btn-secondary btn-rounded btn-sm" href="#">투자하기</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10"><a class="btn btn-secondary btn-rounded" href="${pageContext.request.contextPath}/goods/create_view">입력</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
