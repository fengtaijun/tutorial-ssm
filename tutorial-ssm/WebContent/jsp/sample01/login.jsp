<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts2 - demo</title>
</head>
<body>
	<div align="center">
		<h1>This is struts2 demo login page.</h1>
		<a href="${pageContext.request.contextPath}">Home</a>
		<hr>
		<form action="${pageContext.request.contextPath}/struts/logincheck"
			method="post">
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit">
		</form>
		<font color="red">${message}</font>
	</div>
</body>
</html>