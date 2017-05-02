package Controller;

import Model.Rating;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
                out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Avaliar Usuário</h1>");
            // nome usuario
            out.println("<form action='rateUser' method='POST'>");
            out.println("Tipo: <select name='type'>");
                out.println("<option value='0'>Avaliar Amigo</option>");
                out.println("<option value='1'>Avaliar Hóspede</option>");
                out.println("<option value='2'>Avaliar Anfitriã(o)</option>");
                out.println("<option value='3'>Avaliar Convidado</option>");
                out.println("<option value='4'>Avaliar Organizador</option>");
            out.println("</select> <br/>");
            // out.println("<div class='rating'>Stars: <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span></div>");

            out.println("<div class='stars'>Nota: ");
                out.println("<input type='radio' name='rate' value='1' checked> 1");
                out.println("<input type='radio' name='rate' value='2'> 2");
                out.println("<input type='radio' name='rate' value='3'> 3");
                out.println("<input type='radio' name='rate' value='4'> 4");
                out.println("<input type='radio' name='rate' value='5'> 5");
            out.println("</div>");
            out.println("Descrição: <textarea rows='2' cols='20' name='description'> </textarea><br/>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("</form>");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int type = Integer.parseInt(request.getParameter("type"));
            String description = request.getParameter("description");
            int stars = Integer.parseInt(request.getParameter("rate"));

            Session session = HibernateSessionFactory.getSession();

            Rating r = new Rating();
            r.setType(type);
            r.setDescription(description);
            r.setStars(stars);

            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(r);
            tx.commit();
            session.flush();
            session.close();
            request.getRequestDispatcher("/thanks_redirect.jsp").forward(request, response);
    }
}
