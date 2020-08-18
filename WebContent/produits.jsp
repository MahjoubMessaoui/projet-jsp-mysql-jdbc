<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta http-equiv="content-type" content="text/html">
<title>Produits</title>
<!-- <link rel ="stylesheet" type="text/css" href="/css/bootstrap.min.css"/> -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
 
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-10 col-md-offset-1">
    <div class="panel panel-primary">
      <div class="panel-heading" style="background-color: blue;">Recherche des produits</div>
      <div class="panel-body">
      
      
<form action="chercher.php" method="get">
<label>Mot Clé</label>
<input type="text" name="motCle" value="${model.motCle}">
<button type="submit" class ="btn btn-primary">Chercher</button>
</form>
<table class="table table-striped">
<tr>
 
<th>ID</th>
<th>Designation</th>
<th>Prix</th>
<th>Quantite</th>
 </tr>
 
<c:forEach items="${model.produits}" var ="p">
<tr>
<td>${p.id}</td>
<td>${p.designation}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td><a onclick="return confirm('Etes vous sur?')" href="Supprimer.php?id=${p.id}">Supprimer</a></td>
<td><a href="Edit.php?id=${p.id}">Edit</a></td>
</tr>
</c:forEach>

</table>
</div>


    </div>
</div>
</div>
</body>
</html>