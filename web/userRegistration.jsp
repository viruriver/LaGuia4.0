<%-- 
    Document   : userRegistration
    Created on : 27-sep-2018, 5:27:00
    Author     : ElViru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        
        
        
        
        
        
        <title>JSP Page</title>
        
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
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css">

        <!-- tagib -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        
        <jsp:include page="navBar.jsp"/>

        <div class="container">

            <h1>User Registration!</h1>

            <div class="">
            </div>

            <div class="row">
                <div class="container ml-auto col-lg-8">
                    <div class="card text-rigt">
                        <div class="card-body">
                            <div class="pt-2 pb-4 px-2">
                                <h4>Registracion
                                    <i class="fas fa-sign-in-alt"></i>
                                </h4>
                            </div>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                              <li class="nav-item">
                                <a class="nav-link active" id="liRegRapida" data-toggle="tab" href="#regRapida" role="tab" aria-controls="regRapida" aria-selected="true">Rapida</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" id="liRegCompleta" data-toggle="tab" href="#regCompleta" role="tab" aria-controls="regCompleta" aria-selected="false">Completa</a>
                              </li>
                            </ul>
                            <div class="tab-content" id="registrationTabContent">
                                <div class="tab-pane fade show active p-2 pt-4" id="regRapida" role="tabpanel" aria-labelledby="home-tab">

                                    <form method="post" action="LoginAuthServlet">
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="regNombre">Nombre</label>
                                                <input type="text" class="form-control" id="regNombre" placeholder="Nombre">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="regApellido">Apellido</label>
                                                <input type="text" class="form-control" id="regApellido" placeholder="Apellido">
                                            </div>
                                        </div>
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="regEmail">Email</label>
                                                <input type="email" class="form-control" id="regEmail" placeholder="Email">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="regPassword">Password</label>
                                                <input type="password" class="form-control" id="regPassword" placeholder="Password">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="regRePassword">Confirmar Password</label>
                                                <input type="password" class="form-control" id="regRePassword" placeholder="Password">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="regFecNac">Fecha de Nacimiento</label>
                                            <div class="form-row">
                                                <div class="form-group col-md-2">
                                                    <label for="regFecNacDia"><small id="diaHelp" class="form-text text-muted">Dia</small></label>
                                                    <select id="regFecNacDia" class="form-control">
                                                        <option selected>Dia</option>
                                                        <c:forEach items="${listDiaNac}" var="d">
                                                            <option id="${d.id}">${d.desc}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="regFecNacMes"><small id="mesHelp" class="form-text text-muted">Mes</small></label>
                                                    <select id="regFecNacMes" class="form-control">
                                                        <option selected>Mes</option>
                                                        <c:forEach items="${listMesNac}" var="m">
                                                            <option id="${m.id}">${m.desc}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-2">
                                                    <label for="regFecNacAño"><small id="añoHelp" class="form-text text-muted">Año</small></label>
                                                    <select id="regFecNacAño" class="form-control">
                                                        <option selected>Año</option>
                                                        <c:forEach items="${listAñoNac}" var="a">
                                                            <option id="${a.id}">${a.desc}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="regFecNac">Genero</label>
                                            <div class="form-row">
                                                <c:forEach items="${listGenero}" var="g">
                                                    <div class="form-group col-md-2">
                                                        <div class="form-check form-check-inline">
                                                          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="regRapGen${g.id}" value="option${g.id}">
                                                          <label class="form-check-label" for="regRapGen${g.id}">${g.desc}</label>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="regPais">Pais</label>
                                                <select id="regPais" class="form-control">
                                                        <c:forEach items="${listPais}" var="p">
                                                            <option  value="${p.id}">${p.desc}</option>
                                                        </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="regProvincia">Provincia</label>
                                                <select id="regProvincia" class="form-control">
                                                <option selected>Provincia</option>
                                                <c:if test = "${listProvincia != 'null' }">  
                                                    <c:forEach items="${listProvincia}" var="pr">
                                                        <option value="${pr.id}">${pr.desc}</option>
                                                    </c:forEach>
                                                </c:if>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="regLocalidad">Localidad</label>
                                                <select id="regLocalidad" class="form-control">
                                                    <option selected>Localidad</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-check">
                                              <input class="form-check-input" type="checkbox" id="regTerms">
                                              <label class="form-check-label" for="regTerms"> Acepto los terminos y condiciones. </label>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-2 ml-auto">
                                                <input hidden="true" name="regTipo" value="rapida">
                                                <button type="submit" class="btn btn-primary ml-auto">Registrarse</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="tab-pane fade p-2 pt-4" id="regCompleta" role="tabpanel" aria-labelledby="profile-tab">
                                                Registracion Completa
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container ml-auto col-lg-4">
                    <div class="card text-rigt">
                        <div class="card-body">
                            <div class="p-2">
                                <h4>
                                    Registrarse!!                                      
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            
        </div>
        
        
          

        <!-- library js and css Bootstraps jQuery and popper -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js"></script>

        <!-- (Optional) Latest compiled and minified JavaScript translation files -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/i18n/defaults-*.min.js"></script>
        
        <script type="text/javascript">
            
            
        </script>
        
    </body>
</html>
