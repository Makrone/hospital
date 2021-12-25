<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
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
		</div>

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
									<button class="btn btn-danger btn-sm mb-1" type="submit" name="logout">Log
										out</button>
								</div>
							</form>
						</div>
					</div>
					<div class="text-center">
						<h3>Your details:</h3>
						<p>First name - ${user.firstName}</p>
						<p>Last name - ${user.lastName}</p>
						<p>Phone - ${user.phone}</p>
						<p>Email - ${user.email}</p>
						<p>Created - ${user.created}</p>

					</div>
				</div>

			</div>



			<!-- show service button -->
			<div class="btn-group pull-right">
				<form class="navbar-form pull-right" action="main" method="POST">
					<input type="hidden" name="action" value="show-service-client" />
					<button class="btn btn-primary btn-sm mb-1" type="submit">
						<i class="glyphicon glyphicon-star"></i> Show All Services
					</button>
				</form>
			</div>

			<form class="navbar-form pull-right" action="main" method="POST">
				<input type="hidden" name="action" value="show-all-doctors" />
				<div class="btnfirst">
					<button class="btn btn-primary btn-sm mb-1" type="submit">Make an
						appointment</button>
				</div>
			</form>			
			
			<div class="btn-group pull-right">
				<form class="navbar-form pull-right" action="main" method="POST">
					<input type="hidden" name="action" value="show-client-treatments" /> <input
						type="hidden" name="clientId" value="${user.id}" />
					<button class="btn btn-primary mb-2" type="submit">
						<i class="glyphicon glyphicon-star"></i> Show My Conclusion
					</button>
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