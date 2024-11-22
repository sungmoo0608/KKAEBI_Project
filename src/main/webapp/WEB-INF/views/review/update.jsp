<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%
    // 현재 날짜를 "yyyy-MM-dd" 형식으로 가져오기
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new Date()); // 현재 날짜
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 수정</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .star-rating {
            display: inline-block;
            font-size: 40px;
            color: #ccc;
        }
        .star-rating span {
            cursor: pointer;
        }
        .star-rating .selected {
            color: gold;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>리뷰 수정</h2>
        <form action="${pageContext.request.contextPath}/review/update" method="post">
            
            <!-- 상품 분류 및 상품 코드 -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="bgroup">상품 분류</label>
                    <select class="form-control" id="bgroup" name="bgroup" required>
                        <option value="1" <c:if test="${review.bgroup == 1}">selected</c:if>>예금</option>
                        <option value="2" <c:if test="${review.bgroup == 2}">selected</c:if>>금융</option>
                        <option value="3" <c:if test="${review.bgroup == 3}">selected</c:if>>외환</option>
                        <option value="4" <c:if test="${review.bgroup == 4}">selected</c:if>>펀드</option>
                    </select>
                </div>
                <div class="col">
                    <label for="goods_code">상품 코드</label>
                    <input type="text" class="form-control" id="goods_code" name="goods_code" value="${review.goods_code}" placeholder="상품 코드를 입력하세요" required>
                </div>
            </div>

            <!-- 리뷰 제목 -->
            <div class="form-group">
                <label for="notice_title">제목</label>
                <input type="text" class="form-control" id="notice_title" name="notice_title" value="${review.notice_title}" placeholder="제목을 입력하세요" required>
            </div>

            <!-- 리뷰 내용 -->
            <div class="form-group">
                <label for="notice_content">내용</label>
                <textarea class="form-control" id="notice_content" name="notice_content" placeholder="리뷰를 입력하세요" rows="5" required>${review.notice_content}</textarea>
            </div>

            <!-- 상태 -->
            <div class="form-group">
                <label for="status">상태</label>
                <select class="form-control" id="status" name="status" required>
                    <option value="1" <c:if test="${review.status == 1}">selected</c:if>>1=활성화</option>
                    <option value="9" <c:if test="${review.status == 9}">selected</c:if>>9=비활성화</option>
                </select>
            </div>

            <!-- 등록일 -->
            <div class="form-group">
                <label for="regist_date">등록일</label>
                <input type="date" class="form-control" id="regist_date" name="regist_date" value="${review.regist_date}" readonly>
            </div>

            <!-- 리뷰 해제일자 -->
            <div class="form-group">
                <label for="expire_date">해제일</label>
                <input type="date" class="form-control" id="expire_date" name="expire_date" value="${review.expire_date}">
            </div>

            <!-- 등록자 -->
            <div class="form-group">
                <label for="regist_id">등록자</label>
                <input type="text" class="form-control" id="regist_id" name="regist_id" value="${review.regist_id}" required onchange="syncId()">
            </div>

            <!-- 최종 수정자 및 수정일자 -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="last_chg_id">최종 수정자</label>
                    <input type="text" class="form-control" id="expire_id" name="expire_id" value="${review.expire_id}" readonly>
                </div>
                <div class="col">
                    <label for="last_chg_date">리뷰 최종 변경 일자</label>
                    <input type="date" class="form-control" id="last_chg_date" name="last_chg_date" value="<%= currentDate %>" readonly>
                </div>
            </div>

            <!-- 별점 선택 (클릭으로 별점 지정) -->
            <div class="form-group">
                <label for="star_rating">별점</label>
                <div class="star-rating" id="star_rating">
                    <span class="star" data-value="1" <c:if test="${review.star_rating >= 1}">class="selected"</c:if>>&#9733;</span>
                    <span class="star" data-value="2" <c:if test="${review.star_rating >= 2}">class="selected"</c:if>>&#9733;</span>
                    <span class="star" data-value="3" <c:if test="${review.star_rating >= 3}">class="selected"</c:if>>&#9733;</span>
                    <span class="star" data-value="4" <c:if test="${review.star_rating >= 4}">class="selected"</c:if>>&#9733;</span>
                    <span class="star" data-value="5" <c:if test="${review.star_rating >= 5}">class="selected"</c:if>>&#9733;</span>
                </div>
                <!-- 숨겨진 input 필드로 별점 값 저장 -->
                <input type="hidden" id="star_value" name="star_rating" value="${review.star_rating}" />
            </div>

            <!-- 등록 버튼 -->
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">수정</button>
            </div>
        </form>
    </div>

    <script>
        // 별을 클릭하여 별점을 설정하는 기능
        const stars = document.querySelectorAll('.star');
        const starValue = document.getElementById('star_value');
        
        stars.forEach(star => {
            star.addEventListener('click', function() {
                // 클릭된 별점에 따라 선택된 값 설정
                const value = this.getAttribute('data-value');
                starValue.value = value;

                // 선택된 별점까지 별을 gold로 변경
                stars.forEach(star => {
                    if (star.getAttribute('data-value') <= value) {
                        star.classList.add('selected');
                    } else {
                        star.classList.remove('selected');
                    }
                });
            });
        });
    </script>
</body>
</html>
