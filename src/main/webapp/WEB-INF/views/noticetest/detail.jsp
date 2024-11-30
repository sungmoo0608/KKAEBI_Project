<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 상세보기</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #007bff;
            margin-bottom: 30px;
        }
        .form-group label {
            font-weight: bold;
        }
        .form-control {
            background-color: #f1f1f1;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .btn-custom {
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
        }
        .btn-custom-secondary {
            background-color: #6c757d;
            color: white;
            border: none;
        }
        .btn-custom-secondary:hover {
            background-color: #5a6268;
        }
        .btn-custom-info {
            background-color: #17a2b8;
            color: white;
            border: none;
        }
        .btn-custom-info:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>공지사항 상세보기</h2>

        <!-- 공지사항 제목 -->
        <div class="form-group">
            <label for="notice_title">공지사항 제목</label>
            <div class="form-control">${notice.notice_title}</div>
        </div>

        <!-- 공지사항 내용 -->
        <div class="form-group">
            <label for="notice_content">공지사항 내용</label>
            <div class="form-control">${notice.notice_content}</div>
        </div>

        <!-- 상태와 공지 대상 -->
        <div class="form-group form-row">
            <div class="col">
                <label for="status">상태</label>
                <div class="form-control">
                    ${notice.status == 1 ? '활성화' : '비활성화'}
                </div>
            </div>
            <div class="col">
                <label for="notice_target">공지 대상</label>
                <div class="form-control">
                    <c:choose>
                        <c:when test="${notice.notice_target == 1}">전체</c:when>
                        <c:when test="${notice.notice_target == 2}">관리자</c:when>
                        <c:when test="${notice.notice_target == 3}">고객</c:when>
                    </c:choose>
                </div>
            </div>
        </div>

        <!-- 공지 시작일과 등록일 -->
        <div class="form-group form-row">
            <div class="col">
                <label for="notice_st_date">공지 시작일</label>
                <!-- fmt:parseDate와 fmt:formatDate를 사용하여 날짜 형식 변환 -->
                <fmt:parseDate var="parsedNoticeStartDate" value="${notice.notice_st_date}" pattern="yyyy-MM-dd" />
                <div class="form-control">
                    <fmt:formatDate value="${parsedNoticeStartDate}" pattern="yyyy-MM-dd" />
                </div>
            </div>
            <div class="col">
                <label for="regist_date">등록일자</label>
                <!-- fmt:parseDate와 fmt:formatDate를 사용하여 날짜 형식 변환 -->
                <fmt:parseDate var="parsedRegistDate" value="${notice.regist_date}" pattern="yyyy-MM-dd" />
                <div class="form-control">
                    <fmt:formatDate value="${parsedRegistDate}" pattern="yyyy-MM-dd" />
                </div>
            </div>
        </div>

        <!-- 공지 종료일과 만료일자 -->
        <div class="form-group form-row">
            <div class="col">
                <label for="notice_end_date">공지 종료일</label>
                <!-- fmt:parseDate와 fmt:formatDate를 사용하여 날짜 형식 변환 -->
                <fmt:parseDate var="parsedNoticeEndDate" value="${notice.notice_end_date}" pattern="yyyy-MM-dd" />
                <div class="form-control">
                    <fmt:formatDate value="${parsedNoticeEndDate}" pattern="yyyy-MM-dd" />
                </div>
            </div>
            <div class="col">
                <label for="expire_date">만료일자</label>
                <!-- fmt:parseDate와 fmt:formatDate를 사용하여 날짜 형식 변환 -->
                <fmt:parseDate var="parsedExpireDate" value="${notice.expire_date}" pattern="yyyy-MM-dd" />
                <div class="form-control">
                    <fmt:formatDate value="${parsedExpireDate}" pattern="yyyy-MM-dd" />
                </div>
            </div>
        </div>

        <!-- 등록자와 해제자 -->
        <div class="form-group form-row">
            <div class="col">
                <label for="regist_id">등록자</label>
                <div class="form-control">${notice.regist_id}</div>
            </div>
            <div class="col">
                <label for="expire_id">해제자</label>
                <div class="form-control">${notice.expire_id}</div>
            </div>
        </div>

        <!-- 최종 수정자 및 수정일자 -->
        <div class="form-group form-row">
            <div class="col">
                <label for="last_chg_id">최종 수정자</label>
                <div class="form-control">${notice.last_chg_id}</div>
            </div>
            <div class="col">
                <label for="last_chg_date">최종 수정일자</label>
                <!-- fmt:parseDate와 fmt:formatDate를 사용하여 날짜 형식 변환 -->
                <fmt:parseDate var="parsedLastChgDate" value="${notice.last_chg_date}" pattern="yyyy-MM-dd" />
                <div class="form-control">
                    <fmt:formatDate value="${parsedLastChgDate}" pattern="yyyy-MM-dd" />
                </div>
            </div>
        </div>

        <!-- 목록으로 돌아가기 버튼 -->
        <div class="form-group text-center">
            <a href="${pageContext.request.contextPath}/noticetest/list" class="btn btn-custom-secondary">목록</a>
        </div>

    </div>
</body>
</html>

