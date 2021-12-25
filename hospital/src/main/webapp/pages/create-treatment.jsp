<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creating</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>

		<form class="form register-form" method="POST" action="main">
			<h2>
				<a class="brand">Create new Service</a>
			</h2>
			<hr />
			<div class="body">
				<!--  Name  -->
				<div class="control-group">
					<div>${doctor.firstName}${doctor.lastName}</div>
				</div>
				<input type="hidden" name="doctor_id" value="${doctor.id}" />

				<div class="control-group">
					<label for="dateTime"> Date and Time </label> <input
						type="datetime-local" id="dateTime" required name="date_time"
						placeholder="Choose date and type" />
				</div>
			</div>
			<div class="footer">
				<input type="hidden" name="action" value="create-treatment" />
				<div class="btnfirst">
					<button class="btn btn-access" type="submit">Submit</button>
					<button class="btn btn-access" type="button"
						onClick='location.href="http://localhost:8080/hospital"'>Return</button>
				</div>
			</div>
		</form>


	</div>

</body>
</html>