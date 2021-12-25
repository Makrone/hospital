<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/timeline.css" />

</head>
<body>
	<div class="collapse-navbar">
		<div class="float-left">
			<a class="navbar-logo" href=""><img
				src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
				height="50"> </a>
		</div>
	</div>
	<div class="float-right">
		<div class="btn-group" role="group" aria-label="Basic example">
			<form action="main" method="POST">
				<input type="hidden" name="action" value="go-to-page" /> <input
					type="hidden" name="page" value="/pages/login.jsp">
				<button class="btn btn-primary btn-sm" type="submit">Sign
					in</button>
			</form>
		</div>

		<div class="btn-group" role="group" aria-label="Basic example">
			<form action="main" method="POST">
				<input type="hidden" name="action" value="go-to-page" /> <input
					type="hidden" name="page" value="/pages/registration.jsp">
				<button class="btn btn-primary btn-sm" type="submit">Registration</button>
			</form>
		</div>
	</div>

	<hr />


	<div class="navbar navbar-expand-lg navbar-light bg-light">
		<ul class="navbar-brand">
			<li class="nav-item"><a
				class="nav-item-child nav-item-hover active" href="index.jsp">Main</a></li>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="${pageContext.request.contextPath}/pages/about.jsp">About
					us</a></li>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="${pageContext.request.contextPath}/pages/contact.jsp">Contacts</a></li>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="${pageContext.request.contextPath}/pages/certificates.jsp">Certificates</a></li>
		</ul>
	</div>
	<div class="row">
		<h2>MCR Center capabilities</h2>

		<div class="col-md-3">
			<div class="collapse-navbar">
				<a class="navbar-logo" href=""><img
					src="https://www.lode.by/images/cache/ec1/5703c18fdeb81ace2af0d86e004317e7.png"
					width="150" height="100"> </a>
			</div>
			<p>
				<b>Adult diagnostic department</b>
			</p>
		</div>
		<div class="col-md-3">
			<div class="collapse-navbar">
				<a class="navbar-logo" href=""><img
					src="https://www.lode.by/images/cache/19c/77aa249a199be6ea44ec8dec94691039.png"
					width="150" height="100"> </a>
			</div>
			<p>
				<b>Children's diagnostic department</b>
			</p>
		</div>
		<div class="col-md-3">
			<div class="collapse-navbar">
				<a class="navbar-logo" href=""><img
					src="https://www.lode.by/images/cache/e53/2108cb416e06807df9a6aa123a2154c3.png"
					width="150" height="100"> </a>
			</div>
			<p>
				<b>Department of CT densitometry</b>
			</p>
		</div>
		<div class="col-md-3">
			<div class="collapse-navbar">
				<a class="navbar-logo" href=""><img
					src="https://www.lode.by/images/cache/e30/f73f7a7a2b6d849eca16ba5c50769863.png"
					width="150" height="100"> </a>
			</div>
			<p>
				<b>Department of MRI densitometry</b>
			</p>
		</div>
	</div>
	<hr />
	<!-- FEEDBACK -->

	<hr>
	<h1>Feedback</h1>

	<div class="container">

		<ul class="timeline">

			<li>
				<div class="left-side">
					<div class="timeline-block">
						<span class="timeline-name">Oleg</span> <span
							class="timeline-date"><span class="end-time">2021-11-02</span></span>
					</div>
					<div class="timeline-description">I would like to thank to
						the neurologist Oksana Ross. An excellent specialist, A
						professional in his work. Kind and attentive. With respect, Oleg
						V. Shushkevich.</div>
				</div>
			</li>

			<li>
				<div class="right-side">
					<div class="timeline-block">
						<span class="timeline-name">Mikhail</span> <span
							class="timeline-date"><span class="end-time">2021-08-27</span></span>
					</div>
					<div class="timeline-description">I want to express my
						gratitude to to the therapist Olga Alexandrovna Nikikyuk!
						Responsive, attentive, disposing specialist!!! Listened to her,
						examined her, explained, prescribed treatment, gave
						recommendations.</div>
				</div>
			</li>

			<li>
				<div class="left-side">
					<div class="timeline-block">
						<span class="timeline-name">Julia</span> <span
							class="timeline-date"><span class="end-time">2021-04-13</span></span>
					</div>
					<div class="timeline-description">I would like to express my
						gratitude I would like to express my gratitude to Valentina
						Pavlovna Fomenkova, an ultrasound doctor, for her sensitive
						Valentina Pavlovna, a sensitive treatment to patients, very
						carefully and carefully examined, and Very carefully and carefully
						examined and gave a number of recommendations, was very pleased. I
						recommend it to everyone!</div>
				</div>
			</li>

			<li>
				<div class="right-side">
					<div class="timeline-block">
						<span class="timeline-name">Mari</span> <span
							class="timeline-date"><span class="end-time">2021-02-19</span></span>
					</div>
					<div class="timeline-description">I would like to express my
						I would like to express my gratitude to the wonderful doctor
						Rimashevsky A.G. Thank you very much for your patience and help in
						this difficult situation. The treatment I'm very grateful to you,
						your counseling has helped not only to solve the problem but to
						calm my nerves and make me feel better. Your counseling has helped
						not only to solve the problem, but also to calm me down and make
						me confident in achieving a good result of the treatment. ...and
						make us confident in achieving the good result of the treatment.</div>
				</div>
			</li>

		</ul>

	</div>
	<!-- ./container -->
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