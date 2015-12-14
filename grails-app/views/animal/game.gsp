<!DOCTYPE html>

<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Animals Test</title>
		<g:javascript library="jquery"></g:javascript>
		<%@ page contentType="text/html;charset=UTF-8" %>
	</head>
	<body>
		<div id="divQ">
			<h1>${animal.question}</h1>
			<g:link action="yes" params="[id: animal.id]">
			<input type="button" value="Yes" class="button"/>
			</g:link>
			<g:link action="no" params="[id: animal.id]">
			<input type="button" value="No" class="button"/>
			</g:link>
			<input type="hidden" name="id" value="${animal.id}"/>
		</div>
	</body>
</html>