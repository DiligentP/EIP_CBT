<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles/style.css" />
    <title>시험 결과</title>
  </head>
  <body>
  <jsp:include page="../header.jsp" />

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <table class="table">
            <thead class="table__header">
              <tr class="table__header__row">
                <th>번호.</th>
                <th>날짜.</th>
                <th>결과</th>
              </tr>
            </thead>

            <c:forEach items="${Result}" var="R">
              <tbody class="table__body">
                <tr class="table__body__row">
                  <td><c:out value="${R.no}" /></td>
                  <td><c:out value="${R.testdate}"/></td>
                  <td><c:out value="${R.answer}"/>/<c:out value="${R.count}"/></td>
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
