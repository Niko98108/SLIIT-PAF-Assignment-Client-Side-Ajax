<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Management</title>
<style>
.body{
zoom:90%;
}
</style>
</head>
<link href="Views/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/project.js"></script>

<body>
<nav class="navbar  navbar-expand-sm navbar-dark bg-primary">
	<!-- Navbar content -->
	<div class="container-fluid">
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item">
				  <a class="nav-link active" aria-current="page" href="#">Projects</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="#">Managers</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
<div class="container-sm">
	<h4 class="m-4">Project Management</h4><hr>

		<form name="formProject"  id="formProject" class="m-4">
			<div class="row">
				<div class="col-sm-2 ">
					<label for="projectName" class="col-form-label"> Project Name</label>
				</div>
				<div class="col-sm-10 mb-3">
					<input type="text" class="form-control" name="projectName" id="projectName" >
					<input  type="hidden" name="hidProjIDSave" id ="hidProjIDSave" >
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 ">
					<label for="projectType" class="col-form-label"> Project Type</label>
				</div>	
					<div class="col-sm-10 mb-3">
						<select class="form-select" name="projectType" id="projectType">
							<option selected>Open this select menu</option>
							<option value="1">Paid</option>
							<option value="2">UnPaid</option>
							<option value="parttime">Part Time</option>
						
						  </select>
					</div>	
			</div>
			<div class="row">
				<div class="col-sm-2 ">
					<label for="projectDesc" class="col-form-label"> Project Description</label>
				</div>
				<div class="col-sm-10 mb-3">
					<input type="text" class="form-control" name="projectDesc" id="projectDesc" >
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 ">
					<label for="managerId" class="col-form-label"> Manager ID</label>
				</div>
				<div class="col-sm-3 mb-3">
					<select class="form-select" name="managerId" id="managerId">
					<option value="" selected="selected">Select ID</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="123">123</option>
					  </select>
				</div>
				<div class="col-sm-2 ">
					<label for="nanagerName" class="col-form-label"> Manager Name</label>
				</div>
				<div class="col-sm-5 mb-3">
					<input type="text" class="form-control" name="managerName" id="managerName" readonly="readonly">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 ">
					<label for="startDate" class="col-form-label">Start Date</label>
				</div>
				<div class="col-sm-4 mb-3">
					<input type="date" class="form-control" name="startDate" id="startDate">
				</div>
				<div class="col-sm-2 ">
					<label for="endDate" class="col-form-label"> End Date</label>
				</div>
				<div class="col-sm-4 mb-3">
					<input type="date" class="form-control" name="endDate" id="endDate">
				</div>
			</div>
			<div class="float-end " >
				<button type="button" name="btnSubmit" id="btnSave" class="btn btn-primary " style="width: 100px;"> Save </button>
			</div>
		</form>
		
		<br>
		<div class="alert alert-success"  id="alertSuccess"></div>
		<div class="alert alert-danger"  id="alertError"> </div>
		<br>
		<div id= "divProjectGrid">
		<%
		Project projectObj = new Project();
		out.print(projectObj.readProject());
		%>
		</div>
</div>
</body>
</html>