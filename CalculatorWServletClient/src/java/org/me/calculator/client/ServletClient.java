/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.me.calculator.CalculatorWS_Service;

/**
 *
 * @author Muhamedhine
 */
@WebServlet(name = "ServletClient", urlPatterns = {"/ServletClient"})
public class ServletClient extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CalculatorWSAplication/CalculatorWS.wsdl")
    private CalculatorWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
         float a,b,c;
         
                 
                 
         a= Double.valueOf(request.getParameter("Note_1")).floatValue();
         b= Double.valueOf(request.getParameter("Note_2")).floatValue();
         c= Double.valueOf(request.getParameter("Note_3")).floatValue();
            
            /* TODO output your page here. You may use following sample code. */
            //out.println(" la somme est :" + addition (100,5));
           // out.println("le reste est :" + soustration (300,3));
            out.println("la moyenne est:"+ moyenne(a,b,c));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletClient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int addition(int e1, int e2) {
       
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.addition(e1, e2);
    }

    private int soustration(int e1, int e2) {
        
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.soustration(e1, e2);
    }

    private float moyenne(float e1, float e2, float e3) {
       
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.moyenne(e1, e2, e3);
    }
 
    
}
