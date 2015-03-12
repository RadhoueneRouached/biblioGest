<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Ajouter Emprunt</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" /> 
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/template.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />

<script src="${pageContext.request.contextPath}/js/jquery.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validationEngine-fr.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validationEngine.js"
	type="text/javascript"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 <script>
$(function() {
$( "#datepicker" ).datepicker();
});
$(function() {
	$( "#datepicker1" ).datepicker();
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
				<form id="formID" class="formular" action="AjouterEmprunt"
					method="post">
					<fieldset>
						<legend><fmt:message key='addBorrow' /></legend>

						<label> <span> <fmt:message key='firstDate' /> (format YYYY-MM-DD)</span> <input
							class="validate[required,length[1,20]]" type="text"
							name="dateDebut" value="" id="datepicker" />
						</label> <label> <span><fmt:message key='finalDate' /> : (format YYYY-MM-DD)</span> <input
							class="validate[required,length[1,20]]" type="text"
							name="dateFin" id="datepicker1" />
						</label> <label> <span><fmt:message key='overtake' /> </span> 
						<select name="depasse">
						<option value="0">NON</option>
						<option value="1">OUI</option>
						</select>
						</label> <label> <span><fmt:message key='idMember' /> </span> 
												<select name="idAdr">
							<c:forEach items="${listeAdherent}" var="element">
							<option value="${element.id_adherent}">${element.prenom} ${element.nom}</option>
							</c:forEach>
							</select>
						
						</label> <label> <span><fmt:message key='idDocument' /> </span> 
						
						<select name="idDoc">
							<c:forEach items="${listeLivre}" var="element">
							<option value="${element.id_support}">${element.titre}</option>
							</c:forEach>
							</select>
												</label>




					</fieldset>
					<p>
						<input class="submit" type="submit" value="Ajouter Emprunt" />
					</p>
				</form>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>