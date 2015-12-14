<!DOCTYPE html>

<html>
<head>
<meta name="layout" content="main" />
<title>Animals Test</title>
<g:javascript library="jquery"></g:javascript>
</head>
<body>
		<g:form name="frmAnimal" action="save" update="">
			Qual animal vc pensou ?<br />
			<input type="text" id="nome" name="nome" value="" /> <br />
			O(a) _____ faz, o(a) ${animal.question}	não? <br />		
			<input type="text" id="carac" name="carac" value="" /> <br />
			<input type="hidden" name="id" value="${animal.id}" />
			<input type="submit" value="Ok" name="Ok" />			
		</g:form>
</body>
</html>