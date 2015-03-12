<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Modifier Adherent</title>
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
			<div id="left" style="margin-top: 20px;">
				<c:import url="/WEB-INF/jspf/menu.jsp">
				</c:import>
			</div>

			<!-- CONTENU  -->
			<div id="content">
				<form id="formID" class="formular" action="ModifierAdherent"
					method="post">
					<fieldset>
						<legend><fmt:message key='modifyMember' />: </legend>
							<b>${messageMod}</b><br/>
						<label> <input
							class="validate[required,custom[noSpecialCaracters],length[1,20]]"
							type="hidden" name="idAdherent" value="${adherentMod.id_adherent}" id="idAdherent"  /> <label>
								<span><fmt:message key='lastName' /></span> <input
								class="validate[required,custom[noSpecialCaracters],length[1,20]]"
								type="text" name="nom" value="${adherentMod.nom}" id="nom" />
						</label> <label> <span><fmt:message key='firstName' /></span> <input
								class="validate[required,custom[noSpecialCaracters],length[1,20]]"
								type="text" name="prenom" id="prenom" value="${adherentMod.prenom}" />
						</label> <label> <span><fmt:message key='nic' /></span> <input
								class="validate[required,custom[onlyNumber],length[1,20]]"
								type="text" name="cin" value="${adherentMod.cin}" id="cin" /> <label> <span><fmt:message key='warning' /></span>
									<input
									class="validate[required,custom[onlyNumber],length[1,20]]"
									type="text" name="avertissement" value="${adherentMod.active}" id="avertissement" />

							</label> <label> <span><fmt:message key='birthday' /></span> <input
									class="validate[required,length[1,20]]"
									type="text" name="DateNaissance" id="DateNaissance" value="${adherentMod.dateNaissance}"/>
							</label> <label> <span><fmt:message key='Email' /></span> <input
									class="validate[required,custom[email],length[1,20]]"
									type="text" name="email" id="email" value="${adherentMod.email}" />

							</label> <label> <span><fmt:message key='pass' /></span> <input
									class="validate[required,confirm[password],length[1,20]]"
									type="text" name="Password" id="password" value="${adherentMod.pass}" />
							</label> <label> <span><fmt:message key='roadNumber' /></span> <input
									class="validate[required,custom[onlyNumber],length[1,20]]"
									type="text" name="nrue" value="${adherentMod.getAdresse().numRue}" id="nrue" />
							</label> <label> <span><fmt:message key='road' /></span> <input
									class="validate[required,custom[noSpecialCaracters],length[1,20]]"
									type="text" name="rue" id="rue" value="${adherentMod.getAdresse().rue}" />
							</label> <label> <span><fmt:message key='city' /></span> <input
									class="validate[required,custom[noSpecialCaracters],length[1,20]]"
									type="text" name="cite" value="${adherentMod.getAdresse().cite}" id="cite" />
							</label> <label> <span><fmt:message key='state' /></span> <input
									class="validate[required,custom[noSpecialCaracters],length[1,20]]"
									type="text" name="ville"  value="${adherentMod.getAdresse().ville}" id="ville" />
							</label>
					</fieldset>
					<p>
						<input class="submit" type="submit" value="<fmt:message key='modifyMember' />" />
					</p>
				</form>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>