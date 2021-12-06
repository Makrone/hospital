
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hospital registration</title>
<meta name="registration" content="">
<meta name="author" content="">
<meta charset="UTF-8">
</head>
<body>


	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>

		<form class="form register-form" method="POST" action="main">
			<legend>
				<h2>
					<a class="brand">Registration</a>
				</h2>
				<hr>
				</hr>
			</legend>
			<div class="body">
				<!--  First name validation -->
				<div class="control-group">
					<label for="first_name"> First name </label> <input type="text"
						id="first_name" required name="first_name"
						data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="First name should start with a letter and consist of 1-20 characters"
						placeholder="First name" />
				</div>
				<!--  Last name validation -->
				<div class="control-group">
					<label for="last_name"> Last name </label> <input type="text"
						id="last_name" required name="last_name" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Last name should start with a letter and consist of 1-20 characters"
						placeholder="Last name" />
				</div>
				<!--  Gender -->
				<div class="control-group">
					<p>
						<label for="gender"> Gender </label> <select name="gender"
							id="gender">
							<option value="MALE">Male</option>
							<option value="FEMALE">Female</option>
						</select>

					</p>
				</div>
				<!--  User Type  -->
				<div class="control-group">
					<p>
						<label for="user_type"> User Type </label> <select
							name="user_type" id="user_type">
							<option value="CLIENT">Client</option>
							<option value="ADMIN">Admin</option>
							<option value="DOCTOR">Doctor</option>
						</select>

					</p>
				</div>

				<!--  Phone name validation -->
				<div class="control-group">
					<label for="phone"> Phone </label> <input type="text" id="phone"
						required name="phone" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{7,20}$"
						data-validation-help="Phone should start with a letter and consist of 1-20 characters"
						placeholder="Phone " />
				</div>
				<!--  Email validation -->
				<div class="control-group">
					<label for="email"> Email </label> <input type="text" id="email"
						required name="email" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Email should start with a letter and consist of 1-20 characters"
						placeholder="Email" />
				</div>

				<!--  Login validation -->
				<div class="control-group">
					<label for="login"> User name </label> <input type="text"
						id="login" required name="login" data-validation="custom"
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
			</div>
			<div class="footer">
				<input type="hidden" name="action" value="registration" />
				<div class="btnfirst">
					 <button class="btn btn-access" type="submit" name="registration">Submit</button>
					 <button class="btn btn-access" type="button" onClick='location.href="http://localhost:8080/hospital"'>Return</button>
				</div>
			</div>

		</form>


	</div>
	<footer>
		<hr>
		</hr>

	</footer>
</body>
</html>