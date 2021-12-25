<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creating</title>
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
<hr />
		<form class="form register-form" method="POST" action="main">
				<h2>
					<a>Create new Treatment</a>
				</h2>
			<div class="body">
				<!--  Name  -->
				<div class="control-group">
					<label for="name"> Client name </label> <input type="text" id="name"
						required name="name" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Name should start with a letter and consist of 1-20 characters"
						placeholder="Client name" />
				</div>
				<!--  Description  -->
				<div class="control-group">
					<label for="description"> Doctor name </label> <input type="text"
						id="description" required name="description"
						data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Description should start with a letter and consist of 1-20 characters"
						placeholder="Doctor name" />
				</div>
				<!--  Cost  -->
				<div class="control-group">
					<label for="cost"> Medical conclusion </label> <input type="text" id="cost"
						required name="cost" data-validation="custom"
						data-validation-regexp="{1,99999999}$"
						data-validation-help="Cost should start with a letter and consist of 1-20 characters"
						placeholder="Medical conclusion" />
				</div>
			</div>
			<div class="footer">
				<input type="hidden" name="action" value="add-treatment" />
				<div class="btnfirst">
					<button class="btn btn-primary btn-sm mb-2" type="submit" name="treatment">Submit</button>
					<button class="btn btn-primary btn-sm mb-2" type="button"
						onClick='location.href="http://localhost:8080/hospital"'>Return</button>
				</div>
			</div>
		</form>


	</div>

</body>
</html>