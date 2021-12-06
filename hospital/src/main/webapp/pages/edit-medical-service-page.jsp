<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>

		<form class="form register-form" method="POST" action="main">

			<legend>
				<h2>
					<a class="brand">Update Service</a>
				</h2>
				<hr>
			</legend>
			<div class="body">
				<!--  Name  -->
				<div class="control-group">
					<label for="name"> Name </label> <input type="text" id="name"
						value="${medicalService.name}" required name="name"
						data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Name should start with a letter and consist of 1-20 characters"
						placeholder="Name" />
				</div>
				<!--  Description  -->
				<div class="control-group">
					<label for="description"> Description </label> <input type="text"
						value="${medicalService.description}" id="description" required
						name="description" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Description should start with a letter and consist of 1-20 characters"
						placeholder="Description" />
				</div>
				<!--  Cost  -->
				<div class="control-group">
					<label for="cost"> Cost </label> <input type="text" id="cost"
						value="${medicalService.cost}" required name="cost"
						data-validation="custom" data-validation-regexp="{1,99999999}$"
						data-validation-help="Cost should start with a letter and consist of 1-20 characters"
						placeholder="Cost" />
				</div>
			</div>
			<div class="footer">
				<input type="hidden" name="action" value="update-medical-service" />
				<input type="hidden" name="id" value="${medicalService.id}" />
				<div class="btnfirst">
					<button class="btn btn-access" type="submit">Update</button>
					<button class="btn btn-access" type="button"
						onClick='location.href="http://localhost:8080/hospital"'>Return</button>
				</div>
			</div>
		</form>


	</div>

</body>
</html>