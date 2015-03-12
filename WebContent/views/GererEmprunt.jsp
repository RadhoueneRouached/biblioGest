<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Emprunt</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" /> 
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />
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
				<h2>
					<fmt:message key='borrow' />
				</h2>
				<br />
				<br />
				<b>${messageSupEmp}</b>
				<b>${messageModEmp}</b>
				<p>
					<form action="/BibioGestViews/AjouterEmprunt">
						<input value="<fmt:message key='add' />" type="submit" />
					</form>
					<hr />
					<div class="CSSTableGenerator">
						<table border="1">
							<tr>
								<td>ID</td>
								<td><fmt:message key='document' /></td>
								<td><fmt:message key='member' /></td>
								<td><fmt:message key='firstDate' /></td>
								<td><fmt:message key='finalDate' /></td>
								<td><fmt:message key='overtake' /></td>
								<td><fmt:message
											key='modify' /></a></td>
								<td><fmt:message
											key='delete' /></a></td>
							</tr>
							<c:forEach items="${listeEmprunt}" var="element">
								<tr>
									<td>${element.id_emp}</td>
									<td>${element.getDocument().titre}</td>
									<td>${element.getAdherent().nom} ${element.getAdherent().prenom}</td>
									<td><c:set var="db" value="${element.dateDeb}" /> <fmt:formatDate type="date" value="${db}" /></td>
									<td><c:set var="df" value="${element.dateFin}" /> <fmt:formatDate type="date" value="${df}" /></td>
									<td>${element.depasse}</td>
									<td><a
										href="/BibioGestViews/ModifierEmprunt?mod=${element.id_emp}"><fmt:message
												key='modify' /></a></td>
									<td><a
										href="/BibioGestViews/SupprimerEmprunt?sup=${element.id_emp}"><fmt:message
												key='delete' /></a></td>
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