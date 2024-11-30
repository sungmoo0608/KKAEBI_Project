<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>투자 - 펀드</title>
<style>
 h2 {
        background-color: lightblue; /* 옅은 청색 배경 */
        text-align: center; /* 중앙 정렬 */
        padding: 10px; /* 상하 여백 */
        margin: 0 0 20px 0; /* 하단 여백 추가 */
        border-radius: 5px; /* 모서리를 둥글게 */
    }
    </style>
    
<script>
        function calculateNumber() {
            // 입력된 투자 금액과 금리를 가져오기
            const curPrice = document.getElementById("curprice").value;
            const investAmt = document.getElementById("invest_amt").value;

            // 값이 올바른지 확인
            if (!investAmt || isNaN(investAmt) || investAmt <= 0) {
                alert("유효한 투자 금액을 입력해주세요.");
                return;
            }
            let tr_number = 0; // 주식수 변수 초기화
            tr_number = Math.floor(parseFloat(investAmt) / parseFloat(curPrice) );
			const lastinvestAmt = Math.ceil(parseFloat(tr_number) * parseFloat(curPrice) ); 
            
            // 결과 표시
    		document.querySelector("input[name='tr_number']").value = tr_number.toFixed(0); // 소수점 없는 정수로 표시
    		document.querySelector("input[name='invest_amt']").value = lastinvestAmt.toFixed(0); // 소수점 없는 정수로 표시
        }
    </script>    
</head>

<script>
        function execGoodsInvest() {
            // 새로운 창을 열어서 상세 페이지를 표시
            var url = "${pageContext.request.contextPath}/transaction/invest?user_id=" + document.getElementById("user_id").value 
            		+ "&goods_gubun=" + document.getElementById("goods_gubun").value 
            		+ "&goods_code=" + document.getElementById("goods_code").value 
            		+ "&tr_number=" + document.getElementById("tr_number").value 
            		+ "&tr_price=" + document.getElementById("curprice").value 
            		+ "&tr_amt=" + document.getElementById("invest_amt").value  ;
            window.open(url, '_blank', 'width=1200,height=720');

        }
     	
        	
        	
</script>    


<body>

<h2>[상품투자 - 펀드]</h2>

<form action="${pageContext.request.contextPath}/transaction/investfund" method="post">

<input type="hidden" id = "goods_gubun" name="goods_gubun" value="${transaction.goods_gubun}"/>
<input type="hidden" id = "goods_code" name="goods_code" value="${transaction.goods_code}"/>

<label for="user_id">고객ID :</label>
<input type="text" id = "user_id" name="user_id" value="${transaction.user_id}" readonly style="background-color: #ffffe0;"/><br/>

<label for="name">고객성명 :</label>
<input type="text" name="name" value="${transaction.name}" readonly style="background-color: #ffffe0;" /><br/>

<label for="goods_name">종목명 :</label>
<input type="text" name="goods_name" value="${transaction.goods_name}" readonly style="background-color: #ffffe0;"/><br/>

<label for="curprice">기준가 :</label>
<input type="text" id="curprice"  name="curprice"  value="${transaction.curprice}" readonly style="background-color: #ffffe0;"/>  원<br/>

<label for="invest_amt">투자금액 :</label>
<input type="text" id="invest_amt"    name="invest_amt" />  원
<button type="button" onclick="calculateNumber()">매수좌수 계산하기</button><br/>

<label for="tr_number">매수주식수 :</label>
<input type="text"  id="tr_number"   name="tr_number" readonly style="background-color: #ffffe0;"/>  주<br/>


<button type="button" 	onclick="execGoodsInvest()"> 투자하기</button><br/>

<button class="close-btn" onclick="window.close();">창닫기</button>
</form>
</body>
</html>
