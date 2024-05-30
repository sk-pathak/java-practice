import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Cars{
    String brand;
    String model;
    int year;

    @Override
    public String toString() {
        return "{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

class Dao{
    Connection con=null;
    public void connect() throws SQLException {
        con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","19209449");
    }
    public List<Cars> getCar(String brand) throws SQLException {
        List<Cars> cars=new ArrayList<>();
        String query="select * from cars where brand=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,brand);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Cars c =new Cars();
            c.brand=brand;
            c.year=rs.getInt("year");
            c.model=rs.getString("model");
            cars.add(c);
        }
        return cars;
    }
    public void updateCar(int year) throws SQLException {
        String query="update cars set year=? where year>?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,2000);
        ps.setInt(2,year);
        int count=ps.executeUpdate();
        if(count>0){
            System.out.println(count+" car(s) updated");
        }
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        String brand="Toyota";
        int year=1980;
        Dao dao=new Dao();
        dao.connect();
//        List<Cars> c1=dao.getCar(brand);
//        System.out.println(c1);
        dao.updateCar(year);
    }
}