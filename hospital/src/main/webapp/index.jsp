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
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/slider.css" />
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
			<div class="col-md-2">
				<div class="float-right pull-right">
					<div class="btn-group" role="group" aria-label="Basic example">
						<form action="main" method="POST">
							<input type="hidden" name="action" value="go-to-page" /> <input
								type="hidden" name="page" value="/pages/login.jsp">
							<button class="btn btn-outline-primary btn-sm" type="submit">Sign
								in</button>
						</form>
					</div>

					<div class="btn-group" role="group" aria-label="Basic example">
						<form action="main" method="POST">
							<input type="hidden" name="action" value="go-to-page" /> <input
								type="hidden" name="page" value="/pages/registration.jsp">
							<button class="btn btn-outline-primary btn-sm" type="submit">Registration</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!--================Header Menu Area =================-->

	<!--================ Home Banner Area =================-->
	<div id="carouselExampleSlidesOnly" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="img/home.jpg" alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h1>We Care for Your Health Every Moment</h1>
					<p>If you are looking at blank cassettes on the web, you may be
						very confused at the difference in price You may see some for as
						low as each.</p>

					<div class="bform py-5" role="group" aria-label="Basic example">
						<form action="main" method="POST">
							<input type="hidden" name="action" value="go-to-page" /> <input
								type="hidden" name="page" value="/pages/registration.jsp">
							<button
								class="btn btn-block btn-danger-gradiant text-white border-0"
								type="submit">Registration</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!--================ Home Banner Area =================-->

	<!--================ Start slider  Area =================-->
	<!-- Header -->
	<header class=" text-center py-2 mb-3">
		<div class="container"></div>
	</header>
	<header class="text-center">
		<div class="container">
			<h2>Meet the Team</h2>
		</div>
	</header>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<!-- Team Member 1 -->
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-0 shadow">
					<img src="img/t1.jpg" class="card-img-top" alt="...">
					<div class="card-body text-center">
						<h5 class="card-title mb-0">Alex Soloduha</h5>
						<div class="card-text text-black-50">Ultrasonographer</div>
					</div>
				</div>
			</div>
			<!-- Team Member 2 -->
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-0 shadow">
					<img src="img/t2.jpg" class="card-img-top" alt="...">
					<div class="card-body text-center">
						<h5 class="card-title mb-0">Angelina Novikava</h5>
						<div class="card-text text-black-50">Therapist</div>
					</div>
				</div>
			</div>
			<!-- Team Member 3 -->
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-0 shadow">
					<img src="img/t3.jpg" class="card-img-top" alt="...">
					<div class="card-body text-center">
						<h5 class="card-title mb-0">Danik Radetski</h5>
						<div class="card-text text-black-50">Surgeon</div>
					</div>
				</div>
			</div>
			<!-- Team Member 4 -->
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-0 shadow">
					<img src="img/t4.jpg" class="card-img-top" alt="...">
					<div class="card-body text-center">
						<h5 class="card-title mb-0">Maria Plahotina</h5>
						<div class="card-text text-black-50">Neurologist</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	<!--================ Finish slider Area =================-->

	<!-- FEEDBACK -->

	<hr>
	<div class="text-center">
		<h2>Feedback</h2>
	</div>
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