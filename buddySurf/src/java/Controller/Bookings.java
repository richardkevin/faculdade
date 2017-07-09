package Controller;

import Model.Accommodation;
import Model.Booking;
import Model.Users;
import java.io.IOException;
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
@WebServlet(name = "Bookings", urlPatterns = {"/booking/*"})
public class Bookings extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/booking.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathParam = request.getPathInfo();

        if (pathParam != null) {
            Session session = HibernateSessionFactory.getSession();
            long accomId = Long.parseLong(pathParam.replace("/", ""));
            Query query = session.getNamedQuery("Accommodation.findById").setParameter("accommodation_id", accomId);
            request.setAttribute("accommodation", query.uniqueResult());
            processRequest(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSession();
        HttpSession httpSession = request.getSession(false);

        Users userLogged = (Users) httpSession.getAttribute("user");

        String pathParam = request.getPathInfo();
        long accomId = Long.parseLong(pathParam.replace("/", ""));
        Query query = session.getNamedQuery("Accommodation.findById").setParameter("accommodation_id", accomId);
        Accommodation accom = (Accommodation) query.uniqueResult();

        int guestQty = Integer.parseInt(request.getParameter("maxGuests"));
        String dt_checkin = request.getParameter("dt_start");
        String dt_checkout = request.getParameter("dt_end");

        Booking b = new Booking();
        b.setAccommodation(accom);
        b.setDt_checkin(dt_checkin);
        b.setDt_checkout(dt_checkout);
        b.setGuest(userLogged);
        b.setGuestQty(guestQty);

        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(b);
        tx.commit();
        session.flush();
        session.close();
        response.sendRedirect("/buddySurf/profile");
    }
}
