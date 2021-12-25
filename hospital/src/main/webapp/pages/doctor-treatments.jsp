<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Treatment</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
	</div>
	<hr>

	<h5>An organization that concentrates all kinds of modern medical
		diagnostic, specialized medical care and rehabilitation technologies.
		The MCR is actively researching new methods of diagnosis, treatment
		and rehabilitation of specialized diseases.</h5>

	<div class="container">
		<c:forEach var="treatment" items="${treatments}">
			<div class="border-bottom border-info">

				<div class="row">

					<div class="col-md-3">
						<img
							src="https://chekhovsc.ru/templates/yootheme/cache/lchni_gangrny_03-min-214b9939.jpeg"
							width="200" height="150" alt="Bootstrap Blocks Owl Carousel 1" />
					</div>
					<div class="col-md-7">
						<div class="category">Выписано клиенту:
							${treatment.client.firstName} ${treatment.client.lastName}</div>

						<div class="post-review">
							<h4 class="post-title">${treatment.doctor.firstName}</h4>
							<p class="post-description">${treatment.doctor.lastName}</p>
						</div>
					</div>
					<div class="col-md-2">
						<form class="navbar-form pull-right" action="main" method="POST">
							<input type="hidden" name="action" value="check-on-patient" /> <input
								type="hidden" name="treatmentId" value="${treatment.id}" />
							<button class="btn btn-primary btn-sm mb-2" type="submit">
								<i class="glyphicon glyphicon-star">Сheck on the patient</i>
							</button>
						</form>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>