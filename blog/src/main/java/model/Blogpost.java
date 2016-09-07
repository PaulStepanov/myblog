package model;

import database.SQLConnect;

import java.sql.*;

/**
 * Created by Павел on 04-Sep-16.
 */
public class Blogpost {
    private Connection connection;
    private PreparedStatement statement;
    public Blogpost(){

        try {
            connection=SQLConnect.getConnection();
            System.out.println(connection);
            statement=connection.prepareStatement("SELECT text FROM posts where id=?;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getBlogText(int id) throws SQLException {
        ResultSet resultSet= null;
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next())
        return resultSet.getString(1);
        return "l";
    }
}
