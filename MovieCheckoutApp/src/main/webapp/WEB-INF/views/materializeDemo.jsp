<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script>
    M.AutoInit();
    var instance = M.InputField.init();
</script>

</head>
<body>
	<nav>
	    <div class="nav-wrapper">
	      <a href="#" class="brand-logo">Materialize Demo</a>
	      <ul id="nav-mobile" class="right hide-on-med-and-down ">
	        <li><a href="#">Link 1</a></li>
	        <li><a href="#">Link 2</a></li>
	        <li><a href="#">Link 3</a></li>
	      </ul>
	    </div>
  	</nav>
 
	<div class="container">
	<a class="btn-floating pulse"><i class="material-icons">menu</i></a>
			<h1>hello, demo!</h1>
			<div class="row">
				<div class="col blue s12">
					<p>s12</p>
				</div>
			</div>	
			<div class="row">
				<div class="col s12 m4 l2 yellow">
					<p>s12 m4</p>
				</div>
				<div class="col s12 m4 l8 orange">
					<p>s12 m4 l8</p>
				</div>
				<div class="col s12 m4 l2 yellow">
					<p>s12 m4</p>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m6 l3 green">
					<p>s12 m6 l3</p>
				</div>
				<div class="col s12 m6 l3 green">
					<p>s12 m6 l3</p>
				</div>
				<div class="col s12 m6 l3 green">
					<p>s12 m6 l3</p>
				</div>
				<div class="col s12 m6 l3 green">
					<p>s12 m6 l3</p>
				</div>
			</div>
		
		<div class="row">
			<h1>Movies</h1>
		</div>
		<div class="row">
		<table class="striped" >
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
		<div class="row">

			<form class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="first_name" type="text"
							class="validate"> <label for="first_name">First
							Name</label>
					</div>
					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"> <label
							for="last_name">Last Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input disabled value="I am not editable" id="disabled"
							type="text" class="validate"> <label for="disabled">Disabled</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="password" type="password" class="validate"> <label
							for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="email" class="validate"> <label
							for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="col s12">
						This is an inline input field:
						<div class="input-field inline">
							<input id="email_inline" type="email" class="validate"> <label
								for="email_inline">Email</label> <span class="helper-text"
								data-error="wrong" data-success="right">Helper text</span>
						</div>
					</div>
				</div>
			</form>
		</div>


	</div>
</body>
</html>