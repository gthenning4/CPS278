<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
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
		<div class="row section">
			<h1>Movies</h1>
			<form action=${pageContext.request.contextPath}/movie/search
				method="post" autocomplete="off">
				<div class="row>">
					<div class=" input-field col s10">
						<input type="text" name="keyword" placeholder="Search Movies" />
					</div>
					<div class="input-field col s2">
						<input class="btn" type="submit" value="search" />
					</div>
				</div> 
			</form>
		</div>
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Available</th>
				<th>Total</th>
			</tr>
			<c:forEach var="movie" items="${movies}">
				<tr>
					<td>${movie.name}</td>
					<td>${movie.description}</td>
					<td>${movie.numAvailable}</td>
					<td>${movie.numTotal}</td>
					
				</tr>
			</c:forEach>
		</table>


	</div>
</body>
</html>