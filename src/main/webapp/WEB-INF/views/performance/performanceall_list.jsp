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
    function openMngDetail(user_id) {
        // 새로운 창을 열어서 상세 페이지를 표시
        var url = "${pageContext.request.contextPath}/performance/customer?user_id=" + user_id;
        window.open(url, '_blank', 'width=1200,height=700');
    }
</script>

<script type="text/javascript">
    function openBasketList(user_id) {
        // 새로운 창을 열어서 상세 페이지를 표시
        var url = "${pageContext.request.contextPath}/basketlist/basketlist?user_id=" + user_id;
        window.open(url, '_blank', 'width=1200,height=700');
    }
</script>


</head>



<body>
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

<h3>  고객별 투자현황 </h3>

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
					<td>장바구니보기</td>
				</tr>
			</thead>

			<c:forEach var="performanceall" items="${PerformanceAllList}">
				<tr>
					<td align="center">${performanceall.user_id}</td>
					<td align="center">${performanceall.name}</td>
					<td align="center">${performanceall.birthday}</td>
					<td align="center">${performanceall.create_date}</td>
					<td align="center">${performanceall.grade}</td>
					<td align="center">${performanceall.trkwa_amt}</td>
					<td align="center">${performanceall.val_amt}</td>
					<td align="center">${performanceall.sonik_amt}</td>
					<td align="center">${performanceall.suik_rate}</td>
					<td align="center"><button
							onclick="openMngDetail('${performanceall.user_id}')">
							상세보기</a>
						</button></td>
					<td align="center"><button
							onclick="openBasketList('${performanceall.user_id}')">
							장바구니</a>
						</button></td>




				</tr>
			</c:forEach>


			<tbody id="result">
			</tbody>

		</table>
	</section>

	<footer> </footer>

</body>
</html>