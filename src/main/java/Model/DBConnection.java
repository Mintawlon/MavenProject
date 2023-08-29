package Model;

import entity.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    public ArrayList<User> UserData (){
        ArrayList<User> arrayList = new ArrayList<User>();
        try (Connection connection = getConnection()) {
            // A query to get current date time from Oracle database
            String sql = "select * from userdata";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                arrayList.add(new User(rs.getInt("user_id"),rs.getString("username"),rs.getString("email"),rs.getString("password")));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return arrayList;
    }
    // user data list for jstl

    private Connection getConnection() {
        Connection connection = null;
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) context.lookup("jdbc/DataSource");
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
