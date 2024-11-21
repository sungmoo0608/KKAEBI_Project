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
        table {
            width: 100%;
            margin-bottom: 30px;
        }
        th, td {
            text-align: left;
            padding: 10px;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        td {
            background-color: #f9f9f9;
            border-top: 1px solid #ddd;
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
        <h2>공지사항</h2>

        <!-- 공지사항 상세 정보 테이블 -->
        <table class="table">
            <tr>
                <th>제목</th>
                <td>${noticeus.notice_title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${noticeus.notice_content}</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td>
                    <!-- 날짜 형식 변환 -->
                    <fmt:parseDate var="parsedRegistDate" value="${noticeus.regist_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                    <fmt:formatDate value="${parsedRegistDate}" pattern="yy-MM-dd" />
                </td>
            </tr>
            <tr>
                <th>등록자</th>
                <td>${noticeus.regist_id}</td>
            </tr>
        </table>

        <!-- 목록으로 돌아가기 버튼 -->
        <div class="form-group text-center">
            <a href="${pageContext.request.contextPath}/noticeus/list" class="btn btn-custom-secondary">목록</a>
        </div>
    </div>
</body>
</html>
