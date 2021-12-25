
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hospital registration</title>
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
					<a>Registration</a>
				</h2>
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
					 <button class="btn btn-primary btn-sm mb-1" type="submit" name="registration">Submit</button>
					 <button class="btn btn-primary btn-sm mb-1" type="button" onClick='location.href="http://localhost:8080/hospital"'>Return</button>
				</div>
			</div>

		</form>


	</div>
	<footer>
		<hr />

	</footer>
</body>
<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">
	<!-- Section: Social media -->
	<section
		class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
		<!-- Left -->
		<div class="me-5 d-none d-lg-block">
			<span>Get connected with us on social networks:</span>
		</div>
		<!-- Left -->

		<!-- Right -->
		<div>
			<a href="https://www.instagram.com/makslytarevich/"
				class="me-4 text-reset"> <i class="fab fa-instagram"></i>
			</a> <a href="https://www.linkedin.com/in/maks-lytarevich-b7435620a/"
				class="me-4 text-reset"> <i class="fab fa-linkedin"></i>
			</a> <a href="https://github.com/Makrone/hospital"
				class="me-4 text-reset"> <i class="fab fa-github"></i>
			</a>
		</div>
		<!-- Right -->
	</section>
	<!-- Section: Social media -->

	<!-- Section: Links  -->
	<section class="">
		<div class="container text-center text-md-start mt-5">
			<!-- Grid row -->
			<div class="row mt-3">
				<!-- Grid column -->
				<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
					<!-- Content -->
					<h6 class="text-uppercase fw-bold mb-4">
						<i class="fas fa-gem me-3"></i>MCR Center
					</h6>
					<p>For almost 30 years of activity, the centers have received
						many awards in their field and most importantly - people's trust
						and recognition. "MRC" is among the most famous medical centers in
						the Republic of Belarus.</p>
				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
					<!-- Links -->
					<h6 class="text-uppercase fw-bold mb-4">Registration</h6>
					<p>
						<a
							href="${pageContext.request.contextPath}/pages/registration.jsp"
							class="text-reset">Registration</a>
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/pages/login.jsp"
							class="text-reset">Sign in</a>
					</p>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
					<!-- Links -->
					<h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
					<p>
						<a href="${pageContext.request.contextPath}/pages/index.jsp"
							class="text-reset">Main</a>
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/pages/about.jsp"
							class="text-reset">About us</a>
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/pages/contact.jsp"
							class="text-reset">Contact</a>
					</p>
					<p>
						<a
							href="${pageContext.request.contextPath}/pages/certificates.jsp"
							class="text-reset">Certificates</a>
					</p>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
					<!-- Links -->
					<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
					<p>
						<i class="fas fa-home me-3"></i> Minsk, Belarus 220039
					</p>
					<p>
						<i class="fas fa-envelope me-3"></i> infomlux.by@gmail.com
					</p>
					<p>
						<i class="fas fa-phone me-3"></i> + 375 29 111 28 28
					</p>
				</div>
				<!-- Grid column -->
			</div>
			<!-- Grid row -->
		</div>
	</section>
	<!-- Section: Links  -->

	<!-- Copyright -->
	<div class="text-center p-4"
		style="background-color: rgba(0, 0, 0, 0.05);">© 2021 Copyright:
	</div>
	<!-- Copyright -->
</footer>
<!-- Footer -->
</html>