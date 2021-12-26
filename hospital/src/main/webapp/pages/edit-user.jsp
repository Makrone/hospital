<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit user</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/general.css" />
</head>
<body>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
		<form class="navbar-form pull-left" action="main" method="POST">
			<input type="hidden" name="action" value="logout" />
			<div class="btnfirst">
				<button class="btn btn-danger btn-sm" style="float: right;"
					type="submit" name="logout">Log out</button>
			</div>
		</form>
		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-profile" />
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" style="float: right;"
					type="submit" name="go-to-profile">Profile</button>
			</div>
		</form>
	</div>

	<form class="form edit-form" method="POST" action="main">

		<h2>Edit User</h2>
		<hr />
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-success">${errorMessage}</div>
		</c:if>

		<div class="body">
			<div class="control-group">
				<label for="money"> First Name </label> <input type="text"
					id="first_name" value="${user.firstName}" required
					name="first_name" data-validation="custom"
					data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
					data-validation-help="Name should start with a letter and consist of 1-20 characters"
					placeholder="First Name" />
			</div>
			<div class="control-group">
				<label for="money"> Last Name</label> <input type="text"
					id="last_name" value="${user.lastName}" required name="last_name"
					data-validation="custom"
					data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
					data-validation-help="Name should start with a letter and consist of 1-20 characters"
					placeholder="Last Name" />
			</div>
			<!--  Gender -->
			<div class="control-group">
				<p>
					<label for="gender"> Gender </label> <select name="gender"
						id="gender">
						<option selected value="MALE">Male</option>
						<option value="FEMALE">Female</option>
					</select>

				</p>
			</div>
			<!--  User Type  -->
			<div class="control-group">
				<p>
					<label for="user_type"> User Type </label> <select name="user_type"
						id="user_type">
						<option selected value="CLIENT">Client</option>
						<option value="ADMIN">Admin</option>
						<option value="DOCTOR">Doctor</option>
					</select>

				</p>
			</div>

			<!--  Phone name validation -->
			<div class="control-group">
				<label for="phone"> Phone </label> <input type="text" id="phone"
					value="${user.phone}" required name="phone"
					data-validation="custom"
					data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{7,20}$"
					data-validation-help="Phone should start with a letter and consist of 1-20 characters"
					placeholder="Phone" />
			</div>
			<!--  Email validation -->
			<div class="control-group">
				<label for="email"> Email </label> <input type="text" id="email"
					value="${user.email}" required name="email"
					data-validation="custom"
					data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
					data-validation-help="Email should start with a letter and consist of 1-20 characters"
					placeholder="Email" />
			</div>

			<!--  Login validation -->
			<div class="control-group">
				<label for="username"> Username </label> <input type="text"
					value="${user.username}" id="username" required name="username"
					data-validation="custom"
					data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{5,20}$"
					data-validation-help="Login should start with a letter and consist of 5-20 characters"
					placeholder="Username" />
			</div>

			<div class="control-group">
				<label for="money"> Quantity </label> <input type="text" id="money"
					value="${user.money}" required name="money"
					data-validation="custom"
					data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
					data-validation-help="Name should start with a letter and consist of 1-20 characters"
					placeholder="Money" />
			</div>

			<div class="footer">
				<input type="hidden" name="action" value="edit-user" /> <input
					type="hidden" name="id" value="${user.id}" />
				<div class="btnfirst">
					<button class="btn btn-primary btn-sm mb-2" type="submit">Save</button>
				</div>
			</div>
		</div>
	</form>


</body>
</html>