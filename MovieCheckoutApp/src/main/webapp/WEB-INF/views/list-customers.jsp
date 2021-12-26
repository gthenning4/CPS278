<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
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
	<h1>Customers</h1>
	<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
	
	<c:forEach var="eachCustomer" items="${customers}">
		<c:url var="checkoutLink" value="/checkout/list">
			<c:param name="customerId" value="${eachCustomer.id}" />
		</c:url>
		<c:url var="historyLink" value="/checkout/history">
			<c:param name="customerId" value="${eachCustomer.id}" />
		</c:url>
	<tr>
		<td>${eachCustomer.firstName }</td>
		<td>${eachCustomer.lastName }</td>
		<td>${eachCustomer.email }</td>
		<td><a href="${checkoutLink}">Checkout Movies</a></td>
		<td><a href="${historyLink}">History</a></td>
	</tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>