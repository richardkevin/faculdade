package Controller;



import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author richard
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class Add extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");
            int max_guests = Integer.parseInt(request.getParameter("max_guests"));

            Session session = HibernateSessionFactory.getSession();

            Users u = new Users();
            u.setName(name);
            u.setUsername(username);
            u.setPassword(password);
            u.setAge(age);
            u.setAddress(address);
            u.setMax_guests(max_guests);

            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(u);
            tx.commit();
            session.flush();
            session.close();
            request.getRequestDispatcher("/add_redirect.jsp").forward(request, response);
    }

}
