<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor office</title>
</head>
<body>
<div class="container">
	<a class="navbar-logo" href="http://localhost:8080/hospital"><img
		src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
		height="50"> </a>

	<hr>
	</hr>


	<div class="panel panel-default">
		<div class="panel-heading">
			<header class="panel-title">
				<div class="text-center">
					<strong>Doctor office </strong>
				</div>
			</header>
		</div>
		<div class="panel-body">
			<div class="text-center" id="author">
				<img src="https://cropas.by/wp-content/uploads/2015/05/admin.jpg"
					width="150" height="150">
				<h2>Добро пожаловать, ${user.firstName}!</h2>

				<div class="footer">
					<form class="navbar-form pull-right" action="main" method="POST">
						<input type="hidden" name="action" value="logout" />
						<div class="btnfirst">
							<button class="btn btn-access" type="submit" name="logout">Log
								out</button>
						</div>
					</form>
				</div>
			</div>
			<div>
				<h3>Ваши данные:</h3>
				<!-- <input type="text" name="username" id="username" value="" class="wide"> -->

				<p>First name - ${user.firstName}</p>
				<p>Last name - ${user.lastName}</p>
				<p>Phone - ${user.phone}</p>
				<p>Email - ${user.email}</p>
				<p>Created - ${user.created}</p>
			</div>
		</div>
		<h5>Doctors on clinic</h5>
		<p>${usertype.DOCTOR}</p>
	</div>
	
	<div class="btn-group pull-right">
			<form class="navbar-form pull-right" action="main" method="POST">
				<input type="hidden" name="action" value="show-all-doctors" />
				<button class="btn btn-sm btn-default" type="submit">
					<i class="glyphicon glyphicon-star"></i> Show Doctors in clinic
				</button>
			</form>
		</div>

	<div class="footer">
		<input type="hidden" name="action" value="addTreatment" />
		<div class="btnfirst">
			<button class="btn btn-access" type="submit" name="registration">Add
				Treatment</button>
		</div>
		<div class="btn-group pull-right">
			<form class="navbar-form pull-right" action="main" method="POST">
				<input type="hidden" name="action" value="show-all-medicaments" />
				<button class="btn btn-sm btn-default" type="submit">
					<i class="glyphicon glyphicon-star"></i> Show All Medicaments
				</button>
			</form>
		</div>
	</div>
</body>
</html>