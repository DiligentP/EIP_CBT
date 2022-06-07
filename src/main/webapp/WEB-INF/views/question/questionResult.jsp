<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
        uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>필기 시험 결과</title>
</head>
<body>
<jsp:include page="../header.jsp" />

<wrapper>
    <div class="wrapper">
      <div class="wrapper__container">
        <div class="test__result">
            <span>시험 결과</span>
        </div>
        <table class="table">
          <thead class="table__header">
            <tr class="table__header__row">
              <th>번호.</th>
              <th>제목.</th>
              <th>정답</th>
            </tr>
          </thead>

          <c:forEach items="${Question}" var="Q">
            <tbody class="table__body">
              <tr class="table__body__row">
                <td><c:out value="${Q.qno}" /></td>
                <td><a href="/mypage/questionListDetail?qno=<c:out value="${Q.qno}"/>"> <c:out value="${Q.title}" /></a></td>
                <td><c:out value="${Q.success}" /></td>
              </tr>
            </tbody>
          </c:forEach>
        </table>
      </div>
    </div>
  </wrapper>


<jsp:include page="../footer.jsp" />
</body>
</html>
