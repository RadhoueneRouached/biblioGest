<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Modifier Emprunt</title>
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
				<form id="formID" class="formular" action="ModifierEmprunt"
					method="post">
					<fieldset>
						<legend><fmt:message key='modifyBorrow' />: </legend>
<input
							class="validate[required,length[1,20]]" type="hidden"
							name="id" value="${EmpruntMod.id_emp}" id="id" />
							
												<label> <span> <fmt:message key='firstDate' /> (format YYYY-MM-DD)</span> <input
							class="validate[required,length[1,30]]" type="text"
							name="dateDebut" value="${EmpruntMod.dateDeb}" id="datepicker1" />
						</label> <label> <span><fmt:message key='finalDate' /> : (format YYYY-MM-DD)</span> <input
							class="validate[required,length[1,30]]" type="text"
							name="dateFin" id="datepicker" value="${EmpruntMod.dateFin}"/>
						</label> <label> <span><fmt:message key='overtake' /> </span> 
						<select name="depasse"  >
							<option selected="selected" value="${EmpruntMod.depasse}">${EmpruntMod.depasse}</option>
						<option value="0">NON</option>
						<option value="1">OUI</option>
						</select>
						</label> <label> <span><fmt:message key='idMember' /> </span> 
												<select name="idAdr">
							<option selected="selected" value="${EmpruntMod.getAdherent().id_adherent}">${EmpruntMod.getAdherent().prenom} ${EmpruntMod.getAdherent().nom}</option>
							<c:forEach items="${listeAdherent}" var="element">
							<option value="${element.id_adherent}">${element.prenom} ${element.nom}</option>
							</c:forEach>
							</select>
						
						</label> <label> <span><fmt:message key='idDocument' /> </span> 
						
						<select name="idDoc">
						<option selected="selected" value="${EmpruntMod.getDocument().id_support}">${EmpruntMod.getDocument().titre}</option>
							<c:forEach items="${listeLivre}" var="element">
						
							<option value="${element.id_support}">${element.titre}</option>
							</c:forEach>
							</select>
												</label>




					</fieldset>
					<p>
						<input class="submit" type="submit" value="<fmt:message key='modifyBorrow' />" />
					</p>
				</form>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>