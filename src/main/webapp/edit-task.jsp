
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tasks.Task"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <% Task task=(Task)request.getAttribute("task"); %>
  <form method="post" action="/task/update">
      <input type="text" name="name" value="<%=task.name %>"/>
      <input type="text" name="description" value="<%= task.description%>" />
      <input type="hidden" name="tid" value=<%= task.id %> />
      <button type="submit">update</button>
  </form>
</body>
</html>