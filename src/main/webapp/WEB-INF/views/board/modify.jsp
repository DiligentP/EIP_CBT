<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
          <h2><c:out value="${board.title}" /></h2>
        </div>
        <!-- input 태그  -->
        <form
                role="form"
                action="/board/modify"
                method="post"
                id="board__form"
        >
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
            />
            <textarea
                    id="board_textArea"
                    name="content"
                    placeholder="작성하는 내용"
                    cols="40"
                    rows="10"
            ><c:out value="${board.content}"/></textarea>
            <input
                    id="board_writer"
                    name="writer"
                    value='<c:out value="${board.writer}"/>'
                    placeholder="사용자"
                    readonly="readonly"
            />
          </div>
          <div class="wrapper__container__btn">
              <input type="submit" value="수정" id="wrapperSubmitBtn" />
          
          </form>
          <form role="form" action="/board/remove" method="post">
            <input
            type="hidden"
            name="bno"
            value='<c:out value="${board.bno}"/>'
            readonly="readonly"
            />
            <input type="submit" value="삭제" id="wrapperSubmitBtn" />
          </form>
          <a href="/board/get?bno=<c:out value="${board.bno}"/>&pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>">돌아가기</a>
      </div>
      </div>
    </div>
  </div>
</wrapper>
<jsp:include page="../footer.jsp" />
</body>
</html>

