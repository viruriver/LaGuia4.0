<%-- 
    Document   : navBarAnnonimus
    Created on : 22-sep-2018, 19:18:59
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
        <link rel="stylesheet" href="css/LaGuia4.0.min.css">
        
        <!-- library js and css Bootstraps jQuery and popper -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
        <!-- tagib -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">La Guia 4.0</a>
                </div>
              
                <ul class="nav navbar-nav">

                    <li class="active">
                        <a href="index.jsp">Home</a>
                    </li>

                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Comercios
                      <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li><a href="#">Comercios x Categoria</a></li>
                        <li><a href="#">Comercios x Categoria</a></li>
                        <li><a href="#">Comercios x Categoria</a></li>
                        <li><a href="#">Comercios x Categoria</a></li>
                      </ul>
                    </li>

                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Servicios
                      <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li><a href="#">Servicios x Categoria</a></li>
                        <li><a href="#">Servicios x Categoria</a></li>
                        <li><a href="#">Servicios x Categoria</a></li>
                        <li><a href="#">Servicios x Categoria</a></li>
                      </ul>
                    </li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="logIn.jsp"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesion</a></li>
                </ul>
            </div>
        </nav>  
        
        <h1>navBarAnonymous!</h1>
    </body>
</html>
