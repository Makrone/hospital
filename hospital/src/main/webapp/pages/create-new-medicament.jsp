<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create medicament</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/timeline.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/profile.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/registration.css" />
</head>
<body>
	<!--================Header Menu Area =================-->
	<nav>
		<div class="navbar navbar-expand-lg navbar-light bg-light"
			style="background-color: #00CED1;">
			<div class="col-md-6">
				<div class="collapse-navbar">
					<div class="float-left">
						<a class="navbar-logo"><img src="img/logo.png" width="150"
							height="50"> </a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<ul class="navbar-nav">
					<li class="navbar-brand"><a
						class="nav-item-child nav-item-hover"
						href="${pageContext.request.contextPath}/index.jsp">Main</a></li>
					<li class="navbar-brand"><a
						class="nav-item-child nav-item-hover"
						href="${pageContext.request.contextPath}/pages/about.jsp">About
							us</a></li>
					<li class="navbar-brand"><a
						class="nav-item-child nav-item-hover"
						href="${pageContext.request.contextPath}/pages/contact.jsp">Contacts</a></li>
					<li class="navbar-brand"><a
						class="nav-item-child nav-item-hover"
						href="${pageContext.request.contextPath}/pages/certificates.jsp">Certificates</a></li>
				</ul>
			</div>
			<form class="navbar-form pull-left" action="main" method="POST">
				<input type="hidden" name="action" value="logout" />
				<div class="btnfirst">
					<button class="btn btn-outline-danger btn-sm mb-2 mr-1"
						style="float: right;" type="submit" name="logout">Log out</button>
				</div>
			</form>
			<form class="navbar-form pull-right" action="main" method="POST">
				<input type="hidden" name="action" value="go-to-profile" />
				<div class="btnfirst">
					<button class="btn btn-outline-primary btn-sm mb-2 mr-1"
						style="float: right;" type="submit" name="go-to-profile">Profile</button>
				</div>
			</form>
		</div>
	</nav>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<!--================ start  =================-->

	<div class="bform py-5">
		<!-- Row -->
		<div class="row">
			<div class="container">
				<div class="col-lg-6 align-justify-center pr-4 pl-0 contact-form">
					<div class="">
						<h2 class="mb-3 font-weight-light">Create new Medicament</h2>
						<h6 class="subtitle font-weight-normal"></h6>
						<form class="mt-3">
							<div class="row">
								<div class="col-lg-12">
									<div class="form-group">
										<input class="form-control" type="text" id="name" required
											name="name" data-validation="custom"
											data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
											data-validation-help="Name should start with a letter and consist of 1-20 characters"
											placeholder="Name" />
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<input class="form-control" type="text" id="description"
											required name="description" data-validation="custom"
											data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
											data-validation-help="Description should start with a letter and consist of 1-20 characters"
											placeholder="Description" />
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<input class="form-control" type="text" id="cost" required
											name="cost" data-validation="custom"
											data-validation-regexp="{1,99999999}$"
											data-validation-help="Cost should start with a letter and consist of 1-20 characters"
											placeholder="Cost" />
									</div>
								</div>
								<div class="col-lg-12">
									<div class="footer">
										<input type="hidden" name="action" value="add-medicament" />
										<div class="btnfirst">
											<button
												class="btn btn-md btn-block btn-danger-gradiant text-white border-0"
												type="submit" name="medicament">Save</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================Registration end  =================-->
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