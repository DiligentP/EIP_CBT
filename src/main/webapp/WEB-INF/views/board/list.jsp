<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html>
<head>
<meta charset="EUC-KR">
<title>초간단 테이블</title>
</head>
<body>
	<table border="1">
		<thead>
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
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${board.regdate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${board.updateDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>