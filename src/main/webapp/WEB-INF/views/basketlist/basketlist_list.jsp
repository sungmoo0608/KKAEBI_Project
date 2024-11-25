<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="edu.ict.ex.basketlist.vo.BasketlistVO"%>
<%@ page import="edu.ict.ex.basketlist.vo.BasketlistDetailVO"%>
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
        var url = "${pageContext.request.contextPath}/basketlist/basketlistdetail?user_id=" + user_id + "&goods_gubun=" + goods_gubun;
        window.open(url, '_blank', 'width=1200,height=720');
    }
</script>
<script type="text/javascript">
    function BasketlistDeleteandReview(user_id,seq_no) {
        // 새로운 창을 열어서 상세 페이지를 표시
        var url = "${pageContext.request.contextPath}/basketlist/basketlistdelete?user_id=" + user_id + "&seq_no=" + seq_no;
        window.close();
        window.open(url, '_blank', 'width=1200,height=720');
    }
</script>

<script type="text/javascript">
    function openGoodsDetail(user_id,goods_code) {
        // 새로운 창을 열어서 상품상세정보를 조회
        var url = "${pageContext.request.contextPath}/basketlist/basketlistdetail?user_id=" + user_id + "&goods_gubun=" + goods_code;
        window.open(url, '_blank', 'width=1200,height=720');
    }
</script>


<script type="text/javascript">
    function openGoodsInvestInit(user_id,goods_gubun,goods_code) {
        // 새로운 창을 열어서 상세 페이지를 표시
        var url = "${pageContext.request.contextPath}/transaction/invest_init?user_id=" + user_id + "&goods_gubun=" + goods_gubun + "&goods_code=" + goods_code ;
        window.open(url, '_blank', 'width=1200,height=720');
    }
</script>

</head>

 

<body>

<h3>  상품유형별 장바구니현황 </h3>

	<section>
		<table border="1">
			<thead>
				<tr align="center">a

					<td>상품유형</td>
					<td>등록건수</td>
					<td>상세보기</td>
				</tr>
			</thead>

			<c:forEach var="basketlist_summary" items="${BasketlistSummaryList}">
				<tr>
   					<input type="hidden" class="user_id" 	value="${'${basketlist_summary.user_id}'}">
   					<input type="hidden" class="goods_gubun" 	value="${'${basketlist_summary.goods_gubun}'}">
					<td align="center">${basketlist_summary.goods_gubun_nm}</td>
					<td align="center">${basketlist_summary.cnt}</td>
					<td align="center"><button
							onclick="openGoodsGubunDetail('${basketlist_summary.user_id}','${basketlist_summary.goods_gubun}')">
							상세보기</a>
						</button></td>
				</tr>
			</c:forEach>

			<tbody id="result">
			</tbody>

		</table>

<h3>  상품별 장바구니 상세현황 </h3>

	<section>
		<table border="1">
			<thead>
				<tr align="center">

					<td>상품유형</td>
					<td>상품명</td>
					<td>예금기간</td>
					<td>예금만기일</td>
					<td>예금금리</td>
					<td>펀드기준가</td>
					<td>외화 환율</td>
					<td>주식 주가</td>
					<td>상품상세</td>
					<td>장바구니</td>
					<td>상품투자</td>
				</tr>
			</thead>

			<c:forEach var="basketlist_detail" items="${BasketlistDetailList}">
				<tr>
   					<input type="hidden" class="user_id" 	value="${'${basketlist_detail.user_id}'}">
   					<input type="hidden" class="name" 		value="${'${basketlist_detail.name}'}">
   					<input type="hidden" class="seq_no" 		value="${'${basketlist_detail.seq_no}'}">
   					<input type="hidden" class="goods_gubun" 	value="${'${basketlist_detail.goods_gubun}'}">
   					<input type="hidden" class="goods_code" 	value="${'${basketlist_detail.goods_code}'}">
					<td align="center">${basketlist_detail.goods_gubun_nm}</td>
					<td align="center">${basketlist_detail.goods_name}</td>
					<td align="center">${basketlist_detail.period_mm}</td>
					<td align="center">${basketlist_detail.mangi_date}</td>
					<td align="center">${basketlist_detail.iyul}</td>
					<td align="center">${basketlist_detail.baseprice}</td>
					<td align="center">${basketlist_detail.exchangeprice}</td>
					<td align="center">${basketlist_detail.stockprice}</td>
					<td align="center"><button
							onclick="openGoodsDetail('${basketlist_detail.user_id}','${basketlist_detail.goods_code}')">
							상세보기</a>
						</button></td>
					<td align="center"><button
							onclick="BasketlistDeleteandReview('${basketlist_detail.user_id}','${basketlist_detail.seq_no}')">
							삭제하기</a>
						</button></td>
					<td align="center"><button
							onclick="openGoodsInvestInit('${basketlist_detail.user_id}','${basketlist_detail.goods_gubun}','${basketlist_detail.goods_code}')">
							투자하기</a>
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