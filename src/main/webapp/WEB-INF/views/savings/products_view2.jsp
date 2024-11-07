<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
   <h1>글보기</h1>
   
	<table width="860" border="1">
      <form action="${pageContext.request.contextPath}/board/modify" method="post">
          <tr>
            <td>상품명</td>
            <td>${savingProductOptionMap.savingProduct.fin_prdt_nm}</td>      
         </tr>
<%--           <tr>
            <td>가입 방법</td>
            <td>${products_view.savingProduct.join_way}</td>      
         </tr>
         <tr>
            <td>만기 후 이자율</td>
            <td>${products_view.savingProduct.mtrt_int}</td>      
         </tr>
         <tr>
            <td>우대조건</td>
            <td>${products_view.savingProduct.spcl_cnd}</td>      
         </tr>  
         <tr>
            <td>저축 기간</td>
            <td>${products_view.savingProductRates.save_trm}</td>      
         </tr>
         <tr>
            <td>이자율</td>
            <td>${products_view.savingProductRates.intr_rate}</td>
         </tr>
         <tr>
            <td>우대 이자율</td>
            <td>${products_view.savingProductRates.intr_rate2}</td>
         </tr> --%>
         <tr>
            <td colspan="2"><input type="submit" value="수정">
               &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/savings/list">목록보기</a>                
            </td>
         </tr>
      </form>
   </table>
   
   
  
</body>
</html>