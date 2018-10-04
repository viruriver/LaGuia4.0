<%-- 
    Document   : logIn
    Created on : 22-sep-2018, 19:19:56
    Author     : ElViru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>La Guia 4.0</title>
        
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- personal stylesheet -->
        <link rel="stylesheet" href="css/LaGuia4.0.min.css">
        
        <!-- 
        <link rel="stylesheet" href="css/bootstrap.min.css">
        -->
        
        <!-- library js and css Bootstraps jQuery and popper -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        
        <!-- tagib -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <jsp:include page="navBar.jsp"/>

            <div class="container">
        
                <h1>User LogIn!</h1>

                <div class="">
                </div>
                
                <div class="row">

                    <div class="container ml-auto col-lg-8">
                    </div>

                    <div class="container ml-auto col-lg-4">
                        <div class="card text-center">
                            <div class="card-body">
                                <div class="p-2">
                                    <h4>
                                        Iniciar Sesion
                                        <i class="fas fa-sign-in-alt"></i>                                        
                                    </h4>
                                </div>

                                <form>
                                  <div class="form-group">

                                    <input type="email" class="form-control" id="logEmail" aria-describedby="emailHelp" placeholder="Email">
                                  </div>
                                  <div class="form-group">
                                    <input type="password" class="form-control" id="logPass" placeholder="Password">
                                  </div>
                                  <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                  </div>
                                  <button type="submit" class="btn btn-primary btn-block">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        
        
        
        
        <!-- library js and css Bootstraps jQuery and popper -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
    </body>
</html>
