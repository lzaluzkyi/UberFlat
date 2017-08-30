<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="/WEB-INF/tags/implicit.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Apartments</title>
</head>
<body>

	<div class="container">
	<div class="row">
			<div class="col-sm-12">
			
				<table class="table table-bordered">
					<tr>
						<th>Photo</th>
						<th>Price</th>
						<th>Rate</th>
						<th>Rooms</th>
						<th>Area</th>
						<th>Street</th>
						<th>Number</th>
						<th>User</th>
						<th>email</th>
						<th>phone</th>
					</tr>
				
						<tr>
							<td><img alt="Apartment image" src="data:image/jpeg;base64,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"></td>
							<td>${apartment.price} uah ${apartment.rentType.name}</td>
							<td>${apartment.rate}</td>
							<td>${apartment.rooms}</td>
							<td>${apartment.area.name}</td>
							<td>${apartment.street.name}</td>
							<td>${apartment.number}</td>
							<td><a href="/user/${apartment.owner.id}">${apartment.owner.fullName}</a></td>
							<td>${apartment.owner.email}</td>
							<td>${apartment.owner.phone}</td>
						
						</tr>
						<tr>
						<th>description</th>
						</tr>
							<tr>
					<td  type="text">${apartment.description}</td>
					</tr>
					</table>
					</div>
					</div>
					
					
					<div class="row">
				
    
						<form:form class="form-horizontal" modelAttribute="order" action="/apartmentMain/${apartment.id}/addOrder" method="POST">
								
		<div class="col-sm-6">

      <div id="datetimepicker2" class="input-append date">
      <form:input type="text" path="start" id="start"/>
      <span class="add-on">
        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
      </span>
    </div>
    <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
    <script type="text/javascript">
      $('#datetimepicker2').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language: 'pt-BR'
      });
    </script>
    </div>
    		<div class="col-sm-6">
       <div id="datetimepicker" class="input-append date">
        <form:input type="text" path="end" id="end"/>
      <span class="add-on">
        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
      </span>
    </div>
    <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
    <script type="text/javascript">
      $('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language: 'pt-BR'
      });
    </script>
    </div>
    <label for="order" class="control-label col-sm-2">order</label>
   
							
								<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-success" type="submit">ORDER</button>
							</div>
   
					
				</div>	
				  </form:form>
<!-- 				 <table class="table table-bordered"> -->
<!-- 					<tr> -->
<!-- 				<th>order</th> -->
<!-- 						</tr> -->
<%-- 						<c:forEach var="_order" items="${orders}"> --%>
<!-- 							<tr> -->
<%-- 					<td type="text">${order.start}</td> --%>
<!-- 					</tr> -->
<%-- 					</c:forEach> --%>
<!-- 					</table> -->
				  
				</div>
					<div class="row">
			<div class="col-sm-12">
			
				<table class="table table-bordered">
					<tr>
				<th>coment</th>
						</tr>
						<c:forEach var="comentForApartment" items="${comentForApartments}">
							<tr>
					<td type="text">${comentForApartment.coment}</td>
					</tr>
					</c:forEach>
					</table>
				</div>
			</div>
			
			<div class="row">
			<div class="col-sm-12">
			
						<form:form class="form-horizontal" modelAttribute="comentForApartment" action="/apartmentMain/${apartment.id}/addcoment" method="POST">
					<div class="col-sm-10 col-sm-offset-2" style="color: red;">
							<form:errors path="coment" />
						</div>
					<label for="coment" class="control-label col-sm-2">coment</label>
							<div class="col-sm-10">
								<form:textarea path="coment" id="coment" class="form-control" rows="5"/>
							</div>
								<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-success" type="submit">Add Coment</button>
							</div>
							</div>
					</form:form>
					
					</div>
			</div>
	
		</div>
</body>
</html>