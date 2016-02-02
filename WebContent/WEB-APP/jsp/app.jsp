<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">

<head>
   <title>App Demo</title> 
   <jsp:include page="fragments/styles-reference.jsp"></jsp:include>
</head>
<body> 
    <div class="page-frame" ng-controller="PageController">       
       <div id="navigation-bar">
	       	<div class="btn-group">
		        <a href="#/welcome" class="btn btn-primary" ng-model="radioModel" btn-radio="'Left'">Welcome</a>		       
		        <a href="#/home" class="btn btn-primary" ng-model="radioModel" btn-radio="'Middle'">Home</a>
		        <a href="#/google-chart" class="btn btn-primary" ng-model="radioModel" btn-radio="'Right'">Google Chart</a>
	        </div>
        </div>
        <div ng-view></div>
   </div>     
   <jsp:include page="fragments/scripts-reference.jsp"></jsp:include>   
   <script src="<spring:url value="/WEB-APP/resources/scripts/app/models/user.js" />"></script>
   <script src="<spring:url value="/WEB-APP/resources/scripts/app/controllers/welcome-controller.js" />"></script>
   <script src="<spring:url value="/WEB-APP/resources/scripts/app/controllers/home-controller.js" />"></script>
   <script src="<spring:url value="/WEB-APP/resources/scripts/app/controllers/chart-controller.js" />"></script>
   
</body>
</html>