<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Header">
            <a href="./listRegister" class="wrapper__container__Header__btn"
              ><span>게시글 작성</span>
            </a>
          </div>
          <div class="wrapper__container__Main">
            <table class="wrapper__container__Main__table">
              <thead>
                <th>No.</th>
                <th>테이블</th>
                <th>만들기</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>수정일</th>
              </thead>
              <c:forEach items="${list}" var="board">
                <tr>
                  <td><c:out value="${board.bno}" /></td>
                  <td><c:out value="${board.title}" /></td>
                  <td><c:out value="${board.content}" /></td>
                  <td><c:out value="${board.writer}" /></td>
                  <td>
                    <fmt:formatDate
                      pattern="yyyy-MM-dd"
                      value="${board.regdate}"
                    />
                  </td>
                  <td>
                    <fmt:formatDate
                      pattern="yyyy-MM-dd"
                      value="${board.updateDate}"
                    />
                  </td>
                </tr>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
    </wrapper>
  </body>
</html>
