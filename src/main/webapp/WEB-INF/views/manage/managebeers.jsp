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
<body class=".container">
   
        <security:authorize access="hasRole('MANAGER')"><div align="right"><a href="${pageContext.request.contextPath}/manage/beers/add">add beer</a></div></security:authorize>
        <div class="panel-body">
            <c:if test="${empty beerList}">
                There are no Beers
            </c:if>
            <c:if test="${not empty beerList}">   
                        
                 <table class="table " style="background-color: #eaf8fb;" >
                    <thead style="background-color: #bce8f1;">
                    <tr>
                     <security:authorize access="hasRole('MANAGER')">   <th>id</th></security:authorize>
                <th>piwo</th>
                <th>pub</th>
                <th>link</th>
                <th>progress</th>
                <th>half</th>
                <th>three</th>
                <security:authorize access="hasRole('MANAGER')"><th>delete</th></security:authorize>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${beerList}" var="beer">
                        <tr>
                       	 	<security:authorize access="hasRole('MANAGER')">
                            	<th><c:out value="${beer.id}"/></th>
                        	</security:authorize>
                            <th><c:out value="${beer.piwo}"/></th>
                            <th><c:out value="${beer.pub}"/></th>
                            <th><c:out value="${beer.link}"/></th>          
                            <th><c:out value="${beer.progress}"/></th>
                            <th><c:out value="${beer.halfprice}"/></th>
                            <th><c:out value="${beer.threeprice}"/></th>              
							<security:authorize access="hasRole('MANAGER')">
								<th><a href="${pageContext.request.contextPath}/manage/beers/delete/${beer.id}">DELETE</a></th>                     
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