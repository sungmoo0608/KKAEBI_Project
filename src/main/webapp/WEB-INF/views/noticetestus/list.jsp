<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
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

        h3 {
            color: #007bff;
            margin-bottom: 30px;
            font-weight: bold;
        }

        .table th, .table td {
            vertical-align: middle;
        }

        th, td {
            text-align: center;
        }

        th.notice_seq_no, td.notice_seq_no, th.notice_target, td.notice_target,
        th.status, td.status {
            width: 80px;
        }

        th.notice_title, td.notice_title {
            width: 300px;
        }

        th.notice_regist_date, td.notice_regist_date {
            width: 150px;
        }

        th.notice_manage, td.notice_manage {
            width: 150px;
        }

        .btn-custom {
            font-size: 14px;
            border-radius: 5px;
        }

        .btn-warning {
            background-color: #f0ad4e;
            border: none;
        }

        .btn-warning:hover {
            background-color: #ec971f;
        }

        .btn-success {
            background-color: #5bc0de;
            border: none;
        }

        .btn-success:hover {
            background-color: #31b0d5;
        }

        .btn-danger {
            background-color: #d9534f;
            border: none;
        }

        .btn-danger:hover {
            background-color: #c9302c;
        }

        .table th {
            background-color: #007bff;
            color: #ffffff;
        }

        .table-striped tbody tr:nth-child(odd) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3 class="my-4">공지사항</h3>

        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class="notice_seq_no">번호</th>
                    <th class="notice_title">제목</th>
                    <th class="notice_regist_date">등록일</th>
                    <th class="notice_manage">상세</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty noticeus}">
                    <tr>
                        <td colspan="4" class="text-center">검색 결과가 없습니다.</td>
                    </tr>
                </c:if>
                <!-- 블라인드 처리된 게시물을 제외하고 새 번호를 매기기 위해 status.index 사용 -->
                <c:forEach var="notice" items="${noticeus}" varStatus="status">
                    <!-- 블라인드 처리된 게시물 제외 -->
                    <c:if test="${notice.status != '2'}">
                        <tr>
                            <!-- status.index + 1을 사용하여 새 일련번호를 출력 -->
                            <td class="notice_seq_no">${status.index + 1}</td>
                            <td class="notice_title">${notice.notice_title}</td>
                            <td class="notice_regist_date">
                                <fmt:parseDate var="parsedDate" value="${notice.regist_date}" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${parsedDate}" pattern="yy-MM-dd" />
                            </td>
                            <td class="notice_manage">
                                <a class="btn btn-warning btn-custom" href="${pageContext.request.contextPath}/noticeus/detail?seq_no=${notice.seq_no}">상세</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
