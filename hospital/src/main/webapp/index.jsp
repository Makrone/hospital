<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital</title>
<div>
	<div class="collapse-navbar">
		<a class="navbar-logo" href=""><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
	</div>
	<hr>
	</hr>

	<form action="${pageContext.request.contextPath}/pages/login.jsp"
		target="_blank">
		<button>Sign in</button>
	</form>
</div>


</head>
<body>
	<div class="menu-container">
		<ul class="navbar-nav">
			<li class="nav-item"><a
				class="nav-item-child nav-item-hover active" href="index.jsp">Main</a></li>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="${pageContext.request.contextPath}/pages/about.jsp">About
					us</a></li>
			<%-- <li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="${pageContext.request.contextPath}/pages/service.jsp">Services and prices </a></li> --%>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="recording.html">Make an appointment</a></li>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="${pageContext.request.contextPath}/pages/registration.jsp">Registration</a></li>
			<li class="nav-item"><a class="nav-item-child nav-item-hover"
				href="contact.html">Contacts</a></li>
		</ul>
	</div>
	
	<!-- List -->
	
	<dl>
		<hr>
		<h2>MCR Center capabilities</h2>
		<div class="collapse-navbar">
			<a class="navbar-logo" href=""><img
				src="https://www.lode.by/images/cache/ec1/5703c18fdeb81ace2af0d86e004317e7.png"
				width="150" height="100"> </a>
		</div>

		<dt>Adult diagnostic department</dt>
		<hr align="left" width="20%" size="5" color="#dddddd" />

		<div class="collapse-navbar">
			<a class="navbar-logo" href=""><img
				src="https://www.lode.by/images/cache/126/aecd49d5846eca65b595f8c4550eac68.png"
				width="150" height="100"> </a>
		</div>

		<dt>Adult Counseling Department</dt>
		<hr align="left" width="20%" size="5" color="#dddddd" />

		<div class="collapse-navbar">
			<a class="navbar-logo" href=""><img
				src="https://www.lode.by/images/cache/19c/77aa249a199be6ea44ec8dec94691039.png"
				width="150" height="100"> </a>
		</div>
		<dt>Children's diagnostic department</dt>
		<hr align="left" width="20%" size="5" color="#dddddd" />

		<div class="collapse-navbar">
			<a class="navbar-logo" href=""><img
				src="https://www.lode.by/images/cache/e53/2108cb416e06807df9a6aa123a2154c3.png"
				width="150" height="100"> </a>
		</div>
		<dt>Department of CT and MRI, CT densitometry</dt>
		<hr align="left" width="20%" size="5" color="#dddddd" />

		<div class="collapse-navbar">
			<a class="navbar-logo" href=""><img
				src="https://www.lode.by/images/cache/e30/f73f7a7a2b6d849eca16ba5c50769863.png"
				width="150" height="100"> </a>
		</div>
		<dt>Doctor visits at home. Home visits by pediatricians</dt>
		<hr align="left" width="20%" size="5" color="#dddddd" />

	</dl>
	
	<!-- FEEDBACK -->
	
	<hr>
	<h1>Feedback</h1>

	<style>
body {
	background: color:#212529)
}

.timeline {
	position: relative;
	width: 660px;
	margin: 0 auto;
	margin-top: 20px;
	padding: 1em 0;
	list-style-type: none;
}

.timeline:before {
	position: absolute;
	left: 50%;
	top: 0;
	content: ' ';
	display: block;
	width: 6px;
	height: 100%;
	margin-left: -3px;
	background: rgb(80, 80, 80);
	background: -moz-linear-gradient(top, rgba(80, 80, 80, 0) 0%,
		rgb(80, 80, 80) 8%, rgb(80, 80, 80) 92%, rgba(80, 80, 80, 0) 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(30,
		87, 153, 1)), color-stop(100%, rgba(125, 185, 232, 1)));
	background: -webkit-linear-gradient(top, rgba(80, 80, 80, 0) 0%,
		rgb(80, 80, 80) 8%, rgb(80, 80, 80) 92%, rgba(80, 80, 80, 0) 100%);
	background: -o-linear-gradient(top, rgba(80, 80, 80, 0) 0%,
		rgb(80, 80, 80) 8%, rgb(80, 80, 80) 92%, rgba(80, 80, 80, 0) 100%);
	background: -ms-linear-gradient(top, rgba(80, 80, 80, 0) 0%,
		rgb(80, 80, 80) 8%, rgb(80, 80, 80) 92%, rgba(80, 80, 80, 0) 100%);
	background: linear-gradient(to bottom, rgba(80, 80, 80, 0) 0%,
		rgb(80, 80, 80) 8%, rgb(80, 80, 80) 92%, rgba(80, 80, 80, 0) 100%);
	z-index: 5;
}

.timeline li {
	padding: 1em 0;
}

.timeline li:after {
	content: "";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
}

.left-side {
	position: relative;
	width: 300px;
	float: left;
	text-align: right;
}

.right-side {
	position: relative;
	width: 300px;
	float: right;
}

.timeline-block {
	position: relative;
	display: inline-block;
	text-align: center;
}

.timeline-name {
	position: relative;
	display: inline;
	background: rgb(248, 248, 248);
	padding: 6px 10px;
	border-radius: 5px;
	font-weight: 600;
	text-align: left;
}

.left-side .timeline-name {
	-webkit-box-shadow: -1px 1px 1px rgba(0, 0, 0, 0.15), 0 0 1px
		rgba(0, 0, 0, 0.15);
	-moz-box-shadow: -1px 1px 1px rgba(0, 0, 0, 0.15), 0 0 1px
		rgba(0, 0, 0, 0.15);
	box-shadow: -1px 1px 1px rgba(0, 0, 0, 0.15), 0 0 1px
		rgba(0, 0, 0, 0.15);
}

.right-side .timeline-name {
	-webkit-box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.15), 0 0 1px
		rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.15), 0 0 1px
		rgba(0, 0, 0, 0.15);
	box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.15), 0 0 1px rgba(0, 0, 0, 0.15);
}

.left-side .timeline-name:before, .right-side .timeline-name:before {
	position: absolute;
	top: 50%;
	right: -40px;
	content: ' ';
	display: block;
	width: 12px;
	height: 12px;
	margin-top: -10px;
	background: #fff;
	border-radius: 10px;
	border: 4px solid rgb(255, 80, 80);
	z-index: 10;
}

.right-side .timeline-name:before {
	left: -40px;
}

.left-side .timeline-name:after {
	content: "";
	position: absolute;
	left: 100%;
	top: 50%;
	height: 0;
	width: 0;
	margin-top: -8px;
	border: solid transparent;
	border-left-color: rgb(248, 248, 248);
	border-width: 8px;
	pointer-events: none;
}

.right-side .timeline-name:after {
	content: "";
	position: absolute;
	right: 100%;
	top: 50%;
	height: 0;
	width: 0;
	margin-top: -8px;
	border: solid transparent;
	border-right-color: rgb(248, 248, 248);
	border-width: 8px;
	pointer-events: none;
}

.timeline-date {
	display: inline;
	line-height: 1em;
	font-size: 0.66666em;
	color: rgb(250, 80, 80);
	vertical-align: middle;
}

.left-side .timeline-date {
	float: left;
}

.right-side .timeline-date {
	float: right;
}

.end-time {
	display: inline-block;
	padding: 4px 6px;
	background: rgb(248, 248, 248);
}

.timeline-description {
	margin: 1em 0.75em 0 0;
	font-size: 0.77777em;
	font-style: italic;
	line-height: 1.5em;
}

.right-side .timeline-description {
	margin: 1em 0 0 0.75em;
}

@media screen and (max-width: 660px) {
	.timeline {
		width: 100%;
		padding: 4em 0 1em 0;
	}
	.timeline li {
		padding: 2em 0;
	}
	.left-side, .right-side {
		float: none;
		width: 100%;
		text-align: center;
	}
	.timeline-block {
		text-align: center;
	}
	.timeline-name {
		background: rgb(255, 255, 255);
		z-index: 15;
	}
	.left-side .timeline-name:before, .right-side .timeline-name:before {
		position: absolute;
		top: -30px;
		left: 50%;
		content: ' ';
		display: block;
		width: 12px;
		height: 12px;
		margin-left: -9px;
		background: #fff;
		border-radius: 10px;
		border: 4px solid rgb(255, 80, 80);
		z-index: 10;
	}
	.left-side .timeline-name:after, .right-side .timeline-name:after {
		content: "";
		position: absolute;
		left: 50%;
		top: -8px;
		height: 0;
		width: 0;
		margin-left: -8px;
		border: solid transparent;
		border-bottom-color: rgb(255, 255, 255);
		border-width: 8px;
		pointer-events: none;
	}
	.timeline-date {
		display: block;
		position: relative;
		margin: 4px 0 0 0;
		z-index: 14;
	}
	.left-side .timeline-date {
		float: none;
	}
	.right-side .timeline-date {
		float: none;
	}
	.timeline-description {
		position: relative;
		margin: 1em 0 0 0;
		padding: 1em;
		background: rgb(245, 245, 245);
		-webkit-box-shadow: 0 0 1px rgba(0, 0, 0, 0.20);
		-moz-box-shadow: 0 0 1px rgba(0, 0, 0, 0.20);
		box-shadow: 0 0 1px rgba(0, 0, 0, 0.20);
		z-index: 15;
	}
	.left-side .timeline-description, .right-side .timeline-description {
		position: relative;
		margin: 1em 1em 0 1em;
		padding: 1em;
		z-index: 15;
	}
}

@media screen and (min-width: 400px ) and ( max-width: 660px) {
	.left-side .timeline-description, .right-side .timeline-description {
		margin: 1em 4em 0 4em;
	}
}
</style>
	<div class="container">

		<ul class="timeline">

			<li>
				<div class="left-side">
					<div class="timeline-block">
						<span class="timeline-name">Олег Викторович</span> <span
							class="timeline-date"><span class="end-time">2021-11-02</span></span>
					</div>
					<div class="timeline-description">Хочу выразить благодарность
						неврологу, Росс Оксане Сергеевне. Отличный специалист,
						профессионал своего дела. Добрая, внимательная. С уважением,
						Шушкевич Олег Викторович.</div>
				</div>
			</li>

			<li>
				<div class="right-side">
					<div class="timeline-block">
						<span class="timeline-name">Меренков Михаил</span> <span
							class="timeline-date"><span class="end-time">2021-08-27</span></span>
					</div>
					<div class="timeline-description">Хочу выразить благодарность
						тарапевту Никикюк Ольге Александровне!!! Отзывчивый, внимательный,
						располагающий к себе специалист!!! Выслушала, осмотрела,
						объяснила, назначила лечение, дала рекомендации.</div>
				</div>
			</li>

			<li>
				<div class="left-side">
					<div class="timeline-block">
						<span class="timeline-name">Новикова Юлия</span> <span
							class="timeline-date"><span class="end-time">2021-04-13</span></span>
					</div>
					<div class="timeline-description">Хотела бы выразить
						благодарность врачу УЗИ Фоменковой Валентине Павловне,за чуткое
						обращение к пациентам,очень внимательно и бережно провела осмотр,а
						так же дала ряд рекомендаций,осталась очень довольна.Рекомендую
						всем!</div>
				</div>
			</li>

			<li>
				<div class="right-side">
					<div class="timeline-block">
						<span class="timeline-name">Жилинская Мария</span> <span
							class="timeline-date"><span class="end-time">2021-02-19</span></span>
					</div>
					<div class="timeline-description">Хочу выразить свою
						благодарность замечательному врачу Римашевскому А.Г. Огромное
						спасибо за Ваше терпение и помощь в сложной ситуации. Лечение
						оказалось эффективным, а Ваши консультации помогли не только
						решить проблему,но и успокоить, предать уверенность в достижении
						хорошего результата в лечении.</div>
				</div>
			</li>

		</ul>

	</div>
	<!-- ./container -->
</body>
</html>