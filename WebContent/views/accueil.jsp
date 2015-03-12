<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr"> 
<head> 
<title>Accueil</title> 
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" /> 
<link href="css/colorbox.css" rel="stylesheet" type="text/css" /> 
<link href="css/gabarits.css"  /> 
<link href="${pageContext.request.contextPath}/css/styleGabarit.css" rel="stylesheet"  type="text/css"/>
</head> 
 
<body> 
 
<!-- CONTENEUR 998 PX CENTRE --> 
<div id="conteneur"> 
 
	<!-- ENTETE --> 
	
  
	<!-- CONTENEUR CENTRAL  --> 
	<div id="center"> 
 
		<!-- COLONNE GAUCHE  --> 
		<div id="left" style="margin-top:20px;"> 
			<c:import url="/WEB-INF/jspf/menu.jsp"> </c:import>
		</div> 
 
		<!-- CONTENU  --> 
		<div id="content"> 
			<h2><fmt:message key='document' /></h2> 
			<p> 
			<form action="/BibioGestViews/AjouterLivre">
			<input  value="<fmt:message key='add' />" type="submit"   />
			</form>
			<form action="/BibioGestViews/UploadServlet">
			<input  value="<fmt:message key='addLivrexml' />" type="submit"   />
			</form>
<hr/>
<div class="CSSTableGenerator" >
<b>${messageModDoc}</b>
<b>${messageDoc}</b>
<b>${message}</b>

<table border="1">
<tr><td>ID</td><td><fmt:message key='title' /></td><td><fmt:message key='author' /></td><td>Description</td> <td><fmt:message key='numberOfCopies' /></td> <td><a href="/BibioGestViews/ModifierLivre" ><fmt:message key='modify' /></a></td> <td><a href ="/BibioGestViews/SupprimerLivre"><fmt:message key='delete' /></a></td> </tr>
	<c:forEach items="${listeLivre}" var="element"> 
<tr><td>${element.id_support}</td>
<td> ${element.titre} </td>
<td>${element.auteur}</td>
<td>${element.description}</td>
 <td>${element.exemplaire}</td>
  <td><a href="/BibioGestViews/ModifierLivre?mod=${element.id_support}" ><fmt:message key='modify' /></a></td> 
  <td><a href ="/BibioGestViews/SupprimerLivre?sup=${element.id_support}"><fmt:message key='delete' /></a></td> </tr>
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