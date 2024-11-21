<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 상세 정보</title>
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
			<h2>상세정보 조회</h2>
			<form action="${pageContext.request.contextPath}/goods/display" method="post" class="delete-button">
				<input type="hidden" name="goods_code" value="${goods.goods_code}"> 
				<span class="btn btn-outline-secondary btn-rounded btn-sm">${goods.goods_status == 1 ? '진열 상태' : (goods.goods_status == 9 ? '미진열 상태' : '알 수 없음')}</span>
				<input type="submit" value="판매 변경" class="btn btn-warning btn-rounded btn-sm" onclick="return confirm('판매 상태를 변경 하시겠습니까?');">
			</form>
		</div>

		<!-- 상세정보 테이블 -->
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th class="tour_code">상품 코드</th>
					<td>${goods.goods_code}</td>
					<th class="tour_name">상품 유형</th>
					<td>${goods.goods_gubun}</td>
				</tr>
				<tr>
					<th class="tour_address">상품명</th>
					<td>${goods.goods_name}</td>
					<th>상품고유코드</th>
					<td class="tour_telno">${goods.orign_code}</td>
				</tr>
				<tr>
					<th>예금기간</th>
					<td>${goods.period_mm}</td>
					<th class="custom-capacity-cell">펀드투자유형</th>
					<td>${goods.invest_gubun}</td>
				</tr>
				<tr>
					<th class="parking-cell">외환종류</th>
					<td>${goods.forignexg_kind}</td>
					<th>거래단위</th>
					<td>${goods.tran_unit}</td>
				</tr>


			</tbody>
		</table>


		<div class="text-center mt-3">
			<a class="btn btn-primary btn-rounded" href="${pageContext.request.contextPath}/goods/edit?goods_code=${goods.goods_code}">수정</a> 
			<a class="btn btn-secondary btn-rounded" href="${pageContext.request.contextPath}/goods/list">목록</a>

		</div>
		
	</div>
</body>
</html>
