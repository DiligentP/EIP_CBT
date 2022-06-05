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
              <a href="/board/modify?bno=<c:out value="${board.bno}"/>&pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>" id="boardSubBtn">수정하기</a>
              <a href="/board/list?pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>">돌아가기</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  
</wrapper>



<!-- 댓글 작성 -->
<div class="comment">
  <form role="form" action="/reply/new" method="post" class="comment__in_form">
    <input type="hidden" name="bno" value= <c:out value="${board.bno}"/>>
    <input type="text" name="replyer" placeholder="작성자" id="comment_plyer">
    <input type="text" name="reply" placeholder="댓글 내용" id="comment_ply">
    <input type="hidden" name="pageNum" value= <c:out value="${pageMaker.cri.pageNum}"/>>
    <input type="submit" value="댓글작성" class="comment_sub">
  </form>
  
  <!-- 댓글 출력 -->
  <div class="comment__out">
    <c:forEach items="${lists}" var="reply">
      <div class="comment__out_view">
        <span><c:out value="${reply.replyer}" /></span>
        <span><c:out value="${reply.reply}" /></span>
      </div>
      <!-- 댓글 수정 -->
      <div class="comment__modify">
        <form role="form" action="/reply/modify" method="post" class="modify__form">
          <input type="hidden" name="bno" value= <c:out value="${reply.bno}"/>>
          <input type="hidden" name="rno" value= <c:out value="${reply.rno}"/>>
          <input type="hidden" name="pageNum" value= <c:out value="${pageMaker.cri.pageNum}"/>>
          <input type="text" name="reply" placeholder="수정할내용" class="modify_text"> 
          <input type="submit" value="수정" class="comment_sub" >
        </form>
        <!-- 댓글 삭제 -->
        <form role="form" action="/reply/remove" method="post" class="delete__form">
          <input type="hidden" name="bno" value= <c:out value="${reply.bno}"/>>
          <input type="hidden" name="rno" value= <c:out value="${reply.rno}"/> readonly="readonly">
          <input type="hidden" name="pageNum" value= <c:out value="${pageMaker.cri.pageNum}"/>>
          <input type="submit" value="삭제" class="comment_sub">
        </form>
      </div>
  </c:forEach>
  </div>
</div>


<script>

  const boardSubBtn = document.getElementById("boardSubBtn");
  
  const writer = '<c:out value="${board.writer}"/>';
  const loginId = '<c:out value="${login_info.member_id}"/>';
  
  const handleSubmit = (event) => {
      if (writer !== loginId) {
          alert("작성자가 아닙니다.");
          event.preventDefault();
      }
  };
  

  
  boardSubBtn.addEventListener("click", handleSubmit);
  
  </script>

<jsp:include page="../footer.jsp" />
</body>
</html>