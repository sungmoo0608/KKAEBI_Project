<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 상세보기</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .star-rating {
            display: inline-block;
            font-size: 40px;
            color: #ccc;
        }
        .star-rating .selected {
            color: gold;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>리뷰 상세보기</h2>
        
        <!-- 리뷰 상세 정보 테이블 -->
        <table class="table">
            <tr>
                <th>상품 분류</th>
                <td>
                    <c:choose>
                        <c:when test="${review.bgroup == 1}">예금</c:when>
                        <c:when test="${review.bgroup == 2}">금융</c:when>
                        <c:when test="${review.bgroup == 3}">외환</c:when>
                        <c:when test="${review.bgroup == 4}">펀드</c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>상품 코드</th>
                <td>${review.goods_code}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${review.notice_title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${review.notice_content}</td>
            </tr>
            <tr>
                <th>상태</th>
                <td>
                    <c:choose>
                        <c:when test="${review.status == 1}">활성화=1</c:when>
                        <c:when test="${review.status == 9}">비활성화=9</c:when>
                        <c:otherwise>알 수 없음</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>등록일</th>
                <td>
                    <!-- 날짜 형식 변환 처리 -->
                    <fmt:parseDate var="parsedRegistDate" value="${review.regist_date}" pattern="yyyy-MM-dd" />
                    <fmt:formatDate value="${parsedRegistDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>해제일</th>
                <td>
                    <!-- 날짜 형식 변환 처리 -->
                    <fmt:parseDate var="parsedExpireDate" value="${review.expire_date}" pattern="yyyy-MM-dd" />
                    <fmt:formatDate value="${parsedExpireDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>등록자</th>
                <td>${review.regist_id}</td>
            </tr>
            <tr>
                <th>해제 등록자 ID </th>
                <td>${review.expire_id}</td>
            </tr>
            <tr>
                <th>최종 수정일자</th>
                <td>
                    <!-- 날짜 형식 변환 처리 -->
                    <fmt:parseDate var="parsedLastChgDate" value="${review.last_chg_date}" pattern="yyyy-MM-dd" />
                    <fmt:formatDate value="${parsedLastChgDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>별점</th>
                <td>
                    <div class="star-rating">
                        <c:forEach var="i" begin="1" end="5">
                            <span class="star <c:if test="${i <= review.star_rating}">selected</c:if>">&#9733;</span>
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </table>

        <!-- 목록으로 돌아가기 버튼 -->
        <div class="form-group text-center">
            <a href="${pageContext.request.contextPath}/review/list" class="btn btn-secondary">목록으로 돌아가기</a>
        </div>
    </div>
</body>
</html>
