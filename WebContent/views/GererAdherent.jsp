<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Gérer Adherent</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" /> 
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 <script>
 $(function() {
	 $( "#datepicker" ).datepicker({
	 changeMonth: true,
	 changeYear: true
	 });
	 });
 
</script>

</head>

<body>

	<!-- CONTENEUR 998 PX CENTRE -->
	<div id="conteneur">

		<!-- ENTETE -->
		<!-- CONTENEUR CENTRAL  -->
		<div id="center">

			<!-- COLONNE GAUCHE  -->
			<div id="left" style="margin-top: 20px;">
				<c:import url="/WEB-INF/jspf/menu.jsp">
				</c:import>
			</div>

			<!-- CONTENU  -->
			<div id="content">
				<h2><fmt:message key='member' /></h2>
				<p>
					<form action="/BibioGestViews/AjouterAdherent">
						<input value="<fmt:message key='add' />" type="submit" />
					</form>
					<br>${messageMAJ}</br>
					<form method="post" action="/BibioGestViews/GererAdherent">
						
						<input value="<fmt:message key='defineDateExp' />" name="df" id="datepicker" type="text" />
						<input value="<fmt:message key='updateMembers' />" type="submit" />
					</form>
					
					<hr />
					<div class="CSSTableGenerator">
						<table border="1">
							<tr>
								<td>ID</td>
								<td><fmt:message key='nic' /></td>
								<td><fmt:message key='lastName' /></td>
								<td><fmt:message key='firstName' /></td>
								<td><fmt:message key='birthday' /></td>
								<td><fmt:message key='Email' /></td>
								<td><fmt:message key='warning' /></td>
								<td><fmt:message key='roadNumber' /></td>
								<td><fmt:message key='road' /></td>
								<td><fmt:message key='city' /></td>
								<td><fmt:message key='state' /></td>
								<td><a href="/BibioGestViews/ModifierAdherent"><fmt:message key='modify' /></a></td>
								<td><a href="/BibioGestViews/SupprimerAdherent"><fmt:message key='delete' /></a></td>
							</tr>
						<c:forEach items="${liste}" var="element"> 
  <tr>
								<td>${element.id_adherent}</td>
								<td>${element.cin}</td>
								<td>${element.nom}</td>
								<td>${element.prenom}</td>
								<td>${element.dateNaissance}</td>
								<td>${element.email}</td>
								<td>${element.avertissement}</td>
								<td>${element.getAdresse().numRue}</td>
								<td>${element.getAdresse().rue}</td>
								<td>${element.getAdresse().cite}</td>
								<td>${element.getAdresse().ville}</td>
								
								<td><a href="/BibioGestViews/ModifierAdherent?mod=${element.id_adherent}"><fmt:message key='modify' /></a></td>
								<td><a href="/BibioGestViews/SupprimerAdherent?sup=${element.id_adherent}"><fmt:message key='delete' /></a></td>
							</tr>
</c:forEach>
 


						</table>
					</div>

				</p>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>