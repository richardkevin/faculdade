/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Project;
import Model.Student;
import Model.Teacher;
import java.io.IOException;
import java.util.List;
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
 * @author richard.correa
 */
@WebServlet(name = "ProjectRegistration", urlPatterns = {"/project-registration"})
public class ProjectRegistration extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/project-registration.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSession();
        HttpSession httpSession = request.getSession(false);
        
        Query query = session.getNamedQuery("Student.findAll");
        List<Student> studentsList = query.list();
        request.setAttribute("studentsList", studentsList);

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Long matricula = Long.parseLong(request.getParameter("matricula"));
        Long teacherId = Long.parseLong(request.getParameter("teacher_id"));
        String description = request.getParameter("description");
        
        Session session = HibernateSessionFactory.getSession();

        Query query = session.getNamedQuery("Student.findById").setParameter("matricula", matricula);
        Student student = (Student) query.uniqueResult();
        query = session.getNamedQuery("Teacher.findById").setParameter("teacherId", teacherId);
        Teacher teacher = (Teacher) query.uniqueResult();

        Project p = new Project();
        p.setName(name);
        p.setStudent(student);
        p.setTeacher(teacher);
        p.setDescription(description);

        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(p);
        tx.commit();
        session.flush();
        session.close();
        response.sendRedirect(request.getContextPath() + "/teacher");
    }
}
