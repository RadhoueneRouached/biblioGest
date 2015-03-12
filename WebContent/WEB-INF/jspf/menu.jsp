<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#navigation li a:hover, #navigation li a:focus, #navigation li a:active {
  background: #900 ;
  text-decoration: underline ;
}
#navigation li a {
  display: block ;
  background: #c00 ;
  color: #fff ;
  font: 1em "Trebuchet MS",Arial,sans-serif ;
  line-height: 1em ;
  text-align: center ;
  text-decoration: none ;
  padding: 4px 0 ;
}
#navigation li {
  background: #c00 ;
  color: #fff ;
  border: 1px solid #600 ;
  margin-bottom: 1px ;
}
#navigation {
  width: 200px;
  list-style: none;
  margin: 0;
  padding: 0;
}

</style>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
</head>
<body>
 <fmt:setLocale value="${sessionScope['lang']}"/>
 
<ul id="navigation">
<ul>
  <li><a href='<c:url value="/Accueil"></c:url>' title="Gerer Livre "><fmt:message key='ManageDocument' /></a></li>
  <li><a href='<c:url value="/GererAdherent"></c:url>' title="Gerer Adherent "><fmt:message key='ManageMember' /></a></li>
  <li><a href='<c:url value="/GererEmprunt"></c:url>' title="GererEmprunt"><fmt:message key='ManageBorrow' /></a></li>
  <li><a href='<c:url value="/statistque"></c:url>' title="Stat"><fmt:message key='statistic' /></a></li>
</ul>
</li>
</ul>

</body>
</html>