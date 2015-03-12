<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Emprunter Livre</title>
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
</head>

<body>

	<!-- CONTENEUR 998 PX CENTRE -->
	<div id="conteneur">

		<!-- ENTETE -->
		<!-- CONTENEUR CENTRAL  -->
		<div id="center">

			<!-- COLONNE GAUCHE  -->
		

			<!-- CONTENU  -->
			<div id="content">
				<form id="formID" class="formular" action="AjouterEmprunt"
					method="post">
					<fieldset>
						<legend><fmt:message key='borrowDocument' /></legend>

						<label> <span> <fmt:message key='firstDate' />: (format YYYY-MM-DD)</span> <input
							class="validate[required,custom[date],length[1,20]]" type="text"
							name="titre" value="" id="titre" />
						</label> <label> <span><fmt:message key='finalDate' /> : (format YYYY-MM-DD)</span> <input
							class="validate[required,custom[date],length[1,20]]" type="text"
							name="dateFin" id="dateFin" />
						</label> <label> <span><fmt:message key='overtake' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="depasse" value="" id="depasse" />
						</label> <label> <span><fmt:message key='idMember' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="idAdr" id="idAdr" value="Adherent Actuel" readyonly/>
						</label> <label> <span><fmt:message key='idDocument' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="idDoc" id="idDoc" />
						</label>




					</fieldset>
					<p>
						<input class="submit" type="submit" value="<fmt:message key='borrowDocument' />" />
					</p>
				</form>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>