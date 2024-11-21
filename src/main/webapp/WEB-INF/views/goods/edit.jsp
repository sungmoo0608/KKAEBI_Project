<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.form-container {
	width: 60%;
	padding: 20px;
	border-radius: 10px; /* 모서리 둥글게 */
	border: 1px solid #ddd; /* 테두리 */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
	margin: 0 auto; /* 중앙 정렬 */
}

.btn-rounded {
	border-radius: 25px; /* 버튼 둥글게 */
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">수정</h2>
		<form action="${pageContext.request.contextPath}/goods/modify" method="post" class="mt-4 form-container">
			<input type="hidden" name="goods_code" value="${goods.goods_code}" />
			<div class="form-group">
				<label for="goods_code">상품 코드:</label> <input type="number" class="form-control" id="goods_code" name="goods_code" value="${goods.goods_code}" required />
			</div>
			<div class="form-group">
				<label for="goods_gubun">상품 유형:</label> <input type="number" class="form-control" id="goods_gubun" name="goods_gubun" value="${goods.goods_gubun}" required />
			</div>
			<div class="form-group">
				<label for="provider_code">상품공급자코드:</label><input type="number" class="form-control" id="provider_code" name="provider_code" value="${goods.provider_code}" required>
			</div>
			<div class="form-group">
				<label for="goods_name">상품명:</label> <input type="text" class="form-control" id="goods_name" name="goods_name" value="${goods.goods_name}" required />
			</div>
			<div class="form-group">
				<label for="orign_code">상품고유코드:</label> <input type="text" class="form-control" id="orign_code" name="orign_code" value="${goods.orign_code}" required />
			</div>
			<div class="form-group">
				<label for="period_mm">예금기간:</label> <input type="number" class="form-control" id="period_mm" name="period_mm" value="${goods.period_mm}" required />
			</div>
			<div class="form-group">
				<label for="invest_gubun">펀드투자유형:</label> <input type="number" class="form-control" id="invest_gubun" name="invest_gubun" value="${goods.invest_gubun}" required />
			</div>
			<div class="form-group">
				<label for="forignexg_kind">외환종류:</label> <input type="number" class="form-control" id="forignexg_kind" name="forignexg_kind" value="${goods.forignexg_kind}" required />
			</div>
			<div class="form-group">
				<label for="tran_unit">거래단위:</label> <input type="number" class="form-control" id="tran_unit" name="tran_unit" value="${goods.tran_unit}" required />
			</div>
			<div class="form-group">
				<label for="goods_status">상품상태:</label> <input type="number" class="form-control" id="goods_status" name="goods_status" value="${goods.goods_status}" required />
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary btn-rounded">수정</button>
				<a href="${pageContext.request.contextPath}/goods/list" class="btn btn-secondary btn-rounded">목록</a>
			</div>
		</form>
	</div>
</body>
</html>
