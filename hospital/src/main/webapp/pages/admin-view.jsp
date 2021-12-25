<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator office</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<a class="navbar-logo"
			href="${pageContext.request.contextPath}/index.jsp"><img
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
								<button class="btn btn-danger btn-sm" type="submit" name="logout">Log
									out</button>
							</div>
						</form>
					</div>
				</div>
				<div class="text-center">
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
				<button class="btn btn-primary btn-sm mb-2"  type="submit" name="show-all-clients">Show
					client</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-medical-services" />
			<div class="btnfirs">
				<button class="btn btn-primary btn-sm mb-2" type="submit"
					name="show-all-medical-services">Show medical services</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-page" /> <input
				type="hidden" name="page" value="/pages/create-new-service.jsp">
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" type="submit"
					name="add-medical-services">Add medical service</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-treatment" />
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" type="submit"
					name="show-all-treatment">Show all treatments</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-page" /> <input
				type="hidden" name="page" value="/pages/create-new-treatment.jsp">
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" type="submit" name="add-treatment">Add
					treatment</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="show-all-medicaments" />
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" type="submit"
					name="show-all-medicaments">Show all medicaments</button>
			</div>
		</form>

		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-page" /> <input
				type="hidden" name="page" value="/pages/create-new-medicament.jsp">
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" type="submit" name="add-medicament">Add
					medicament</button>
			</div>
		</form>


	</div>



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