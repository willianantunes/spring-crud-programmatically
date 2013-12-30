<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes do usuário</title>
</head>
<body>

<h1>Alterar dados</h1>

<c:if test="${not empty message}">

<h3>Mensagem: <span style="color: red;"> ${mensagem}</span></h3>

</c:if>

<form action="<c:url value="/users" />" name="registerForm" method="post">
	<fieldset>
		<legend>Usuário</legend>
		<label for="name">Nome</label>
		<input type="text" name="name" value="${user.name}" />
		
		<label for="birthDate">Data de nascimento</label>
		<input type="text" name="birthDate" value="<joda:format value="${user.birthDate}" pattern="dd/MM/yyyy" />" />
		
		<input type="hidden" name="_method" value="put" />
		<input type="hidden" name="id" value="${user.id}" />
		
		<input type="submit" value="Alterar" />
	</fieldset>
</form>

</body>
</html>