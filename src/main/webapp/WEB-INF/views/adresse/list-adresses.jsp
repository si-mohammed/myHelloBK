<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP +
				MySQL Example - Adresse Management</h3>
			<hr />

			<input type="button" value="Add Adresse"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Adresse List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>num</th>
							<th>typevoie</th>
							<th>nomvoie</th>
							<th>CP</th>
							<th>ville</th>
							<th>pays</th>
							<th>complementadresse1</th>
							<th>complementadresse2</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="tempAdresse" items="${adresses}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/adresse/updateForm">
								<c:param name="adresseId" value="${tempAdresse.idAdresse}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/adresse/delete">
								<c:param name="adresseId" value="${tempAdresse.idAdresse}" />
							</c:url>

							<tr>
								<td>${tempAdresse.num}</td>
								<td>${tempAdresse.typeVoie}</td>
								<td>${tempAdresse.nomVoie}</td>
								<td>${tempAdresse.cp}</td>
								<td>${tempAdresse.ville}</td>
								<td>${tempAdresse.pays}</td>
								<td>${tempAdresse.complementAdresse1}</td>
							    <td>${tempAdresse.complementAdresse2}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>









