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
    

<body>

<h2>[상품투자결과 - 펀드]</h2>

<input type="hidden" id = "goods_gubun" name="goods_gubun" value="${transaction.goods_gubun}"/>
<input type="hidden" id = "goods_code" name="goods_code" value="${transaction.goods_code}"/>

<label for="user_id">고객ID :</label>
<input type="text" id = "user_id" name="user_id" value="${transaction.user_id}" readonly style="background-color: #ffffe0;"/><br/>

<label for="name">고객성명 :</label>
<input type="text" name="name" value="${transaction.name}" readonly style="background-color: #ffffe0;" /><br/>

<label for="account_no">계좌번호 :</label>
<input type="text" id = "account_no" name="account_no" value="${transaction.account_no}" readonly style="background-color: #ffffe0;"/><br/>

<label for="tr_seqno">거래번호 :</label>
<input type="text" id = "tr_seqno" name="tr_seqno" value="${transaction.tr_seqno}" readonly style="background-color: #ffffe0;"/><br/>

<label for="goods_name">상품명 :</label>
<input type="text" name="goods_name" value="${transaction.goods_name}" readonly style="background-color: #ffffe0;"/><br/>

<label for="curprice">기준가 :</label>
<input type="text" id="curprice"  name="curprice"  value="${transaction.curprice}" readonly style="background-color: #ffffe0;"/>  원<br/>

<label for="tr_amt">투자금액 :</label>
<input type="text" id="tr_amt"  name="tr_amt"  value="${transaction.tr_amt}" readonly style="background-color: #ffffe0;"/>  원<br/>

<label for="tr_number">투자좌수 :</label>
<input type="text" name="tr_number"  value="${transaction.tr_number}"     readonly style="background-color: #ffffe0;"/>  좌<br/>


<button class="close-btn" onclick="window.close();">창닫기</button>
</form>
</body>
</html>
