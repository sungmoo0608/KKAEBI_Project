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
        .table th, .table td {
            vertical-align: middle;
            padding: 12px;
            border-top: 1px solid #ddd;
        }
        .table th {
            background-color: #007bff;
            color: white;
        }
        .table td {
            background-color: #f9f9f9;
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
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>공지사항 상세보기</h2>

        <!-- 공지사항 상세 정보 테이블 -->
        <table class="table">
            <tr>
                <th>제목</th>
                <td>${notice.notice_title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${notice.notice_content}</td>
            </tr>
            <tr>
                <th>상태</th>
                <td>
                    ${notice.status == 1 ? '활성화(1)' : '비활성화(9)'}
                </td>
            </tr>
            <tr>
                <th>공지 대상</th>
                <td>
                    <c:choose>
                        <c:when test="${notice.notice_target == 1}">전체(1)</c:when>
                        <c:when test="${notice.notice_target == 2}">관리자(2)</c:when>
                        <c:when test="${notice.notice_target == 3}">고객(3)</c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>공지 시작일</th>
                <td>
                    <!-- 날짜 형식 변환 -->
                    <fmt:parseDate var="parsedNoticeStartDate" value="${notice.notice_st_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${parsedNoticeStartDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>등록일자</th>
                <td>
                    <fmt:parseDate var="parsedRegistDate" value="${notice.regist_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${parsedRegistDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>공지 종료일</th>
                <td>
                    <fmt:parseDate var="parsedNoticeEndDate" value="${notice.notice_end_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${parsedNoticeEndDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>만료일자</th>
                <td>
                    <fmt:parseDate var="parsedExpireDate" value="${notice.expire_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${parsedExpireDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>등록자</th>
                <td>${notice.regist_id}</td>
            </tr>
            <tr>
                <th>해제자</th>
                <td>${notice.expire_id}</td>
            </tr>
            <tr>
                <th>최종 수정자</th>
                <td>${notice.last_chg_id}</td>
            </tr>
            <tr>
                <th>최종 수정일자</th>
                <td>
                    <fmt:parseDate var="parsedLastChgDate" value="${notice.last_chg_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${parsedLastChgDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
        </table>

        <!-- 목록으로 돌아가기 버튼 -->
        <div class="form-group text-center">
            <a href="${pageContext.request.contextPath}/notice/list" class="btn btn-custom-secondary">목록</a>
        </div>
    </div>
</body>
</html>
