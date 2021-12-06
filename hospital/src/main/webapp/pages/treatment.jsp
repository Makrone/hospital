<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Treatment</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
	</div>
	<hr>

	<h4>An organization that concentrates all kinds of modern medical
		diagnostic, specialized medical care and rehabilitation technologies.
		The MCR is actively researching new methods of diagnosis, treatment
		and rehabilitation of specialized diseases.</h4>

	<div class="container">
		<c:forEach var="treatment" items="${treatments}">
			<div class="row">
				<div class="col-md-12">

					<div id="news-slider" class="owl-carousel">
						<div class="post-slide">
							<div class="post-img">
								<img
									src="https://www.lode.by/images/cache/32a/f04d6bb525c99168da14249b1861d410.jpg"
									alt="Bootstrap Blocks Owl Carousel 1" />
								<div class="category">Выписано клиенту: ${treatment.clientId}</div>
							</div>
							<div class="post-review">
								<h3 class="post-title">${treatment.doctorId}</h3>
								<p class="post-description">${treatment.clientId}</p>
							</div>
						</div>
					</div>
					<form class="navbar-form pull-right" action="main" method="POST">
						<input type="hidden" name="action" value="delete-treatment" /> <input
							type="hidden" name="treatmentId" value="${treatment.id}" />
						<button class="btn btn-sm btn-default" type="submit">
							<i class="glyphicon glyphicon-star"></i> Delete service
						</button>
					</form>

				</div>

			</div>
		</c:forEach>
	</div>
</body>
</html>