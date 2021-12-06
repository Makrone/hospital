<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>client info</title>
</head>
<body>
	<div class="container">
		<a class="navbar-logo" href="http://localhost:8080/hospital"><img
			src="http://www.picart.ru/folio-style/mcr-logo02.gif" width="150"
			height="50"> </a>
	</div>
	<hr>
	<div class="container">
		<c:forEach var="user" items="${users}">
			<div class="row">
				<div class="col-md-12">

					<div id="news-slider" class="owl-carousel">
						<div class="post-slide">
							<div class="post-img">
								<img
									src="https://www.lode.by/images/cache/f17/b34bc728d20fd6ca1883b166a1a3be86.jpg"
									alt="Bootstrap Blocks Owl Carousel 1" />
								<div class="category">${user.firstName}</div>
							</div>
							<div class="post-review">
								<h3 class="post-title">${user.lastName}</h3>
								<p class="post-description">${user.firstName}$</p>
							</div>
						</div>
					</div>
					<form class="navbar-form pull-right" action="main" method="POST">
						<input type="hidden" name="action" value="delete-medicaments" />
						<input type="hidden" name="medicamentId" value="${user.id}" />
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