<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관광지 등록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.form-container {
	width: 60%;
	padding: 20px;
	border-radius: 10px; /* 모서리 둥글게 */
	border: 1px solid #ddd; /* 테두리 */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

.code-cell {
	width: 80px; /* 코드 셀의 너비를 줄임 */
}

.name-cell {
	width: 150px; /* 관광지명 셀의 너비를 줄임 */
}

/* 버튼 둥글게 만들기 */
.btn-rounded {
	border-radius: 25px; /* 버튼 둥글게 */
}
</style>
</head>
<body>
	<div class="container d-flex align-items-center justify-content-center" style="height: 100vh;">
		<div class="form-container">
			<h2 class="text-center">등록</h2>
			<form action="${pageContext.request.contextPath}/goods/create" method="post">
				<div class="form-group">
					<label for="goods_code">상품 코드:</label> <input type="number" class="form-control" id="goods_code" name="goods_code" required />
				</div>
				<div class="form-group">
					<label for="goods_gubun">상품 유형:</label> <input type="number" class="form-control" id="goods_gubun" name="goods_gubun" required />
				</div>
				<div class="form-group">
					<label for="provider_code">상품공급자코드:</label><input type="number" class="form-control" id="provider_code" name="provider_code" required>
				</div>
				<div class="form-group">
					<label for="goods_name">상품명:</label> <input type="text" class="form-control" id="goods_name" name="goods_name" required />
				</div>
				<div class="form-group">
					<label for="orign_code">상품고유코드:</label> <input type="text" class="form-control" id="orign_code" name="orign_code" required />
				</div>
				<div class="form-group">
					<label for="period_mm">예금기간:</label> <input type="number" class="form-control" id="period_mm" name="period_mm" required />
				</div>
				<div class="form-group">
					<label for="invest_gubun">펀드투자유형:</label> <input type="number" class="form-control" id="invest_gubun" name="invest_gubun" required />
				</div>
				<div class="form-group">
					<label for="forignexg_kind">외환종류:</label> <input type="number" class="form-control" id="forignexg_kind" name="forignexg_kind" required />
				</div>
				<div class="form-group">
					<label for="tran_unit">거래단위:</label> <input type="number" class="form-control" id="tran_unit" name="tran_unit" required />
				</div>
				<div class="form-group">
					<label for="goods_status">상품상태:</label> <input type="number" class="form-control" id="goods_status" name="goods_status" required />
				</div>
				<div class="text-center">
					<input type="submit" class="btn btn-success btn-rounded" value="등록"> 
					<a href="${pageContext.request.contextPath}/goods/list" class="btn btn-secondary btn-rounded ml-2">목록</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
