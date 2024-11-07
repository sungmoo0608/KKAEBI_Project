<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>예금 상품</title>
</head>
<body>
	<h1>예금 상품 목록</h1>
	<table border="1">
		<tr>
			<td>금융 회사명</td>
			<td>금융 상품명</td>
			<td>가입 방법</td>
			<td>상품 보기</td>
		</tr>
		<c:forEach var="product" items="${getSavingProductList}">
		<tr>
		
			<td>${product.kor_co_nm}</td>
			<td>${product.fin_prdt_nm}</td>
			<td>${product.join_way}</td>
			<td><a href="${pageContext.request.contextPath}/savings/products_view?fin_prdt_cd=${product.fin_prdt_cd}">자세히 보기</a></td>

		</tr>
		</c:forEach>
	</table>
</body>
</html>
