<%--
  User: Ranga Reddy
  Date: 09/05/2015
  Time: 6:52 PM
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employees List</title>
    
    
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
 
</head> 
<body>
<div class="container">

<div class="panel-group" id="accordion">
<c:forEach items="${out}" var="out">

	 <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
        <img src="${out.key.link}" height="50" width="50"/>
          <a data-toggle="collapse" data-parent="#accordion" href="#${out.key.id}"><c:out value="${out.key.pub}"/></a>
        </h4>
      </div>
      <div id="${out.key.id}" class="panel-collapse collapse out">
        <div class="panel-body">
        	<table class="table" id="example">
        	<thead>
        	<tr>
        	<th></th>
        	<th>nazwa</th>
        	<th>cena</th>
        	<th>progress</th>
        	</tr>
        	</thead>
        	<tbody>
        	
        	<c:forEach items="${out.value}" var="beer">
        	<tr>
        		<th><img src="${beer.link}" height="50" width="50"/></th>
        		<th><c:out value="${beer.piwo}"/></th>
        		<th><c:out value="${beer.halfprice}"/></th>
        		<th><c:out value="${beer.progress}"/></th>
        		 </tr>
        	</c:forEach>
   
     </tbody>
      </table>
      
        </div>
      </div>
    </div>
</c:forEach>

  </div>

  </div>

  
       
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>
</body>
</html>