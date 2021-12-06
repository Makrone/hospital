<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator office</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>

		<hr />


		<div class="panel panel-default">
			<div class="panel-heading">
				<header class="panel-title">
					<div class="text-center">
						<strong>Administrator office </strong>
					</div>
				</header>
			</div>
			<div class="panel-body">
				<div class="text-center" id="author">
					<img src="https://cropas.by/wp-content/uploads/2015/05/admin.jpg"
						width="150" height="150">
					<h2>Welcome, ${user.firstName}!</h2>

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
					<h3>Your information:</h3>

					<p>First name - ${user.firstName}</p>
					<p>Last name - ${user.lastName}</p>
					<p>Phone - ${user.phone}</p>
					<p>Email - ${user.email}</p>
				</div>
			</div>
		</div>
				<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-clients" />
			<div class="btnfirst">
				<button class="btn btn-access" type="submit"
					name="show-all-clients">Show client</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-medical-services" />
			<div class="btnfirst">
				<button class="btn btn-access" type="submit"
					name="show-all-medical-services">Show medical services</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-page" /> <input
				type="hidden" name="page" value="/pages/create-new-service.jsp">
			<div class="btnfirst">
				<button class="btn btn-access" type="submit"
					name="add-medical-services">Add medical service</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-treatment" />
			<div class="btnfirst">
				<button class="btn btn-access" type="submit"
					name="show-all-treatment">Show all treatments</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-page" /> <input
				type="hidden" name="page" value="/pages/create-new-treatment.jsp">
			<div class="btnfirst">
				<button class="btn btn-access" type="submit" name="add-treatment">Add
					treatment</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-medicaments" />
			<div class="btnfirst">
				<button class="btn btn-access" type="submit"
					name="show-all-medicaments">Show all medicaments</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-page" /> <input
				type="hidden" name="page" value="/pages/create-new-medicament.jsp">
			<div class="btnfirst">
				<button class="btn btn-access" type="submit" name="add-medicament">Add
					medicament</button>
			</div>
		</form>

	</div>



</body>
</html>