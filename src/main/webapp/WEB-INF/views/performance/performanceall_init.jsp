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

tr, td {
	border-bottom: 1px solid #ffffff;
	border-left: 1px solid #ffffff;
	padding: 10px;
	background-color: #f4f4f4;
}

 thead {
        background-color: #e0f7ff; /* 헤더 부분 더 진한 파란색 */
    }
</style>


<script type="text/javascript">
	function formCheck() {

		var in_grade = document.getElementById('in_grade').value;

		console.log(in_grade)

		// 아무것도 선택안한 경우
		if (in_grade == "") {
			alert("조회하실 고객등급을 선택하세요");
			return false;
		}

		return true;
	}
</script>

<script type="text/javascript">
	function openMngDetail(marketCode) {
		// 새로운 창을 열어서 상세 페이지를 표시
		var url = "${pageContext.request.contextPath}/market/mngdetail?market_code="
				+ marketCode;
		window.open(url, '_blank', 'width=1000,height=700');
	}
</script>




<script type="text/javascript">
	function openMngCreate(marketCode) {
		// 새로운 창을 열어서 상세 페이지를 표시
		var url = "${pageContext.request.contextPath}/market/create";
		window.open(url, '_blank', 'width=800,height=800');
	}
</script>

<script type="text/javascript">
	function openMapWindow(marketCode) {
		var url = "${pageContext.request.contextPath}/market/marketmap?market_code="
				+ marketCode;
		window.open(url, '_blank', 'width=1000,height=700');

	}
</script>



</head>



<body>

	<header>
		<h1>도깨비은행 금융상품 종합쇼핑몰 [관리자용]</h1>
	</header>

	<form id="listForm"
		action="${pageContext.request.contextPath}/performance/performanceall_list"
		onsubmit="return formCheck()" method="get">
		<td>
			<div class="text-center">

				<span>고객등급</span> <select id="in_grade" name=in_grade>
					<option value="" selected disabled>등급 선택</option>
					<option value="9">전체등급</option>
					<option value="1">S등급(1000만원이상)</option>
					<option value="2">A등급(500만원이상)</option>
					<option value="3">B등급(300만원이상)</option>
					<option value="4">C등급(100만원이상)</option>
					<option value="5">일반등급</option>
				</select> <input type="submit" value="조회하기"> <input type="reset"
					value="지우기">

			</div>
		</td>
	</form>

	<section>
		<table border="1">
			<thead>
				<tr align="center">

					<td>고객코드</td>
					<td>고객성명</td>
					<td>생년월일</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>투자금액</td>
					<td>평가금액</td>
					<td>투자손익</td>
					<td>수익률(%)</td>
					<td>상세보기</td>
				</tr>
			</thead>

			<tbody id="result">
			</tbody>

		</table>
	</section>

	<footer> </footer>

</body>
</html>