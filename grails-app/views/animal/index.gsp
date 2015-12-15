<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Animals Test</title>
		<g:javascript library="jquery"></g:javascript>
	</head>
	<body>
		<div id="divMain">
			<h1> Welcome to Animals Test</h1>
			<g:link action="play" controller="animal">
			<input type="button" value="Play" class="button"/>
			</g:link>
			<g:link action="clear" controller="animal">
			<input type="button" value="Clear Database" class="button"/>
			</g:link>
		</div>
	</body>
</html>