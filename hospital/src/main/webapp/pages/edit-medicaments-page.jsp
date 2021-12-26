<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit medicaments</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/general.css" />
</head>
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
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-success">${errorMessage}</div>
		</c:if>
		<form class="form edit-form" method="POST" action="main">

			<h2>Update Medicaments</h2>
			<hr />
			<div class="body">
				<!--  Name  -->
				<div class="control-group">
					<label for="name"> Name </label> <input type="text" id="name"
						value="${medicamentService.name}" required name="name"
						data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Name should start with a letter and consist of 1-20 characters"
						placeholder="Name" />
				</div>
				<!--  Description  -->
				<div class="control-group">
					<label for="description"> Description </label> <input type="text"
						value="${medicamentService.description}" id="description" required
						name="description" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Description should start with a letter and consist of 1-20 characters"
						placeholder="Description" />
				</div>
				<!--  Cost  -->
				<div class="control-group">
					<label for="cost"> Cost </label> <input type="text" id="cost"
						value="${medicamentService.cost}" required name="cost"
						data-validation="custom" data-validation-regexp="{1,99999999}$"
						data-validation-help="Cost should start with a letter and consist of 1-20 characters"
						placeholder="Cost" />
				</div>
			</div>
			<div class="footer">
				<input type="hidden" name="action" value="update-medicament" /> <input
					type="hidden" name="id" value="${medicamentService.id}" />
				<div class="btnfirst">
					<button class="btn btn-primary btn-sm mb-2" type="submit">Update</button>
				</div>
			</div>
		</form>


	</div>

</body>
</html>