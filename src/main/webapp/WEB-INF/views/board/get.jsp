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
          <h2><c:out value="${board.title}"/></h2>
        </div>
        <!-- input 태그  -->
        <div class="wrapper__container__input">
          <div class="board__form__input">
            
            <textarea
                    id="board_textArea"
                    name="content"
                    placeholder="작성하는 내용"
                    cols="40"
                    rows="20"
                    readonly="readonly"
                    style="border: none"
            ><c:out value="${board.content}"/></textarea>
            
          </div>
          <div class="wrapper__container__btn">
              <a href="/board/modify?bno=<c:out value="${board.bno}"/>&pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>">수정하기</a>
              <a href="/board/list?pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>">돌아가기</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  
</wrapper>

<form role="form" action="/reply/new" method="post">
	<input type="hidden" name="bno" value= <c:out value="${board.bno}"/>>
	<input type="text" name="replyer" placeholder="작성자">
	<input type="text" name="reply" placeholder="댓글내용">
	<input type="submit" value="댓글작성">
</form>

<c:forEach items="${lists}" var="reply">
	<td><c:out value="${reply.replyer}" /></td> 
	<td><c:out value="${reply.reply}" /></td><br>

</c:forEach>

	
<br><br><br>예에?


<jsp:include page="../footer.jsp" />
</body>
</html>