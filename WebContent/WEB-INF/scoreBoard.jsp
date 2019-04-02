<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8"/>
  <link  type="text/css" href="resources/css/Naakon.css" rel="stylesheet"/>
  <Title>ScoreBoard</Title>
</head>
<body>
	<!-- bandeau horizontal -->
	<%@include file="bandeauh.jsp"%>

	<!-- bandeau vertical -->
	<%@include file="bandeauv.jsp"%>

	<!-- page -->
	<div class="page">
	
	<div class="titrep">Tableau des scores</div>
	
		<table class="scores" >
			<tr>
				<td>Map</td><td>Joueur</td><td>Résultat</td><td>Score</td><td>Date</td>
			</tr>
			
					
    		<c:forEach items="${scores}" var="elt">
    		
    			<tr>
					<td>${ elt.map }</td>
					<td>${ elt.joueur }</td>
					<td>${ elt.resultat }</td>
					<td>${ elt.score }</td>
					<td>${ elt.date }</td>
				</tr>
				
    		</c:forEach>
		
		</table>
		
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