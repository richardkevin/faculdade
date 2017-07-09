/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Accommodation;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author richard
 */
@WebServlet(name = "MyAccommodations", urlPatterns = {"/my-accommodations", "/my-accommodations/*"})
public class MyAccommodations extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/myAccommodations.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathParam = request.getPathInfo();

        if (pathParam != null) {
            request.getRequestDispatcher("/addAccommodation.jsp").forward(request, response);
        } else {
            Session session = HibernateSessionFactory.getSession();
            Query query = session.getNamedQuery("Accommodation.findAll");

            request.setAttribute("accommodations", query.list());
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSession();
        HttpSession httpSession = request.getSession(false);
        Users userLogged = (Users) httpSession.getAttribute("user");

        String country = request.getParameter("country");
        String city = request.getParameter("city");
        int maxGuests = Integer.parseInt(request.getParameter("maxGuests"));

        String dt_start = request.getParameter("dt_start");
        String dt_end = request.getParameter("dt_end");
        
        Accommodation a = new Accommodation();
        a.setCountry(country);
        a.setCity(city);
        a.setDt_start(dt_start);
        a.setDt_end(dt_end);
        a.setMaxGuests(maxGuests);
        a.setOwner(userLogged);

        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(a);
        tx.commit();
        session.flush();
        session.close();
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
