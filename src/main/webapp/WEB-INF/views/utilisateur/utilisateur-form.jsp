<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP + MySQL
				Example - UtilisateurS Management</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Utilisateur</div>
				</div>
				<div class="panel-body">
					<form:form action="saveUtilisateur" cssClass="form-horizontal"
						method="post" modelAttribute="utilisateur">

						<!-- need to associate this data with customer id -->
						<form:hidden path="idUtilisateur" />

						<div class="form-group">
							<label for="prenom" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">
								<form:input path="prenom" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="nom" class="col-md-3 control-label">Nom</label>
							<div class="col-md-9">
								<form:input path="nom" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="role" class="col-md-3 control-label">Role</label>
							<div class="col-md-9">
								<select name="role">
								    <option value="">--Please choose an option--</option>
								    <option value="Client">Client</option>
								    <option value="Guess">Guess</option>
								    <option value="Admin">Admin</option>
								    <option value="Agent">Agent</option>
								 </select>	
							<%-- 	<form:input path="role" cssClass="form-control" /> --%>
							</div>
						</div>
						<div class="form-group">
							<label for="statut" class="col-md-3 control-label">Statut</label>
							<div class="col-md-9">
								<select name="statut">
								    <option value="">--Please choose an option--</option>
								    <option value="Creat">Creat</option>
								    <option value="anable">Anable</option>
								    <option value="unanable">Unanable</option>
								</select>
								<%-- <form:input path="statut" cssClass="form-control" /> --%>
							</div>
						</div>
						<div class="form-group">
							<label for="login" class="col-md-3 control-label">Login</label>
							<div class="col-md-9">
								<form:input path="login" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<form:input path="password" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="telephoneFixe" class="col-md-3 control-label">telephoneFixe</label>
							<div class="col-md-9">
								<form:input path="telephoneFixe" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="telephoneMobile" class="col-md-3 control-label">telephoneMobile</label>
							<div class="col-md-9">
								<form:input path="telephoneMobile" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="dateCreation" class="col-md-3 control-label">dateCreation</label>
							<div class="col-md-9">
								<form:input path="dateCreation" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="genre" class="col-md-3 control-label">Genre</label>
							<div class="col-md-9">
								<select name="genre">
								    <option value="">--Please choose an option--</option>
								    <option value="Male">Male</option>
								    <option value="Femme">Femme</option>
								    <option value="Indefinie">Ind�finie</option>
								</select>	
							
								<%-- <form:input path="genre" cssClass="form-control" /> --%>
							</div>
						</div>
						

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>