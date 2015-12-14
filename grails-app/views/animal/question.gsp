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
			<h1>O animal que voce pensou é o(a) ${animal.question} ?</h1>
			<g:link action="yesQuestion">
			<input type="button" value="Yes" class="button"/>
			</g:link>
			<g:link action="noQuestion" params="[id: animal.id]">
			<input type="button" value="No" class="button"/>
			</g:link>
			<input type="hidden" name="id" value="${animal.id}"/>
		</div>
	</body>
</html>