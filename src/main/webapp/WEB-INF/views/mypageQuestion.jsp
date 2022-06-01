<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>마이 페이지</title>
  </head>
  <body>
    <jsp:include page="header.jsp"/>

    <div>
      <c:forEach items="${Question}" var="Q">
        <c:out value="${Q.qno}" />
        <c:out value="${Q.title}" />
        <c:out value="${Q.success}" />
      </c:forEach>
    </div>
  </body>
</html>
