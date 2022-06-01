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
  <jsp:include page="../header.jsp"/>

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
                <tr class="wrapper__container__Main__value">
                  <th>No.</th>
                  <th>제목</th>
                  <th>내용</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>수정일</th>
                </tr>
              </thead>
              <c:forEach items="${list}" var="board">
                <tr class="wrapper__container__Main__value">
                  <td><c:out value="${board.bno}" /></td>
                  <td><a href='/board/get?bno=<c:out value="${board.bno}" />&pageNum=<c:out value="${pageMaker.cri.pageNum}"/>&amount=<c:out value="${pageMaker.cri.amount}"/>' class="onHover"><c:out value="${board.title}"/></a></td>
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
    
  	<ul class="pagination">
	<c:if test="${pageMaker.prev}">
	<li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a>
	</li>
	</c:if>
	
	<c:forEach var="num" begin="${pageMaker.startPage}"
	end="${pageMaker.endPage}">
	<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""} ">
	<a href='/board/list?pageNum=<c:out value="${num}"/>&amount=10'>${num}</a>
	</li>
	</c:forEach>
	
	<c:if test="${pageMaker.next}">
	<li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a>
	</li>
	</c:if>
	</ul>
    
  </body>
</html>
