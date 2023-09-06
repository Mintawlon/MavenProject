package Model;

import entity.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    public ArrayList<User> UserData() {
        ArrayList<User> arrayList = new ArrayList<User>();
        try (Connection connection = getConnection()) {
            // A query to get current date time from Oracle database
            String sql = "select * from user";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                arrayList.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return arrayList;
    }

    // user data list for jstl
    /*---------------------------------------------------------------------------- */
    // JNDI Data Connection
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
    /* ----------------------------------------------------------------- */

    public boolean addUser(User newuser) {
        try (Connection connection = getConnection()) {

            // A query to get current date time from Oracle database
            String username = newuser.getUsername();
            String email = newuser.getEmail();
            String password = newuser.getPassword();
            String query = "insert into user(username,email,password) values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            return statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
