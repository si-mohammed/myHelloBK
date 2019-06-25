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
				MySQL Example - Utilisateur Management</h3>
			<hr />

			<input type="button" value="Add Utilisateur"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Utilisateur List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Email</th>
							<th>Role</th>
							<th>Statut</th>
							<th>Date de Creation</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our utilisateurs -->
						<c:forEach var="tempUtilisateur" items="${utilisateurs}">

							<!-- construct an "update" link with utilisateur id -->
							<c:url var="updateLink" value="/utilisateur/updateForm">
								<c:param name="utilisateurId" value="${tempUtilisateur.idUtilisateur}" />
							</c:url>

							<!-- construct an "delete" link with utilisateur id -->
							<c:url var="deleteLink" value="/utilisateur/delete">
								<c:param name="utilisateurId" value="${tempUtilisateur.idUtilisateur}" />
							</c:url>

							<tr>
								<td>${tempUtilisateur.nom}</td>
								<td>${tempUtilisateur.prenom}</td>
								<td>${tempUtilisateur.email}</td>
								<td>${tempUtilisateur.role}</td>
								<td>${tempUtilisateur.statut}</td>
								<td>${tempUtilisateur.dateCreation}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this utilisateur?'))) return false">Delete</a>
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









