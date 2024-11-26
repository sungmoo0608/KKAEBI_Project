<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.ict.ex.performance.vo.PerformanceAllVO"%>
<%@ page import="edu.ict.ex.performance.vo.PerformanceCustomerDetailVO"%>
<%@ page import="edu.ict.ex.performance.vo.PerformanceCustomerSummaryVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style type="text/css">
header {
	background-color: steelblue;
	color: white;
	text-align: center;
	height: 50px;
	line-height: 70px;
}

section {
	magin: 0;
	background-color: #d3d3d3;
	color: black;
	min-height: 100px;
}

footer {
	background-color: black;
	color: white;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 10px;
}

a:link, a:visited {
	color: white;
	text-decoration: none;
}

button {
	background-color: steelblue;
	color: white;
	width: 90px;
	display: block;
	margin: auto;
	font-size: 12px;
}

table {
	width: 100%;
	max-width: 1300px;
	height: 50px;
	border: 1px solid #dfdfdf;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
	border-radius: 5px;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
}
 thead {
        background-color: #007bff; /* 헤더 부분 더 진한 파란색 */
    }

tr, td {
	border-bottom: 1px solid #ffffff;
	border-left: 1px solid #ffffff;
	padding: 10px;
	background-color: #f4f4f4;
}
 h3 {
        text-align: center; /* 텍스트를 가운데 정렬 */
        background-color: #f0f8ff; /* 옅은 파란색 배경 */
        color: #007bff; /* 텍스트 색상을 진한 파란색으로 설정 */
        padding: 15px; /* 안쪽 여백 추가 */
        border: 2px solid #007bff; /* 테두리를 진한 파란색으로 설정 */
        border-radius: 10px; /* 둥근 테두리 */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 그림자 효과 */
        font-family: 'Arial', sans-serif; /* 폰트를 깔끔한 스타일로 설정 */
        font-size: 1.2em; /* 글자 크기를 적절히 키움 */
        margin: 15px auto; /* 위아래 여백 추가 및 중앙 정렬 */
        max-width: 600px; /* 너비 제한 설정 */
    }    
</style>

<script type="text/javascript">

	function formCheck() {

		var grade = document.getElementById('grade').value;
        if (grade === "") {
            alert("고객등급을 선택하고 조회하세요");
            return false;
        }
        return true;
	}	
	
	
</script>

<script type="text/javascript">
    function openGoodsGubunDetail(user_id,goods_gubun) {
        // 새로운 창을 열어서 상세 페이지를 표시
        var url = "${pageContext.request.contextPath}/performance/customerdetail?user_id=" + user_id + "&goods_gubun=" + goods_gubun;
        window.open(url, '_blank', 'width=1200,height=720');
    }
</script>



</head>



<body>

<h3>  상품유형별 투자현황 </h3>

	<section>
		<table border="1">
			<thead>
				<tr align="center">

					<td>상품유형</td>
					<td>투자건수</td>
					<td>투자금액</td>
					<td>평가금액</td>
					<td>투자손익</td>
					<td>수익률(%)</td>
					<td>상세보기</td>
				</tr>
			</thead>

			<c:forEach var="performancecustomer_summary" items="${PerformanceCustomerSummaryList}">
				<tr>
   					<input type="hidden" class="user_id" 	value="${'${performancecustomer_summary.user_id}'}">
   					<input type="hidden" class="goods_gubun" 	value="${'${performancecustomer_summary.goods_gubun}'}">
					<td align="center">${performancecustomer_summary.goods_gubun_nm}</td>
					<td align="center">${performancecustomer_summary.cnt}</td>
					<td align="center">${performancecustomer_summary.trkwa_amt}</td>
					<td align="center">${performancecustomer_summary.val_amt}</td>
					<td align="center">${performancecustomer_summary.sonik_amt}</td>
					<td align="center">${performancecustomer_summary.suik_rate}</td>
					<td align="center"><button
							onclick="openGoodsGubunDetail('${performancecustomer_summary.user_id}','${performancecustomer_summary.goods_gubun}')">
							상세보기</a>
						</button></td>
				</tr>
			</c:forEach>

			<tbody id="result">
			</tbody>

		</table>

<h3>  상품별 투자 상세현황 </h3>

	<section>
		<table border="1">
			<thead>
				<tr align="center">

					<td>상품유형</td>
					<td>상품명</td>
					<td>투자기간</td>
					<td>이율</td>
					<td>투자일자</td>
					<td>만기일자</td>
					<td>투자금액</td>
					<td>상품수량</td>
					<td>평가금액</td>
					<td>투자손익</td>
					<td>수익률(%)</td>
				</tr>
			</thead>

			<c:forEach var="performancecustomer_detail" items="${PerformanceCustomerDetailList}">
				<tr>
   					<input type="hidden" class="user_id" 	value="${'${performancecustomer_detail.user_id}'}">
   					<input type="hidden" class="goods_gubun" 	value="${'${performancecustomer_detail.goods_gubun}'}">
   					<input type="hidden" class="goods_code" 	value="${'${performancecustomer_detail.goods_code}'}">
					<td align="center">${performancecustomer_detail.goods_gubun_nm}</td>
					<td align="center">${performancecustomer_detail.goods_name}</td>
					<td align="center">${performancecustomer_detail.period_mm}</td>
					<td align="center">${performancecustomer_detail.iyul}</td>
					<td align="center">${performancecustomer_detail.tr_date}</td>
					<td align="center">${performancecustomer_detail.mangi_date}</td>
					<td align="center">${performancecustomer_detail.trkwa_amt}</td>
					<td align="center">${performancecustomer_detail.goods_number}</td>
					<td align="center">${performancecustomer_detail.val_amt}</td>
					<td align="center">${performancecustomer_detail.sonik_amt}</td>
					<td align="center">${performancecustomer_detail.suik_rate}</td>
				</tr>
			</c:forEach>

			<tbody id="result">
			</tbody>

		</table>


	</section>




	<footer> </footer>

</body>
</html>