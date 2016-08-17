<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BeerList</title>
    </head>
    <body>
        <div align="center">
            <h1>Beer List</h1>
            <table border="1">
                <th>id</th>
                <th>piwo</th>
                <th>pub</th>
                <th>link</th>
                <th>progress</th>
                <th>half</th>
                <th>three</th>
                 
                <c:forEach var="beer" items="${beerList}">
                <tr>
                    <td>${beer.id}</td>
                    <td>${beer.piwo}</td>
                    <td>${beer.pub}</td>
                    <td>${beer.link}</td>
                    <td>${beer.progress}</td>
                    <td>${beer.halfprice}</td>
                    <td>${beer.threeprice}</td>         
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>