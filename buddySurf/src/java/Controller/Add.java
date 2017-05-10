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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            out.println("Max Guests: <select id='max_guests' name='max_guests'>");
                out.println("<option value='0'>Não permitir</option>");
                out.println("<option value='1'>1 Hóspede</option>");
                out.println("<option value='2'>2 Hóspedes</option>");
                out.println("<option value='3'>3 Hóspedes</option>");
                out.println("<option value='4'>4 Hóspedes</option>");
                out.println("<option value='5'>5 Hóspedes</option>");
                out.println("<option value='6'>6 Hóspedes</option>");
                out.println("<option value='7'>7 Hóspedes</option>");
                out.println("<option value='8'>8 Hóspedes</option>");
                out.println("<option value='9'>9 Hóspedes</option>");
                out.println("<option value='10'>10 Hóspedes</option>");
            out.println("</select> <br/>");
            // upload foto (usuario) + botão para criar acomodação se max_guests != 0
            out.println("<div>");
                out.println("");
            out.println("</div>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("</form>");
            out.println("<script type='text/javascript'></script>");
            out.println("</body>");
            out.println("</html>");
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
