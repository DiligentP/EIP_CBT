<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="../styles/style.css" />
  <title>게시판</title>
</head>
<body>
<header>
  <nav>
    <ul>
      <li>
        <a href="/"
        ><img src="../assets/icons.png" class="header__logo"
        /></a>
      </li>
      <li class="header__title">
        <a href="/">정보처리기사 CBT</a>
      </li>
    </ul>
    <ul class="header__nav">
      <li><a href="/board/list">게시판</a></li>
      <!-- 로그인 세션이 존재하는 경우 -->
      <c:if test="${not empty login_info}">
        <li id="header_mypage"><a href="./mypage">마이페이지</a></li>
        <li>[${login_info.member_name}]님 반갑습니다</li>
        <li><a href="./logout">로그아웃</a></li>
      </c:if>

      <c:if test="${empty login_info}">
        <li>
          <a href="./login"><span class="header__login">로그인</span></a>
        </li>
      </c:if>
    </ul>
  </nav>
</header>

<form role="form" action="/board/modify" method="post">
	넘버(수정불가): <input name='bno' value='<c:out value="${board.bno}"/>' readonly="readonly">
	<br>제목: <input name='title' value='<c:out value="${board.title}"/>'>
	<br>내용: <textarea rows="3" name='content'><c:out value="${board.content}"/></textarea>
	<br>작성자(수정불가): <input name='writer' value='<c:out value="${board.title}"/>' readonly="readonly">
	<br><input type="submit" value="수정">
</form>

<form role="form" action="/board/remove" method="post">
	<input type="hidden" name='bno' value = '<c:out value="${board.bno}"/>' readonly="readonly">
	<input type="submit" value="제거">
</form>

<br>리스트로 되돌아가기 -> <a href="/board/list">list</a>

</body>
</html>
