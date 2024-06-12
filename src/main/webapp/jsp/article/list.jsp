<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<Map<String, Object>> articleListMap = (List<Map<String, Object>>) request.getAttribute("articleListMap");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>
	<div>
		<div><a href="<%= request.getContextPath() %>/home/main">메인</a></div>
	</div>

	<table border=1>
		<colgroup>
			<col />
			<col width="200"/>
			<col />
		</colgroup>
		<tr>
			<th>번호</th>
			<th>작성일</th>
			<th>제목</th>
		</tr>
		<% 
		for (Map<String, Object> articleMap : articleListMap) {
		%>
			<tr>
				<td><%= articleMap.get("id") %></td>
				<td><%= articleMap.get("updateDate") %></td>
				<td><a href="detail?id=<%= articleMap.get("id") %>"><%= articleMap.get("title") %></a></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>