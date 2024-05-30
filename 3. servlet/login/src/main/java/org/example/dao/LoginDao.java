package org.example.dao;

import java.sql.*;

public class LoginDao {
    public boolean check(String username, String password) throws SQLException, ClassNotFoundException {
        String uname="postgres";
        String pwd="19209449";
        String url="jdbc:postgresql://localhost:5432/postgres";
        String sql="select * from users where username=? and password=?;";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,uname,pwd);
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
}
