<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<li><a href="${pageContext.request.contextPath}/movie/add">AddMovie</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">

		<h1>Add Movie</h1>
		<c:url var="addMovieLink" value="/movie/save" />

		<form:form action="${addMovieLink}" modelAttribute="movie"
			method="post">


			<label for="name">Movie Title</label>
			<form:input id="name" path="name" />


			<label for="description">Description</label>
			<form:input path="description" id="description" />

			<label for="numTotal">Number of Total Copies</label>
			<form:input path="numTotal" id="numTotal" />
			<input class="btn" type="submit" value="Add Movie to System" />

		</form:form>

	</div>
</body>
</html>