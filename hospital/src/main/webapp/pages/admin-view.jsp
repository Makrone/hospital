<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator office</title>
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
						<a class="navbar-logo"><img src="${pageContext.request.contextPath}/img/logo.png" width="150"
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
		</div>
	</nav>
	<!--================Header Menu Area =================-->
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-success">${errorMessage}</div>
	</c:if>
	
	<div class="page-content page-container" id="page-content">
		<div class="padding">
			<div class="row container d-flex justify-content-center">
				<div class="col-xl-12 col-md-12">
					<div class="card user-card-full">
						<div class="row m-l-0 m-r-0">
							<div class="col-sm-4 bg-c-lite-green user-profile">
								<div class="card-block text-center text-white">
									<div class="m-b-25">
										<img src="img/adminphoto.png" class="img-radius"
											alt="User-Profile-Image">
									</div>
									<h4 class="f-w-600">Welcome ${user.firstName} !</h4>
									<p>Admin office</p>
									<i
										class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
									<div class="footer">
										<form class="navbar-form pull-right" action="main"
											method="POST">
											<input type="hidden" name="action" value="logout" />
											<div class="btnfirst">
												<button class="btn btn-danger btn-sm" type="submit"
													name="logout">Log out</button>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="card-block">
									<h4 class="text-info m-b-20 p-b-5 b-b-default f-w-600">Information</h4>
									<div class="row">
										<div class="col-sm-6">
											<p class="text-info m-b-10 f-w-600">First name</p>
											<h6 class="text-black f-w-400">${user.firstName}</h6>
										</div>
										<div class="col-sm-6">
											<p class="text-info m-b-10 f-w-600">Last Name</p>
											<h6 class="text-black f-w-400">${user.lastName}</h6>
										</div>
										<div class="col-sm-6">
											<p class="text-info m-b-10 f-w-600">Email</p>
											<h6 class="text-black f-w-400">${user.email}</h6>
										</div>
										<div class="col-sm-6">
											<p class="text-info m-b-10 f-w-600">Phone</p>
											<h6 class="text-black f-w-400">${user.phone}</h6>
										</div>
									</div>
									<h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Function</h6>
									<div class="row">
										<div class="btn-group" role="group" aria-label="Basic example">
											<form class="navbar-form pull-right" action="main"
												method="POST">
												<input type="hidden" name="action" value="show-all-clients" />
												<div class="btnfirst">
													<button class="btn btn-outline-info btn-sm mb-2 mr-1"
														type="submit" name="show-all-clients">Show client</button>
												</div>
											</form>
											<form class="navbar-form pull-right" action="main"
												method="POST">
												<input type="hidden" name="action"
													value="show-all-medical-services" />
												<div class="btnfirs">
													<button class="btn btn-outline-info btn-sm mb-2 mr-1"
														type="submit" name="show-all-medical-services">Show
														medical services</button>
												</div>
											</form>
											<form class="navbar-form pull-right" action="main"
												method="POST">
												<input type="hidden" name="action"
													value="show-all-medicaments" />
												<div class="btnfirst">
													<button class="btn btn-outline-info btn-sm mb-2 mr-1"
														type="submit" name="show-all-medicaments">Show
														all medicaments</button>
												</div>
											</form>
										</div>
									</div>
									<div class="row">
										<div class="btn-group" role="group" aria-label="Basic example">
											<form class="navbar-form pull-right" action="main"
												method="POST">
												<input type="hidden" name="action" value="go-to-page" /> <input
													type="hidden" name="page"
													value="/pages/create-new-treatment.jsp">
												<div class="btnfirst">
													<button class="btn btn-outline-info btn-sm mb-2 mr-1"
														type="submit" name="add-treatment">Add treatment</button>
												</div>
											</form>

											<form class="navbar-form pull-right" action="main"
												method="POST">
												<input type="hidden" name="action" value="go-to-page" /> <input
													type="hidden" name="page"
													value="/pages/create-new-service.jsp">
												<div class="btnfirst">
													<button class="btn btn-outline-info btn-sm mb-2 mr-1"
														type="submit" name="add-medical-services">Add
														medical service</button>
												</div>
											</form>
											<form class="navbar-form pull-right" action="main"
												method="POST">
												<input type="hidden" name="action" value="go-to-page" /> <input
													type="hidden" name="page"
													value="/pages/create-new-medicament.jsp">
												<div class="btnfirst">
													<button class="btn btn-outline-info btn-sm mb-2 mr-1"
														type="submit" name="add-medicament">Add
														medicament</button>
												</div>
											</form>

										</div>
									</div>
								</div>
								<ul class="social-link list-unstyled m-t-40 m-b-10">
									<li><a href="#!" data-toggle="tooltip"
										data-placement="bottom" title=""
										data-original-title="facebook" data-abc="true"><i
											class="mdi mdi-facebook feather icon-facebook facebook"
											aria-hidden="true"></i></a></li>
									<li><a href="#!" data-toggle="tooltip"
										data-placement="bottom" title="" data-original-title="twitter"
										data-abc="true"><i
											class="mdi mdi-twitter feather icon-twitter twitter"
											aria-hidden="true"></i></a></li>
									<li><a href="#!" data-toggle="tooltip"
										data-placement="bottom" title=""
										data-original-title="instagram" data-abc="true"><i
											class="mdi mdi-instagram feather icon-instagram instagram"
											aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





	<!-- Section: info and button -->

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