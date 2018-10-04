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

/**
 *
 * @author ElViru
 */
@WebServlet(name = "UserRegistrationServlet", urlPatterns = {"/UserRegistrationServlet"})
public class UserRegistrationServlet extends HttpServlet {
    
    
    DaoPaisProvinciaCiudad daoPPC = new DaoPaisProvinciaCiudad();
    List<PaisProvinciaCiudad> listLocalidades = new ArrayList(daoPPC.getPaisProvinciaCiudadALL());
    
    DaoFechaDdMmmmAaaa daoFecha = new DaoFechaDdMmmmAaaa();
    List<FechaDdMmmmAaaa> listFechas = new ArrayList(daoFecha.getFechaDdMmmmAaaaALL());
    
    List<GenericClass> listGenero = new ArrayList(Dao.getSelectAll(SQLMappingTable.SQL_DIM_GENERO));
    
    
    
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
            
            request.setAttribute(RequestMapping.REQUEST_LIST_LOCALIDADES, listLocalidades);
            request.setAttribute(RequestMapping.REQUEST_LIST_FECHAS, listFechas);
            request.setAttribute(RequestMapping.REQUEST_LIST_GENEROS, listGenero);
            
            getServletContext().getRequestDispatcher("/userRegistration.jsp").forward(request, response);
        }
        else{
            
            response.sendRedirect("index.jsp");
        }
    }
    
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
