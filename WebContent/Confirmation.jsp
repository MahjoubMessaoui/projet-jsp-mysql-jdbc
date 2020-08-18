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
			<div class="panel-heading" style="background-color: blue;">Confirmation
				produit</div>
			<div class="panel-body">

				<div class="form-group">
					<label>ID</label>
					 <label>${produit.id}</label>
				</div>


				<div class="form-group">
					<label>Designation</label> 
					<label>${produit.designation}</label>
				</div>


				<div class="form-group">
					<label>Prix</label>
					 <label>${produit.prix}</label>
				</div>



				<div class="form-group">
					<label>Quantite</label> 
					<label>${produit.quantite}</label>
				</div>

			</div>


		</div>
	</div>
	</div>
</body>


</html>