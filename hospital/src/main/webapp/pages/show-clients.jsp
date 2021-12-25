<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>client info</title>
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
	</div>
	<hr>
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
						<div class="user-info">
							<div class="slide-label">${user.firstName}</div>
							<div class="slide-value">${user.lastName}</div>
							<div class="slide-value">${user.gender}</div>
							<div class="slide-value">${user.phone}</div>
							<div class="slide-value">${user.email}</div>
						</div>
					</div>
					<div class="user-actions">
						<form class="navbar-form pull-right" action="main" method="POST">
							<input type="hidden" name="action" value="delete-client" /> <input
								type="hidden" name="id" value="${user.id}" />
							<button class="btn btn-primary" type="submit">
								<i class="glyphicon glyphicon-star"></i> Delete
							</button>
						</form>
						<form class="navbar-form pull-right" action="main" method="POST">
							<input type="hidden" name="action" value="go-to-edit-user" /> <input
								type="hidden" name="id" value="${user.id}" />
							<button class="btn btn-primary" type="submit"
								name="add-medicament">Edit</button>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>