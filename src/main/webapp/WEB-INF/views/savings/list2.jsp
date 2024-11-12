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

				<td>${product.korconm}</td>
				<td>${product.finprdtnm}</td>
				<td>${product.joinway}</td>
				<td><a href="${pageContext.request.contextPath}/savings/products_view?finprdtcd=${product.finprdtcd}">자세히 보기</a></td>

			</tr>
		</c:forEach>
	</table>

	<c:if test="${pageMaker.prev}">
		<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }"> << </a>
	</c:if>

	<c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
	</c:forEach>


	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<a href="list2${pageMaker.makeQuery(pageMaker.endPage + 1) }"> >> </a>
	</c:if>
</body>
</html>
