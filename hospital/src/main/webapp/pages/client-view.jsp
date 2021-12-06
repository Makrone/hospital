<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>

		<hr>
		</hr>
		</head>
		<body>


			<div class="panel panel-default">
				<div class="panel-heading">
					<header class="panel-title">
						<div class="text-center">
							<strong> Client office </strong>
						</div>
					</header>
				</div>
				<div class="panel-body">
					<div class="text-center" id="author">
						<img
							src="http://s1.iconbird.com/ico/0612/practika/w256h2561339698323user.png"
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
					<!-- 	Add money func	 -->
					<script type="text/javascript">
						function print_summa() {
							var summa = document.getElementById('money').value;

							document.getElementById('text_summa').innerHTML = 'Amount '
									+ summa + 'usd.';
						}
					</script>

					<form action="page.php" method="POST">
						<input type="text" id="amount" name="amount" value="0"
							onkeyup="print_summa();">
					</form>
					<div id="text_summa"></div>


					<div>
						<h3>Your details:</h3>
						<p>First name - ${user.firstName}</p>
						<p>Last name - ${user.lastName}</p>
						<p>Phone - ${user.phone}</p>
						<p>Email - ${user.email}</p>
						<p>Created - ${user.created}</p>
						<p>Money - ${user.money}</p>
						<p>Money - .print_summa</p>

					</div>
				</div>

			</div>



			<!-- show service button -->
			<div class="btn-group pull-right">
				<form class="navbar-form pull-right" action="main" method="POST">
					<input type="hidden" name="action" value="service" />
					<button class="btn btn-sm btn-default" type="submit">
						<i class="glyphicon glyphicon-star"></i> Show All Services
					</button>
				</form>
			</div>

			<div class="footer">
				<input type="hidden" name="action" value="addTreatment" />
				<div class="btnfirst">
					<button class="btn btn-access" type="submit" name="registration">Make
						an appointment</button>
				</div>
			</div>
			<form action="http://localhost:8080/hospital/pages/service.jsp">
				<input type="submit" value="Select the available procedure" />
			</form>
		</body>
</html>