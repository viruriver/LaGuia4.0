/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import DAO.Dao;
import DAO.DaoFechaDdMmmmAaaa;
import DAO.DaoPaisProvinciaCiudad;
import Domain.FechaDdMmmmAaaa;
import Domain.GenericClass;
import Domain.PaisProvinciaCiudad;
import Domain.RequestMapping;
import Domain.SQLMappingTable;
import Domain.SessionMapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import com.google.gson.Gson;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;



/**
 *
 * @author ElViru
 */
@WebServlet(name = "UserRegistrationServlet", urlPatterns = {"/UserRegistrationServlet"})
public class UserRegistrationServlet extends HttpServlet {
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserRegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserRegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logUser = (String) request.getSession().getAttribute(SessionMapping.SESSION_LOG_USER);
        
        
        if (logUser == null) {
            
            registracionRapidaForm(request, response);
            
            getServletContext().getRequestDispatcher("/userRegistration.jsp").forward(request, response);
        }
        else{
            
            response.sendRedirect("/index.jsp");
        }
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String logUser = "annonimous";
        String registracion = "validar";
        int codProvincia=0;
        
      
        if(request.getSession().getAttribute(SessionMapping.SESSION_LOG_USER) != null){
            logUser = (String) request.getSession().getAttribute(SessionMapping.SESSION_LOG_USER);
        }
        
        if(request.getParameter("actualizarLocalidades") != null){
            codProvincia = Integer.parseInt(request.getParameter("actualizarLocalidades"));
        }
        
        if(request.getParameter("registracionRapida") != null){
            registracion = request.getParameter("registracionRapida");
            codProvincia=0;
        }
        if(request.getParameter("registracionCompleta") != null){
            registracion = request.getParameter("registracionCompleta");
            codProvincia=0;
        }
        
        

        if(codProvincia>0){
            List<GenericClass> listLocalidadJava = new ArrayList(Dao.getSelectAllWhereCond(SQLMappingTable.SQL_DIM_LOCALIDAD, codProvincia ));
            ordenarListaId(listLocalidadJava, true);

            Gson ListLocalidades = new Gson();
            String jsonListLocalidades = ListLocalidades.toJson(listLocalidadJava);

            response.setContentType("application/json");

            PrintWriter out = response.getWriter();
            out.write(jsonListLocalidades);
        }
        
        
        
        if (logUser.equalsIgnoreCase("annonimous")) {
                
                String regformNombre = request.getParameter("regNombre"); 
                String regformApellido = request.getParameter("regApellido"); 
                String regformEmail = request.getParameter("regEmail"); 
                String regformPassword = request.getParameter("regPassword"); 
                
                if(registracion.equalsIgnoreCase("completa")){
                    
                    String regformAño = request.getParameter("regFecNacAnio"); 
                    String regformMes = request.getParameter("regFecNacMes"); 
                    String regformDia = request.getParameter("regFecNacDia"); 

                    String regformFecNac = regformAño + regformMes + regformDia;

                    int fechaNacId = Integer.parseInt(regformFecNac);

                    int regformGenero = Integer.parseInt(request.getParameter("regGenero"));


                    int regformPais = Integer.parseInt(request.getParameter("regPais")); 
                    int regformProvincia = Integer.parseInt(request.getParameter("regProvincia")); 
                    int regformLocalidad = Integer.parseInt(request.getParameter("regLocalidad")); 

                }
                
                
                int breakPoint = 0;
                
        }
        else{
            response.sendRedirect("/index.jsp");
        }
         
    }
    
    
    
    
    
    
    
    private void registracionRapidaForm(HttpServletRequest request, HttpServletResponse response){
        
            List<GenericClass> listGenero = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_GENERO));
            List<GenericClass> listAñoNac = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_FECHA_ANIO));
            List<GenericClass> listMesNac = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_FECHA_MES));
            List<GenericClass> listDiaNac = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_FECHA_DIA));
            List<GenericClass> listPais = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_VIEW_PAIS));
            List<GenericClass> listProvincia = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_VIEW_PROVINCIA));
    
            /*ordenarListaDesc(listGenero);*/
            request.setAttribute(RequestMapping.REQUEST_LIST_GENEROS, listGenero);
            
            ordenarListaId(listAñoNac, false);
            request.setAttribute(RequestMapping.REQUEST_LIST_ANIO_NAC, listAñoNac);
            
            ordenarListaId(listMesNac,true);
            request.setAttribute(RequestMapping.REQUEST_LIST_MES_NAC, listMesNac);
            
            ordenarListaId(listDiaNac, true);
            request.setAttribute(RequestMapping.REQUEST_LIST_DIA_NAC, listDiaNac);
                        
            ordenarListaDesc(listPais, true);
            request.setAttribute(RequestMapping.REQUEST_LIST_VIEW_PAIS, listPais);
            
            ordenarListaDesc(listProvincia, true);
            request.setAttribute(RequestMapping.REQUEST_LIST_VIEW_PROVINCIA, listProvincia);
    }
    
    
    private void ordenarListaId(List list,boolean order){
        if(order){
            Collections.sort(list, new Comparator<GenericClass>() {
                @Override
                public int compare(GenericClass g1, GenericClass g2){
                    return new Integer(g1.getId()).compareTo(new Integer(g2.getId()));
                }
            });
        }else{
            Collections.sort(list, new Comparator<GenericClass>() {
                @Override
                public int compare(GenericClass g1, GenericClass g2){
                    return new Integer(g2.getId()).compareTo(new Integer(g1.getId()));
                }
            });
        }
    }
    
    
    private void ordenarListaDesc(List list,boolean order){
        if(order){
            Collections.sort(list, new Comparator<GenericClass>() {
                @Override
                public int compare(GenericClass g1, GenericClass g2){
                    return g1.getDesc().compareTo(g2.getDesc());
                }
            });
        }else{
            Collections.sort(list, new Comparator<GenericClass>() {
                @Override
                public int compare(GenericClass g1, GenericClass g2){
                    return g2.getDesc().compareTo(g1.getDesc());
                }
            });
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
