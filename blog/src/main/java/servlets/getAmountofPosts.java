package servlets;

import database.SQLConnect;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Павел on 04-Sep-16.
 */
@WebServlet("/getAmountofPosts")
public class getAmountofPosts extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            PrintWriter printWriter=response.getWriter();
            Connection connection=SQLConnect.getConnection();
            Statement statement=connection.createStatement();
            ResultSet res=statement.executeQuery("SELECT COUNT(*) FROM posts");
            res.next();
            printWriter.print(res.getInt(1));
            System.out.println(res.getInt(1));
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
