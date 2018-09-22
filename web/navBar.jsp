<%-- 
    Document   : navBar
    Created on : 22-sep-2018, 19:17:51
    Author     : ElViru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- personal stylesheet -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/segundoParcial.min.css">
        
        <!-- library js and css Bootstraps jQuery and popper -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
        <!-- tagib -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
    </head>
    <body>
        
        <c:choose>
            <c:when test = "${logUserType == 'Admin'}">
                <jsp:include page="navBar-Admin.jsp"/>
            </c:when>
        
            <c:when test = "${logUserType == 'User'}">
                <jsp:include page="navBar-User.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="navBar-Anonymous.jsp"/>
            </c:otherwise>
        </c:choose>
    
    </body>
</html>