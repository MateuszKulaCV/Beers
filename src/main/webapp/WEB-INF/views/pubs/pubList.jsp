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
<div >
  
       
     <security:authorize access="hasRole('ADMIN')">   <div align="right"><a href="${pageContext.request.contextPath}/pubs/createpub">add pub</a></div></security:authorize>
        <div class="panel-body">
            <c:if test="${empty pubList}">
                There are no Pubs
            </c:if>
            <c:if test="${not empty pubList}">   
                        
                <table class="table "style="background-color: #eaf8fb;">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                    <security:authorize access="hasRole('ADMIN')">    <th>id</th></security:authorize>
              
                <th>pub</th>
                <th>link</th>
             <security:authorize access="hasRole('ADMIN')">   <th>delete</th></security:authorize>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pubList}" var="pub">
                        <tr>
                           <security:authorize access="hasRole('ADMIN')">
                            <th><c:out value="${pub.id}"/></th>
                            </security:authorize>
                            <th><c:out value="${pub.pub}"/></th> 
                            <th><c:out value="${pub.link}"/></th>          
                           <security:authorize access="hasRole('ADMIN')">
                            <th><a href="${pageContext.request.contextPath}/pubs/deletepub/${pub.id}">DELETE</a></th>
                            </security:authorize>                     
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
       
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>