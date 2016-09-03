<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
   <!-- Latest compiled and minified CSS -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/jquery.searchable.js" />"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->


<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<tilesx:useAttribute name="current"/>

<style type="text/css">
body {
  padding-top: 20px;
  padding-bottom: 20px;
}
.navbar {
  margin-bottom: 20px;
}

</style>
</head>
  
<body>
		
		<div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <p1 class="navbar-brand">Beers</p1>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
          <!-- left side -->
            <ul class="nav navbar-nav">
              <li class="${current== 'home'?'active' : '' }"><a href="${pageContext.request.contextPath}/">Home</a></li>
               <security:authorize access="isAuthenticated()">
              <li class="${current== 'fav'?'active' : '' }"><a href="${pageContext.request.contextPath}/fav">Favorite</a></li>
              </security:authorize>
              <li class="${current== 'pubs'?'active' : '' }"><a href="${pageContext.request.contextPath}/pubs">Pubs</a></li>
            </ul>
            
            
            <!-- right side navbar -->
            <ul class="nav navbar-nav navbar-right">
             <security:authorize access="hasRole('ADMIN')"> <li class="${current== 'admin'?'active' : '' }"><a href="${pageContext.request.contextPath}/admin">Admin</a></li></security:authorize>
             <security:authorize access="hasRole('MANAGER')"> <li class="${current== 'manage'?'active' : '' }"><a href="${pageContext.request.contextPath}/manage">Manage</a></li></security:authorize>
            <security:authorize access="! isAuthenticated()">
              <li class="${current== 'login'?'active' : '' }"><a href="${pageContext.request.contextPath}/login">Login</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">
               <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
               </security:authorize>
            
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
      

   
             <div class="jumbotron">
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         </div>
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
         </div> <!-- /container -->
</body>
</html>