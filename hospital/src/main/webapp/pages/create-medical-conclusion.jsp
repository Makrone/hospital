<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create medical conclusion</title>
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
				<span>Medical conclusion</span>
			</h2>
			<div class="body">
				<!--  First name validation -->
				<div class="control-group">
					<label for="medical_conclusion"> Medical conclusion </label>
					<textarea id="medical_conclusion" required
						name="medical_conclusion" data-validation="custom"
						data-validation-regexp="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
						data-validation-help="Medical conclusion should start with a letter and consist of 1-20 characters"
						placeholder="Medical Conclusion"></textarea>
				</div>
				<!--  service -->
				<div class="control-group">

					<p>
						<label for="medical_service"> Medical Service </label> <select
							name="medical_service_id" id="medical_service">
							<c:forEach var="service" items="${services}">
								<option value="${service.id}">${service.name}</option>
							</c:forEach>
						</select>

					</p>
				</div>
				<!--  medicamen -->
				<div class="control-group">

					<p>
						<label for="medicament"> Medicaments </label> <select
							name="medicament_id" id="medicament">
							<c:forEach var="medicament" items="${medicaments}">
								<option value="${medicament.id}">${medicament.name}</option>
							</c:forEach>
						</select>

					</p>
				</div>
				<div class="footer">
					<input type="hidden" name="action" value="save-medical-conclusion" />
					<input type="hidden" name="treatmentId" value="${treatmentId}" />
					<div class="btnfirst">
						<button class="btn btn-primary btn-sm mb-1" type="submit"
							name="registration">Save</button>
						<button class="btn btn-primary btn-sm mb-1" type="button"
							onClick='location.href="http://localhost:8080/hospital"'>Return</button>
					</div>
				</div>
			</div>
		</form>


	</div>
</body>
</html>