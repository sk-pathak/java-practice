import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String query="SELECT * FROM cars where year=1978";
        String brand="Tataa";
        String model="Nanoo";
        int year=20010;
        query="INSERT INTO cars (brand,model,year) VALUES (?,?,?)";

        String url="jdbc:postgresql://localhost:5432/postgres";
        String username="postgres";
        String password="19209449";
        Connection conn= DriverManager.getConnection(url,username,password);

//        Statement st= conn.createStatement();
//        ResultSet rs=st.executeQuery(query);
//        rs.next();
//        System.out.println(rs.getString(2));
//        int cnt=st.executeUpdate(query);

        PreparedStatement st=conn.prepareStatement(query);
        st.setString(1,brand);
        st.setString(2,model);
        st.setInt(3,year);
        st.executeUpdate();
    }
}