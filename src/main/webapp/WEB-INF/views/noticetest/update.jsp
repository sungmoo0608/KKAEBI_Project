<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<!-- 관리자 공지사항 수정 페이지 -->
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 수정</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
.form-group {
	margin-bottom: 1rem;
}
</style>
<!-- 자바스크립트 추가 -->
<script>
	// 수정 완료 버튼 클릭 시 팝업 확인
	function confirmUpdate(event) {
		var confirmResult = confirm("수정하시겠습니까?");
		if (!confirmResult) {
			// 만약 '취소'를 선택하면, 폼이 제출되지 않도록 막기
			event.preventDefault();
		}
	}
</script>
</head>
<body>
	<div class="container mt-5">
		<h2>공지사항 수정</h2>
		<form action="${pageContext.request.contextPath}/noticetest/update"
			method="post">
			<!-- 일련번호 (고정, 수정 불가) -->
			<div class="form-group">
				<label for="seq_no">일련번호</label> <input type="text"
					class="form-control" id="seq_no" name="seq_no"
					value="${notice.seq_no}" readonly> <input type="hidden"
					name="seq_no" value="${notice.seq_no}">
			</div>

			<div class="table-responsive">
				<table class="table table-bordered">
					<tbody>
						<!-- 공지사항 제목 -->
						<tr>
							<th class="notice_title">공지사항 제목</th>
							<td><input type="text" class="form-control"
								id="notice_title" name="notice_title"
								value="${notice.notice_title}" required></td>
						</tr>

						<!-- 공지사항 내용 -->
						<tr>
							<th class="notice_content">공지사항 내용</th>
							<td><textarea class="form-control" id="notice_content"
									name="notice_content" rows="5" required>${notice.notice_content}</textarea></td>
						</tr>

						<!-- 공지 대상 -->
						<!-- 공지 대상 -->
						<tr>
							<th class="notice_target">공지 대상</th>
							<td><select class="form-control" id="notice_target"
								name="notice_target">
									<option value="1"
										${notice.notice_target == 1 ? 'selected' : ''}>1(전체)</option>
									<option value="2"
										${notice.notice_target == 2 ? 'selected' : ''}>2(관리자)</option>
							<option value="3"
										${notice.notice_target == 3 ? 'selected' : ''}>3(고객)</option>
							</select>
							</td>
						</tr>

						<!-- 상태 -->
						<tr>
							<th class="status">상태</th>
							<td><select class="form-control" id="status" name="status">
									<option value="1" ${notice.status == 1 ? 'selected' : ''}>1(활성)</option>
									<option value="9" ${notice.status == 9 ? 'selected' : ''}>9(비활)</option>
							</select></td>
						</tr>

						<!-- 공지 시작일 -->
						<tr>
							<th class="notice_st_date">공지 시작일</th>
							<td><fmt:parseDate value="${notice.notice_st_date}"
									pattern="yyyy-MM-dd" var="parsedStDate" /> <input type="text"
								class="form-control" id="notice_st_date" name="notice_st_date"
								value="<fmt:formatDate value="${parsedStDate}" pattern="yy-MM-dd" />"
								required></td>
						</tr>

						<!-- 공지 종료일 -->
						<tr>
							<th class="notice_end_date">공지 종료일</th>
							<td><fmt:parseDate value="${notice.notice_end_date}"
									pattern="yyyy-MM-dd" var="parsedEndDate" /> <input type="text"
								class="form-control" id="notice_end_date" name="notice_end_date"
								value="<fmt:formatDate value="${parsedEndDate}" pattern="yy-MM-dd" />"
								required></td>
						</tr>

						<!-- 상태 -->
						<tr>
							<th class="status">상태</th>
							<td><select class="form-control" id="status" name="status">
									<option value="1" ${notice.status == 1 ? 'selected' : ''}>1</option>
									<option value="9" ${notice.status == 9 ? 'selected' : ''}>9</option>
							</select></td>
						</tr>

						<!-- 등록자 -->
						<tr>
							<th class="regist_id">등록자</th>
							<td><input type="text" class="form-control" id="regist_id"
								name="regist_id" value="${notice.regist_id}" readonly></td>
						</tr>

						<!-- 등록일자 -->
						<tr>
							<th class="regist_date">등록일자</th>
							<td><fmt:parseDate value="${notice.regist_date}"
									pattern="yyyy-MM-dd" var="parsedRegistDate" /> <input
								type="text" class="form-control" id="regist_date"
								name="regist_date"
								value="<fmt:formatDate value="${parsedRegistDate}" pattern="yy-MM-dd" />"
								readonly></td>
						</tr>

						<!-- 최종 변경자 -->
						<tr>
							<th class="last_chg_id">최종 변경자</th>
							<td><input type="text" class="form-control" id="last_chg_id"
								name="last_chg_id" value="${notice.last_chg_id}" readonly></td>
						</tr>

						<!-- 최종 변경 일자 -->
						<tr>
							<th class="last_chg_date">최종 변경 일자</th>
							<td><fmt:parseDate value="${notice.last_chg_date}"
									pattern="yyyy-MM-dd" var="parsedLastChgDate" /> <input
								type="text" class="form-control" id="last_chg_date"
								name="last_chg_date"
								value="<fmt:formatDate value="${parsedLastChgDate}" pattern="yy-MM-dd" />"
								readonly></td>
						</tr>

						<!-- 해제 등록자 -->
						<tr>
							<th class="expire_id">해제 등록자</th>
							<td><input type="text" class="form-control" id="expire_id"
								name="expire_id" value="${notice.expire_id}" readonly></td>
						</tr>

						<!-- 해제 일자 -->
						<tr>
							<th class="expire_date">해제 일자</th>
							<td><fmt:parseDate value="${notice.expire_date}"
									pattern="yyyy-MM-dd" var="parsedExpireDate" /> <input
								type="text" class="form-control" id="expire_date"
								name="expire_date"
								value="<fmt:formatDate value="${parsedExpireDate}" pattern="yy-MM-dd" />"
								readonly></td>
						</tr>

					</tbody>
				</table>
			</div>

			<!-- 수정 완료 버튼 -->
			<div class="text-center mt-3">
				<button type="submit" class="btn btn-success"
					onclick="confirmUpdate(event)">수정</button>
				<a class="btn btn-secondary"
					href="${pageContext.request.contextPath}/noticetest/list">목록</a>
			</div>
		</form>
	</div>
</body>
</html>
