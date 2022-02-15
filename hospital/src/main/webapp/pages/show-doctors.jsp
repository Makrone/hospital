<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors in clinic</title>
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
<hr />
<!--================ End Header Menu Area =================-->
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<div class="container">
		<c:forEach var="user" items="${users}">
			<div class="border-bottom border-info">
				<div class="row">
					<div class="user-img">
						<img
							src="http://s1.iconbird.com/ico/0612/practika/w256h2561339698323user.png"
							width="150" height="150" alt="Bootstrap Blocks Owl Carousel 1" />
					</div>
					<div class="user-review">
						<div class="container">
							<div class="row">
								<div class="col-sm text-info f-w-600">First name:</div>
								<div class="col-sm f-w-400">${user.firstName}</div>
							</div>
							<div class="row">
								<div class="col-sm text-info f-w-600">Last name:</div>
								<div class="col-sm  f-w-400">${user.lastName}</div>
							</div>
							<div class="row">
								<div class="col-sm text-info f-w-600">Gender:</div>
								<div class="col-sm f-w-400">${user.gender}</div>
							</div>
							<div class="row">
								<div class="col-sm  text-info f-w-600">Phone:</div>
								<div class="col-sm f-w-400">${user.phone}</div>
							</div>
							<div class="row">
								<div class="col-sm text-info f-w-600">Email:</div>
								<div class="col-sm f-w-400">${user.email}</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


</body>
</html>