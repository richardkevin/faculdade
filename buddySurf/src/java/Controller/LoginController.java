/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author richard
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login", "/login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //request.getRequestDispatcher("/login.jsp").forward(request, response);;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Session session = HibernateSessionFactory.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List result = session.getNamedQuery("Users.findByUsername").setString("username", username).list();
        request.setAttribute("error", null);
        
        if (result.isEmpty()){
            request.setAttribute("error", "Usuário inválido");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }
        else{
            Users user = (Users) result.get(0);
            if (user.getPassword().equals(password)){
                String name = user.getName();
                request.setAttribute("data", "Bem vindo" + name);
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("name", name);

                request.getRequestDispatcher("/header.jsp").include(request, response);
                response.sendRedirect("profile");
            }
            else{
                request.setAttribute("error", "Senha inválida");
                request.getRequestDispatcher("/login.jsp").include(request, response);
            }
        }
//        Users u = (Users) query.get(0);
        
        session.close();
    }

}
