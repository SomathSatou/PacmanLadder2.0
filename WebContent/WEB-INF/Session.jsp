<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8"/>
  <link  type="text/css" href="resources/css/Naakon.css" rel="stylesheet"/>
  <Title>MR Fromage</Title>
</head>
<body>
	<!-- bandeau horizontal -->
	<%@include file="bandeauh.jsp"%>

	<!-- bandeau vertical -->
	<%@include file="bandeauv.jsp"%>

	<!-- page -->
	<div class="page">
			<c:choose>
		    <c:when test="${session.login==true}">
		    	<div class="titrep">Connexion</div>
			    <div>
					<p>bienvenue <c:out value="${ session.pseudo }"/> </p> 
			    </div>
		    </c:when>    
		    
		    <c:otherwise>
			    <div class="titrep">Connexion non valide</div>
				<div>
				<p>Désolé <c:out value="${ pseudo }" /> nous ne vous connaissons pas.</p>
				
				<p>Pour vous inscrire cliquez <a href="/Pacman/inscription">ici</a></p>
		</div>
		    <br />
		    </c:otherwise>
		</c:choose>	
		<!-- contenue de la page -->

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