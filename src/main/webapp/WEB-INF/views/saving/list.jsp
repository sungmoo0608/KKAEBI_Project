<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>적금 상품</title>
</head>
<body>
	<h1>적금 상품 목록</h1>
	<table border="1">
		<tr>
<!-- 			<td>금융 회사 코드</td>
			<td>금융 상품 코드</td> -->
			<td>금융 회사명</td>
			<td>금융 상품명</td>
			<td>가입 방법</td>
			<td>적립 유형명</td>
			<td>저축 기간</td>
			<td>저축 금리</td>	
			
<!-- 			<td>우대 조건</td>
			<td>가입 제한</td>
			<td>가입 대상</td>
			<td>기타 유의 사항</td>
			<td>최고 한도</td> -->
		</tr>
		<c:forEach var="product" items="${getFinProductOption}">
		<tr>
<%-- 			<td>${product.fin_co_no}</td>
			<td>${product.fin_prdt_cd}</td> --%>
			<td>${product.finProduct.kor_co_nm}</td>
			<td>${product.finProduct.fin_prdt_nm}</td>
			<td>${product.finProduct.join_way}</td>
			<td>${product.option.rsrv_type_nm}</td>
			<td>${product.option.save_trm}</td>
			<td>${product.option.intr_rate}</td>
<%-- 			<td>${product.spcl_cnd}</td>
			<td>${product.join_deny}</td>
			<td>${product.join_member}</td>
			<td>${product.etc_note}</td>
			<td>${product.max_limit}</td> --%>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
