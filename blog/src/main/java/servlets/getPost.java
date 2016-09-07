package servlets;

import database.SETTINGS;
import model.Blogpost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;

/**
 * Created by Павел on 30-Aug-16.
 */
@WebServlet("/getPost")
public class getPost extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException{
        response.setContentType("html");
        PrintWriter write=response.getWriter();
        Blogpost blogpost=new Blogpost();
        try {
            write.append(blogpost.getBlogText(Integer.parseInt(request.getParameter("id"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        write.flush();
    }
}
