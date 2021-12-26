<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Movies</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>
	<nav>
    <div class="nav-wrapper teal lighten-2">
      <a href="#" class="brand-logo">Checkout App</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down ">
        <li><a href="${pageContext.request.contextPath}/customer/list">Customers</a></li>
        <li><a href="${pageContext.request.contextPath}/movie/list">Movies</a></li>
        <li><a href="${pageContext.request.contextPath}/movie/add">Add Movie</a></li>
      </ul>
    </div>
  </nav>
	<div class="container">
		<h1>Checkout Movies</h1>
		<div class="row">
			<c:forEach var="movie" items="${movies}">
				<c:url var="checkoutLink" value="/checkout/save">
					<c:param name="movieId" value="${movie.id}" />
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
				
				<div class="col s4">
					<div class="card small blue-grey darken-1">
						<div class="card-content white-text">

							<span class="card-title">${movie.name}</span>
							<p>${movie.description}</p>
							<div class="section">
							<p>Available: ${movie.numAvailable}</p>
							</div>
						</div>
						<div class="card-action">
							<c:choose>
								<c:when test="${movie.numAvailable > 0}">
									<form action="${checkoutLink}" method="post">
									<input class="btn-small" type="submit" value="Checkout" />
									</form>
								</c:when>
								<c:otherwise>
  									<a class="btn disabled" href="#">Checkout</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>