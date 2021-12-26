<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkouts</title>
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
	<h1>Checkouts</h1>

	<table>
	<tr>
		<th>Id</th>
		<th>Movie</th>
		<th>Checkout Date</th>
		<th>Return Date</th>
	
	</tr>
<c:forEach var="checkout" items="${checkouts}">
	
	<tr>
		<td>${checkout.id  }</td>
		<td>${checkout.movie.name }</td>
		<td><fmt:formatDate type = "both" 
         dateStyle = "short" timeStyle = "short"
         value = "${checkout.checkoutDate}" /></td>
		
		<c:choose>
				<c:when test="${checkout.returnStatus == false}">
					<td></td>
					<c:url var="returnLink" value="/checkout/return">
						<c:param name="checkoutId" value="${checkout.id}" />
						<c:param name="customerId" value="${checkout.customerId}" />
					</c:url>
					<td><form:form action="${returnLink}" modelAttribute="checkout" method="post">
					<form:input type="hidden" path="id" value= "${checkout.id}" />
					<input type="submit" value="return Movie" class="btn"/>
					</form:form>
					</td>
				</c:when>
				<c:otherwise>
							<td><fmt:formatDate type = "both" 
         dateStyle = "short" timeStyle = "short" value = "${checkout.returnDate}" /></td>
				</c:otherwise>
		</c:choose>
		
	</tr>
	</c:forEach>
	</table>
</div>
</body>
</html>