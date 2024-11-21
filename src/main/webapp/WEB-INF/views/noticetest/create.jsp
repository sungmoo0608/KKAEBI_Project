<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 등록</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script>
    // 공지 종료일과 만료일자, 해제일자를 동일하게 설정하는 함수
    function syncExpireDate() {
        var endDate = document.getElementById("notice_end_date").value;
        document.getElementById("expire_date").value = endDate;  // 만료일자 자동 설정
        document.getElementById("last_chg_date").value = endDate;  // 최종 수정일자 자동 설정
    }

    // 공지 시작일과 등록일자를 동일하게 설정하는 함수
    function syncRegistDate() {
        var registDate = document.getElementById("notice_st_date").value;
        document.getElementById("regist_date").value = registDate; // 등록일자 자동 설정
    }

    // 등록자와 해제자는 동일하게 설정하는 함수
    function syncId() {
        var registId = document.getElementById("regist_id").value;
        document.getElementById("expire_id").value = registId; // 해제자는 등록자와 동일하게 설정
    }
</script>
</head>
<body>
    <div class="container mt-5">
        <h2>공지사항 등록</h2>
        <form action="${pageContext.request.contextPath}/notice/create" method="post">
            <!-- 공지사항 제목 -->
            <div class="form-group">
                <label for="notice_title">공지사항 제목</label>
                <input type="text" class="form-control" id="notice_title" name="notice_title" placeholder="공지사항 제목을 입력하세요" required>
            </div>

            <!-- 공지사항 내용 -->
            <div class="form-group">
                <label for="notice_content">공지사항 내용</label>
                <textarea class="form-control" id="notice_content" name="notice_content" placeholder="공지사항 내용을 입력하세요" rows="5" required></textarea>
            </div>

            <!-- 상태와 공지 대상 -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="status">상태</label>
                    <select class="form-control" id="status" name="status" required>
                        <option value="1">1=활성화</option>
                        <option value="9">9=비활성화</option>
                    </select>
                </div>
                <div class="col">
                    <label for="notice_target">공지 대상</label>
                    <select class="form-control" id="notice_target" name="notice_target" required>
                        <option value="1">전체</option>
                        <option value="2">관리자</option>
                        <option value="3">고객</option>
                    </select>
                </div>
            </div>

            <!-- 공지 시작일과 등록일 -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="notice_st_date">공지 시작일</label>
                    <input type="date" class="form-control" id="notice_st_date" name="notice_st_date" required onchange="syncRegistDate()">
                </div>
                <div class="col">
                    <label for="regist_date">등록일자</label>
                    <input type="date" class="form-control" id="regist_date" name="regist_date" readonly>
                </div>
            </div>

            <!-- 공지 종료일과 만료일자 -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="notice_end_date">공지 종료일</label>
                    <input type="date" class="form-control" id="notice_end_date" name="notice_end_date" required onchange="syncExpireDate()">
                </div>
                <div class="col">
                    <label for="expire_date">만료일자 (공지종료일과 동일)</label>
                    <input type="date" class="form-control" id="expire_date" name="expire_date" readonly>
                </div>
            </div>

            <!-- 등록자와 해제자 -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="regist_id">등록자</label>
                    <input type="text" class="form-control" id="regist_id" name="regist_id" required onchange="syncId()">
                </div>
                <div class="col">
                    <label for="expire_id">해제자</label>
                    <input type="text" class="form-control" id="expire_id" name="expire_id" readonly>
                </div>
            </div>

            <!-- 최종 수정자 및 수정일자 (자동으로 설정됨) -->
            <div class="form-group form-row">
                <div class="col">
                    <label for="last_chg_id">최종 수정자</label>
                    <input type="text" class="form-control" id="last_chg_id" name="last_chg_id" readonly>
                </div>
                <div class="col">
                    <label for="last_chg_date">최종 수정일자</label>
                    <input type="date" class="form-control" id="last_chg_date" name="last_chg_date" readonly>
                </div>
            </div>

            <!-- 등록 버튼 -->
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">등록</button>
            </div>
        </form>
    </div>
</body>
</html>
