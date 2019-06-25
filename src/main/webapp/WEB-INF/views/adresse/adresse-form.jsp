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
				Example - Adresse Management</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Adresse</div>
				</div>
				<div class="panel-body">
					<form:form action="saveAdresse" cssClass="form-horizontal"
						method="post" modelAttribute="adresse">
						<!-- need to associate this data with customer id -->
						<form:hidden path="idAdresse" />
						<%-- <form:hidden path="utilisateurId"  value="16"   /> --%>
						
						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">num</label>
							<div class="col-md-9">
								<form:input path="num" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="typeVoie" class="col-md-3 control-label">typevoie</label>
							<div class="col-md-9">
								<form:input path="typeVoie" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="nomVoie" class="col-md-3 control-label">nomvoie</label>
							<div class="col-md-9">
								<form:input path="nomVoie" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="pays" class="col-md-3 control-label">pays</label>
							<div class="col-md-9">
								<form:input path="pays" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="complementAdresse1" class="col-md-3 control-label">complementadresse1</label>
							<div class="col-md-9">
								<form:input path="complementAdresse1" cssClass="form-control" />
						</div>
						
						<div class="form-group">
							<label for="complementAdresse2" class="col-md-3 control-label">complementadresse2</label>
							<div class="col-md-9">
								<form:input path="complementAdresse2" cssClass="form-control" />
						</div>
						
						<%-- <div class="form-group">
							<label for="userAdress" class="col-md-3 control-label">userAdress</label>
							<div class="col-md-9">
							<form:input path="userAdress" cssClass="form-control" />
						</div> --%>
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