/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author richard
 */
@WebServlet(name = "Olar", urlPatterns = {"/Olar"})
public class Olar extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Olar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastrar Usuário</h1>");
            out.println("<form action='add' method='POST'>");
            out.println("Name: <input type='text' name='name' > <br/>");
            out.println("Username: <input type='text' name='username' > <br/>");
            out.println("Password: <input type='text' name='password' > <br/>");
            out.println("Age: <input type='text' name='age' > <br/>");
            out.println("Address: <input type='text' name='address' > <br/>");
            out.println("Max Guests: <input type='text' name='max_guests' > <br/>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
