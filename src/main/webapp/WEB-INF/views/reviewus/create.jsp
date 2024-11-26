<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 작성</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        .star-rating {
            display: flex;
            direction: row-reverse;
            font-size: 2rem;
        }
        .star-rating input {
            display: none;
        }
        .star-rating label {
            cursor: pointer;
            color: #ddd;  /* 기본 색상 (회색) */
        }
        .star-rating input:checked ~ label,
        .star-rating input:checked ~ label ~ label {
            color: gold;  /* 별을 색칠할 때 색상 (노란색) */
        }
        .star-rating input:hover ~ label,
        .star-rating input:hover ~ label ~ label {
            color: #fc0;  /* 호버 시 별 색상 (노란색) */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">리뷰 작성</h1>
        
       <form action="${pageContext.request.contextPath}/review/create" method="post">
            <div class="mb-3">
                <label for="notice_title" class="form-label">제목</label>
                <input type="text" class="form-control" id="noticetitle" name="noticetitle" required>
            </div>

            <!-- 별점 선택 -->
            <div class="mb-3">
                <label for="" class="form-label">별점</label>
                <div class="star_rating" id="star_rating">
                 <input type="radio" id="star-1" name="reviewRating" value="1" />
                    <label for="star-1">&#9733;</label>
                    <input type="radio" id="star-2" name="reviewRating" value="2" />
                    <label for="star-2">&#9733&#9733;</label>
                    <input type="radio" id="star-3" name="reviewRating" value="3" />
                    <label for="star-3">&#9733&#9733&#9733;</label>
                    <input type="radio" id="star-4" name="reviewRating" value="4" />
                    <label for="star-4">&#9733&#9733&#9733&#9733;</label>
                     <input type="radio" id="star-5" name="reviewRating" value="5" />
                    <label for="star-5">&#9733&#9733&#9733&#9733&#9733;</label>
                </div>
            </div>

            <div class="mb-3">
                <label for="reviewContent" class="form-label">내용</label>
                <textarea class="form-control" id="notice_content" name="notice_content" rows="4" required></textarea>
            </div>

            <button type="submit" class="btn btn-primary">작성</button>
        </form>
    </div>

    <!-- Bootstrap 5 JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
