<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" /> 
<title>Login</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
	
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/template.css" type="text/css"
	media="screen" title="no title" charset="utf-8" />
	
<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine-fr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine.js" type="text/javascript"></script>
</head>
<body>
	
		
				<c:choose>
					<c:when
						test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'] eq 'en'}">
						<a href="?lang=fr">Francais</a>
					</c:when>
					<c:otherwise>
					<a href="/BibioGestViews/Lang?lang=en" class="type1">English</a>
						<a href="/BibioGestViews/Lang?lang=fr" class="type1">Francais</a>
					</c:otherwise>
				</c:choose>
					 <fmt:setLocale value="${sessionScope['lang']}"/>
					 
<center id="message">${message }</center>
	<form id="formID" class="formular" action="Login"
		method="post">
		<fieldset>
			<legend> <fmt:message key='loginIn' /> </legend>

			<label> <span><fmt:message key='login' /></span> <input class="validate[required,length[1,20]]" type="text" name="login"
				value=""  id="login" />
			</label> <label> <span><fmt:message key='pass' /></span> <input class="validate[required,custom[noSpecialCaracters],length[1,20]]" type="password"
				name="pwd" id="pwd" />
			</label>
			</label> <label> <span><fmt:message key='admin' /></span> 
			<input class="checkbox" type="checkbox"  id="admin"  name="admin"/>
			
			</label>
			<label>
			<a href="/BibioGestViews/Inscription" alt=""><fmt:message key='signUp' /></a>			 
			</label>
			
			
		
		</fieldset>
		<p>
			<input class="submit" type="submit" value="<fmt:message key='loginIn' />" />
		</p>
	</form>
	<!--  class="validate[required,custom[noSpecialCaracters],length[1,20]]" -->
</body>
</html>