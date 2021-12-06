<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
	</div>
	<hr>
	<c:if test="${not empty errorMessage }">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>


	<form method="POST" action="main">
		<h2>
			<a class="brand">Welcome</a>
		</h2>

		<!--  Login validation -->
		<div class="control-group">
			<label for="login"> User name </label> <input type="text" id="login"
				required name="login" data-validation="custom"
				data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{5,20}$"
				data-validation-help="Login should start with a letter and consist of 5-20 characters"
				placeholder="Username" />
		</div>


		<!--  Password validation -->
		<div class="control-group">
			<label for="password"> Password </label> <input type="password"
				id="password" required name="password" data-validation="custom"
				data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
				data-validation-help="Password should start with a letter and consist of 1-20 characters"
				placeholder="Password" />
		</div>
		<div class="footer">
			<input type="hidden" name="action" value="login" />
			<div class="btnfirst">
				<button class="btn btn-access" type="submit" name="login">Submit</button>
				<button class="btn btn-access" type="button"
					onClick='location.href="http://localhost:8080/hospital"'>Return</button>
			</div>
		</div>
	</form>
</body>
</html>