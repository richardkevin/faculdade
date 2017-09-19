package Controller;



import Model.Person;
import java.io.IOException;
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
@WebServlet(name = "AddController", urlPatterns = {"/add"})
public class SignInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Session session = HibernateSessionFactory.getSession();

            Person u = new Person();
            u.setName(name);
            u.setUsername(username);
            u.setPassword(password);

            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(u);
            tx.commit();
            session.flush();
            session.close();

            response.sendRedirect("login");
    }

}
