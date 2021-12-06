<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Service</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
	</div>
	<hr>
	<h4>Diagnostics is an integral part of modern medicine, without
		which it is impossible to provide complete medical care. Thanks to
		modern equipment and reagents, laboratory diagnostics makes it
		possible to obtain qualitative and maximally informative data on the
		processes occurring in our body in a fairly short period of time.</h4>
	<br />
	<h4>Clinical and diagnostic laboratory "MCR" today is the latest
		achievements of laboratory diagnostics, standardization, automation of
		research processes, excluding the human factor. This is the most
		modern equipment and reagents of world producers, closed test systems,
		qualified specialists of the first and the highest category, the
		confirmed quality of laboratory tests.</h4>
	<br />
	<div class="container">
		<c:forEach var="service" items="${services}">
			<div class="row">
				<div class="col-md-12">

					<div id="news-slider" class="owl-carousel">
						<div class="post-slide">
							<div class="post-img">
								<img
									src="https://www.lode.by/images/cache/b7f/4bdfb0f8aaf0ca20115a55c186091749.jpg"
									alt="Bootstrap Blocks Owl Carousel 1" />
								<div class="category">${service.cost}$</div>
							</div>
							<div class="post-review">
								<h3 class="post-title">${service.name}</h3>
								<p class="post-description">${service.description}</p>
							</div>
						</div>
					</div>
					<form class="navbar-form pull-right" action="main" method="POST">
						<input type="hidden" name="action" value="delete-service" />
						<input type="hidden" name="serviceId" value="${service.id}" />
						<button class="btn btn-sm btn-default" type="submit">
							<i class="glyphicon glyphicon-star"></i> Delete service
						</button>
					</form>
					
					<form class="navbar-form pull-right" action="main" method="POST">
						<input type="hidden" name="action" value="go-to-edit-service" />
						<input type="hidden" name="serviceId" value="${service.id}" />
						<button class="btn btn-sm btn-default" type="submit">
							<i class="glyphicon glyphicon-star"></i> Edit service
						</button>
					</form>
				</div>

			</div>
		</c:forEach>
	</div>
</body>
</html>