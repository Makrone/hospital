<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client treatment</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/general.css" />
</head>
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

					<div class="col-md-2">
						<img
							src="https://img.gazeta.ru/files3/571/10396571/shutterstock_92474629-pic905-895x505-2290.jpg"
							width="200" height="150" alt="Bootstrap Blocks Owl Carousel 1" />
					</div>
					<div class="col-md-3"> <b>Issued to the client:</b>
						${treatment.client.firstName} ${treatment.client.lastName}</div>
					<div class="col-md-3">
						<h4 class="post-title">${treatment.doctor.firstName}</h4>
						<p class="post-description">${treatment.doctor.lastName}</p>
					</div>
					<div class="col-md-4">
						<form class="navbar-form pull-right" action="main" method="POST">
							<input type="hidden" name="action" value="cancel-treatment" /> <input
								type="hidden" name="treatmentId" value="${treatment.id}" />
							<button class="btn btn-primary btn-sm mb-2" type="submit">
								<i class="glyphicon glyphicon-star">Cancel</i>
							</button>
						</form>

						<form class="navbar-form pull-right" action="main" method="POST">
							<input type="hidden" name="action" value="show-client-conclusion" />
							<input type="hidden" name="treatmentId" value="${treatment.id}" />
							<button class="btn btn-primary btn-sm mb-2" type="submit">
								<i class="glyphicon glyphicon-star">Show client Conclusion</i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>