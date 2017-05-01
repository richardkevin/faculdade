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
@WebServlet(name = "rateUser", urlPatterns = {"/rateUser"})
public class rateUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Session session = HibernateSessionFactory.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar Avaliações</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Avaliações</h1>");
            out.println("<table>");
            out.println("<thead>");
                out.println("<tr>");
                    out.println("<th> Name </td>");
                    out.println("<th> Username </td>");
                    out.println("<th> Password </td>");
                    out.println("<th> Age </td>");
                    out.println("<th> Address </td>");
                    out.println("<th> Max_guests </td>");
                out.println("</tr>");
            out.println("</thead>");
            Query query = session.createQuery("from Users");
            List<Users> userList = query.list();
		for (Users user : userList) {
                    out.println("<tbody>");
                        out.println("<tr>");
                            out.println("<td> " + user.getName() + "</td>");
                            out.println("<td> " + user.getUsername() + "</td>");
                            out.println("<td> " + user.getPassword() + "</td>");
                            out.println("<td> " + user.getAge() + "</td>");
                            out.println("<td> " + user.getAddress() + "</td>");
                            out.println("<td> " + user.getMax_guests() + "</td>");
                        out.println("</tr>");
                    out.println("</tbody>");
		}
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            session.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
