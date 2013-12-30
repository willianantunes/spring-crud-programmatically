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
<title>Usuários</title>
</head>
<body>

<h1>Lista dos usuários cadastrados</h1>

<c:choose>
	<c:when test="${not empty users}">
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>Nome</th>
					<th>Data</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td><a href="<c:url value="/users/${user.id}" />">${user.name}</a></td>
						<td><joda:format value="${user.birthDate}" pattern="dd/MM/yyyy" /></td>
						<td><a href="<c:url value="/users/delete/${user.id}" />">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>	
	</c:when>
	<c:otherwise>
		<p>Nenhum usuário cadastrado</p>
	</c:otherwise>
</c:choose>

<c:if test="${not empty message}">

<h3>Mensagem: <span style="color: red;"> ${message}</span></h3>

</c:if>

<h1>Cadastro de usuários</h1>

<form action="<c:url value="/users" />" name="registerForm" method="post">
	<fieldset>
		<legend>Novo usuário</legend>
		<label for="name">Nome</label>
		<input type="text" name="name" />
		
		<label for="birthDate">Data de nascimento</label>
		<input type="text" name="birthDate" />
		
		<input type="submit" value="Cadastrar" />
	</fieldset>
</form>

</body>
</html>