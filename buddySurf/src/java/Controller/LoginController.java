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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author richard
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Logon"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        List result = session.getNamedQuery("Users.findByUsername").setString("username", username).list();

        if (result.isEmpty()){
            request.setAttribute("data", "Usuário inválido");
        }
        else{
            Users user = (Users) result.get(0);
            if (user.getPassword().equals(password)){
                request.setAttribute("data", "Bem vindo" + user.getName());
            }
            else{
                request.setAttribute("data", "Senha inválida");
            }
        }
//        Users u = (Users) query.get(0);
        
        session.close();
        request.getRequestDispatcher("/thanks_redirect.jsp").forward(request, response);
    }

}
