<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Ajouter Adherent</title>
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
				<form id="formID" class="formular" action="AjouterAdherent"
					method="post">
					<fieldset>
						<legend>
							<fmt:message key='addMember' />
						</legend>

						<label> <span><fmt:message key='lastName' /></span> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="text" name="nom" value="" id="nom" />
						</label> <label> <span><fmt:message key='firstName' /></span> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="text" name="prenom" id="prenom" />
						</label> <label> <span><fmt:message key='nic' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="cin" value="" id="cin" />
						</label> <label> <span><fmt:message key='birthday' /></span> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="text" name="DateNaissance" id="datepicker" />
						</label> <label> <span><fmt:message key='Email' /></span> <input
							class="validate[required,custom[email],length[1,20]]" type="text"
							name="email" value="" id="email" />

						</label> <label> <span><fmt:message key='pass' /></span> <input
							class="validate[required,confirm[password],length[1,20]]"
							type="text" name="Password" id="password" />
						</label> <label> <span><fmt:message key='roadNumber' /></span> <input
							class="validate[required,custom[onlyNumber],length[1,20]]"
							type="text" name="nrue" value="" id="nrue" />
						</label> <label> <span><fmt:message key='road' /></span> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="text" name="rue" id="rue" />
						</label> <label> <span><fmt:message key='city' /></span> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="text" name="cite" value="" id="cite" />
						</label> <label> <span><fmt:message key='state' /></span> <select
							name="ville" id="ville">
								<option>Tunis</option>
								<option>Ariana</option>
								<option>BenArous</option>
								<option>Manouba</option>
								<option>Nabeul</option>
								<option>Bizerte</option>
								<option>Beja</option>
								<option>Kef</option>
								<option>Jandouba</option>
								<option>Seliana</option>
								<option>Sousse</option>
								<option>Monastir</option>
								<option>Mehdia</option>
								<option>Sfax</option>
								<option>Kairouan</option>
								<option>Kassrine</option>
								<option>Gafsa</option>
								<option>Gabes</option>
								<option>Medenine</option>
								<option>Zerzis</option>
								<option>Kabili</option>
								<option>Touzeur</option>
								<option>Tataouine</option>
								<option>Zaghouen</option>
						</select>
						</label>


					</fieldset>
					<p>
						<input class="submit" type="submit"
							value="<fmt:message key='addMember' />" />
					</p>
				</form>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>