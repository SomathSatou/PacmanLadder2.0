<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="fr-FR">
<head>
<meta charset="utf-8" />
<link type="text/css" href="resources/css/Naakon.css" rel="stylesheet" />
<Title>MR Fromage</Title>
</head>
<body>
	<!-- bandeau horizontal -->
	<%@include file="bandeauh.jsp"%>

	<!-- bandeau vertical -->
	<%@include file="bandeauv.jsp"%>

	<!-- page -->
	<div class="page">
		<div class="titrep">Inscription</div>
		<!-- contenue de la page -->
		<div>
			<p>Bienvenue ${ pseudo } votre inscription est confirmé.</p>

		</div>
		<!-- bandeau bas de page -->
		<a Class="bandeaub"
			href="http://jigsaw.w3.org/css-validator/check/referer"> <img
			style="border: 0; width: 88px; height: 31px"
			src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
			alt="CSS Valide !" />
		</a>
		</p>
	</div>
</body>
</html>
