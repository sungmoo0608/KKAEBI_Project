<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- header.jsp  -->
<jsp:include page="/WEB-INF/views/header.jsp" />

<!-- start of content.jsp(xxx.jsp)   -->
<div class="col-sm-8" onload="document.f.id.focus();">
	<div class="form-container" >
		<h2 class="text-center mb-5 pt-5">로그인</h2>

		<c:url value="/login" var="loginUrl" />
		<form:form name="f" action="${loginUrl}" method="POST">
			<div class="mb-3">
				<!-- <label for="userid" class="form-label">아이디</label> -->
				<input type="text" class="form-control" id="userid" name="userid" placeholder="아이디를 입력해주세요." required>
				<div class="invalid-feedback">아이디를 입력해주세요.</div>
			</div>

			<div class="mb-3">
				<!-- <label for="password" class="form-label">비밀번호</label> -->
				<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호는 최소 3자 이상 입력해주세요." required minlength="3">
				<div class="invalid-feedback">비밀번호는 최소 3자 이상 입력해주세요.</div>
			</div>

			<c:if test="${param.logout != null}">
				<div class="rounded p-1 mb-2 bg-danger text-light text-center">
					<p class="m-0 p-0">로그아웃 하였습니다.</p>
				</div>
			</c:if>

			<c:if test="${param.error != null}">
				<div class="rounded p-1 mb-2 bg-danger text-light text-center">
					<p class="m-0 p-0">아이디와 비밀번호가 잘못되었습니다.</p>
				</div>
			</c:if>

			<div class="d-grid gap-2">
				<button class="btn btn-primary" type="submit">로그인</button>
				<button class="btn btn-outline-secondary" onclick="window.location.href='/join'">회원가입</button>
			</div>
		</form:form>
	</div>
</div>
</div>
</div>
<!-- end of content.jsp(xxx.jsp)   -->

<!-- footer.jsp  -->
<jsp:include page="/WEB-INF/views/footer.jsp" />