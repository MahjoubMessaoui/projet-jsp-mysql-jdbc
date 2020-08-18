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
	<%@include file="header.jsp"%>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading" style="background-color: blue;">Saisie d'un
				produit</div>
			<div class="panel-body">


				<form action="updateProduit.php" method="post">
				
				<div class="form-group">
						<label class="control-label">ID:</label>
						<input type="text" name="id"
							value="${produit.id}" class="form-control" required="required" /> <span></span>
					</div>
				
					<div class="form-group">
						<label class="control-label">Désignation</label>
						<input type="text" name="designation"
							value="${produit.designation}" class="form-control" required="required" /> <span></span>
					</div>

					<div class="form-group">
						<label class="control-label">Prix</label> <input type="text"
							name="prix" value="${produit.prix}" class="form-control" /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantite</label> <input type="text"
							name="quantite" value="${produit.quantite}" class="form-control" />
						<span></span>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>


				</form>


			</div>


		</div>
	</div>
	</div>
</body>


</html>