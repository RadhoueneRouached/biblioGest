<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<title>Recherche Livre</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" /> 
<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
<link href="css/gabarits.css" />
<link href="${pageContext.request.contextPath}/css/styleGabarit.css"
	rel="stylesheet" type="text/css" />
</head>
<style>
dl.float-right {
	border: 1px solid #000;
	background-color: #ddd;
	width: 500px;
	text-align: center;
	padding: 0 0 10px 0;
	float: left;
	margin: 0 0 1em 1em;
}

.float-right dt {
	font-weight: bold;
	background-color: #131210;
	color: #959289;
	padding: 5px 10px;
	margin-bottom: 10px;
}

.float-right dd img {
	border: 1px solid #000;
	width: 100px;
	height: 100px;
}

.float-right dd {
	margin: 0;
	padding: 0 10px 5px 10px;
	font-size: 85%;
}
</style>
<body>

	<!-- CONTENEUR 998 PX CENTRE -->
	<div id="conteneur">

		<!-- ENTETE -->
		<!-- CONTENEUR CENTRAL  -->
		<div id="center">

			<!-- COLONNE GAUCHE  -->

			<!-- CONTENU  -->
			<div id="content">
				<h2><fmt:message key='document' /></h2>
				<p>
					<hr />
							<a href="/BibioGestViews/ConsulterLivre"> << <fmt:message key='back' /></a>

					<div class="CSSTableGenerator">
						

						<dl class="float-right">
							<dt>${rechDoc.titre}</dt>
							<dd>
							<b><fmt:message key='author' /> :${rechDoc.auteur}</b>
								<br/>
								Description :
								${rechDoc.description}
							</dd>

							<dd>
								<em><fmt:message key='releaseDate' />${rechDoc.dateSorie}</em>
							</dd>
							<dd><fmt:message key='numberOfCopies' /> : ${rechDoc.exemplaire}</dd>
						</dl>

					</div>

				</p>
			</div>

		</div>

		<!-- PIED DE PAGE -->

	</div>

</body>
</html>