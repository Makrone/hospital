<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conclusion</title>
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
		<form class="navbar-form pull-left" action="main" method="POST">
			<input type="hidden" name="action" value="logout" />
			<div class="btnfirst">
				<button class="btn btn-danger btn-sm" style="float: right;"
					type="submit" name="logout">Log out</button>
			</div>
		</form>
		<form class="navbar-form pull-right" action="main" method="POST">
			<input type="hidden" name="action" value="go-to-profile" />
			<div class="btnfirst">
				<button class="btn btn-primary btn-sm mb-2" style="float: right;"
					type="submit" name="go-to-profile">Profile</button>
			</div>
		</form>
	</div>
	</div>
	<hr>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<div class="border-bottom border-info">
		<div class="row">
			<div class="col-md-2">
				<img
					src="https://static9.depositphotos.com/1252160/1099/i/600/depositphotos_10991153-stock-photo-writing-a-medical-report.jpg"
					width="200" height="150" alt="Bootstrap Blocks Owl Carousel 1" />
			</div>
			<div class="col-md-2">
				<div class="category">
					<b>Prescribed by Dr. :</b> ${treatment.doctor.firstName}
					${treatment.doctor.lastName}
				</div>
			</div>
			<%-- <div class="col-md-2">
				<h4 class="post-title"><b>Doctor</b>${treatment.doctor.firstName}</h4>
				<p class="post-description">${treatment.doctor.lastName}</p>
			</div> --%>

			<div class="col-md-3">
				<h4 class="post-title">Medicament</h4>
				<p class="post-description">
					<b>Name: </b>${medicament.name}</p>
				<p class="post-description">
					<b>Description: </b>${medicament.description}</p>
				<p class="post-description">
					<b>Cost: </b>${medicament.cost}$</p>
			</div>
			<div class="col-md-3">
				<h4 class="post-title">Medical Service</h4>
				<p class="post-name">
					<b>Name: </b>${medicalService.name}</p>
				<p class="post-description">
					<b>Description: </b>${medicalService.description}</p>
				<p class="post-cost">
					<b>Cost: </b>${medicalService.cost}$</p>
			</div>

			<div class="col-md-2">
				<h4 class="post-title">Сonclusion</h4>
				<p class="post-description">${treatment.medicalConclusion}</p>
			</div>
		</div>
	</div>
</body>
</html>