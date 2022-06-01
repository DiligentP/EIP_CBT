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
<jsp:include page="../header.jsp"/>

<wrapper>
  <div class="wrapper">
    <div class="wrapper__container">
      <div class="wrapper__container__Main">
        <div class="board__register">
          <h2>Title: <c:out value="${board.title}"/></h2>
        </div>
        <!-- input 태그  -->
        <div class="wrapper__container__input">
          <div class="board__form__input">
            <input
                    id="board_bno"
                    name="bno"
                    value='<c:out value="${board.bno}"/>'
                    readonly="readonly"
            />
            <input
                    id="board_title"
                    name="title"
                    value='<c:out value="${board.title}"/>'
                    placeholder="작성하는 제목"
                    readonly="readonly"
            />
            <textarea
                    id="board_textArea"
                    name="content"
                    placeholder="작성하는 내용"
                    cols="40"
                    rows="10"
                    readonly="readonly"
            ><c:out value="${board.content}"/></textarea>
            <input
                    id="board_writer"
                    name="writer"
                    value='<c:out value="${board.title}"/>'
                    placeholder="사용자"
                    readonly="readonly"
            />
          </div>
          <div class="wrapper__container__btn">
            <div class="">
              <a href="/board/modify?bno=<c:out value="${board.bno}"/>&pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>">수정</a>
            </div>
            <div class="">
              <a href="/board/list?pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>">게시판</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</wrapper>


<%--<wrapper>--%>
<%--  <div class="wrapper">--%>
<%--    <div class="wrapper__container">--%>
<%--      넘버: <input name='bno' value='<c:out value="${board.bno}"/>' readonly="readonly">--%>
<%--      <br>제목: <input name='title' value='<c:out value="${board.title}"/>' readonly="readonly">--%>
<%--      <br>내용: <textarea rows="3" name='content' readonly="readonly"><c:out value="${board.content}"/></textarea>--%>
<%--      <br>작성자: <input name='writer' value='<c:out value="${board.title}"/>' readonly="readonly">--%>

<%--      <br>--%>
<%--      수정 -><a href="/board/modify?bno=<c:out value="${board.bno}"/>">modify, </a>--%>
<%--      게시판 리스트 -> <a href="/board/list">list</a>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</wrapper>--%>



</body>
</html>