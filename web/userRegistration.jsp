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

                                    <form method="post" action="loginservel">
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="regNombre">Nombre</label>
                                                <input type="text" class="form-control" id="regRapNombre" name="regRapNombre" placeholder="Nombre">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="regApellido">Apellido</label>
                                                <input type="text" class="form-control" id="regRapApellido" name="regRapApellido" placeholder="Apellido">
                                            </div>
                                        </div>
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="regEmail">Email</label>
                                                <input type="email" class="form-control" id="regRapEmail" name="regRapEmail" placeholder="Email">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="regPassword">Password</label>
                                                <input type="password" class="form-control" id="regRapPassword" name="regRapPassword" placeholder="Password">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="regRePassword">Confirmar Password</label>
                                                <input type="password" class="form-control" id="regRapConfPassword" name="regRapConfPassword" placeholder="Confirmar Password">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="regFecNac">Fecha de Nacimiento</label>
                                            <div class="form-row">
                                                <div class="form-group col-md-2">
                                                    <label for="regRapFecNacDia"><small id="diaHelp" class="form-text text-muted">Dia</small></label>
                                                    <select id="regRapFecNacDia" name="regRapFecNacDia" class="form-control">
                                                        <option selected>Dia</option>
                                                        <c:forEach items="${listDiaNac}" var="d">
                                                            <option id="${d.id}">${d.desc}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="regRapFecNacMes"><small id="mesHelp" class="form-text text-muted">Mes</small></label>
                                                    <select id="regRapFecNacMes" name="regRapFecNacMes" class="form-control">
                                                        <option selected>Mes</option>
                                                        <c:forEach items="${listMesNac}" var="m">
                                                            <option id="${m.id}">${m.desc}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-2">
                                                    <label for="regRapFecNacAño"><small id="añoHelp" class="form-text text-muted">Año</small></label>
                                                    <select id="regRapFecNacAño" name="regRapFecNacAño" class="form-control">
                                                        <option selected>Año</option>
                                                        <c:forEach items="${listAñoNac}" var="a">
                                                            <option id="${a.id}">${a.desc}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="regRapGenero">Genero</label>
                                            <div class="form-row">
                                                <c:forEach items="${listGenero}" var="g">
                                                    <div class="form-group col-md-2">
                                                        <div class="form-check form-check-inline">
                                                          <input class="form-check-input" type="radio" name="regRapGen${g.id}" id="regRapGen${g.id}" value="option${g.id}">
                                                          <label class="form-check-label" for="regRapGen${g.id}">${g.desc}</label>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="regRapPais">Pais</label>
                                                <select id="regRapPais" name="regRapPais" class="form-control">
                                                    <c:forEach items="${listPais}" var="p">
                                                        <option  value="${p.id}">${p.desc}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="regRapProvincia">Provincia</label>
                                                <select id="regRapProvincia" name="regRapProvincia" class="form-control">
                                                    <option selected value="Provincia" id="regProvinciaProvincia">Provincia</option>
                                                    <c:if test = "${listProvincia != 'null' }">  
                                                        <c:forEach items="${listProvincia}" var="pr">
                                                            <option value="${pr.id}" id="regRapProvincia${pr.id}" >${pr.desc}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="regRapLocalidad">Localidad</label>
                                                <select id="regRapLocalidad" name="regRapLocalidad" class="form-control">
                                                    <option selected value="Localidad">Localidad</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-check">
                                              <input class="form-check-input" type="checkbox" id="regRapTerms" name="regRapTerms">
                                              <label class="form-check-label" for="regRapTerms"> Acepto los terminos y condiciones. </label>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-2 ml-auto">
                                                <input hidden="true" name="registracion" value="rapida">
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js"></script>

        <%--
        <!-- (Optional) Latest compiled and minified JavaScript translation files -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/i18n/defaults-*.min.js"></script>
        --%>
        <script type="text/javascript">
            
            $('#regRapProvincia').change(function () {
                var selectedValue = this.value;
                var optionId = 'regRapProvincia' + selectedValue.toString();
                var optionText = document.getElementById(optionId).text;

                if (selectedValue === 'Provincia') {
                    $('#regRapLocalidad').empty();
                    $('#regRapLocalidad').append($('<option/>', {
                                value : 'Localidad',
                                text : 'Localidad'
                            }));
                } else {
                    $.ajax({
                        type:'POST',
                        url: 'UserRegistrationServlet',
                        datatype: 'json',
                        data:'actualizarLocalidades='+$('#regRapProvincia').val(),
                        statusCode:{
                            404: function(){
                                alert('Pagina no Encontrada');
                            },
                            500: function(){
                                alert ('Error del Servidor');
                            }
                        },
                        success: function(lista){
                            console.log(lista);
                            $('#regRapLocalidad').empty();


                            $.each(lista, function(key, value) {
                                $('#regRapLocalidad').append($('<option/>', {
                                    value : value['id'],
                                    text : value['desc'],
                                    id : value ['id']
                                }));
                            });
                            }
                    });
                }
            });
            
        </script>
        
    </body>
</html>
