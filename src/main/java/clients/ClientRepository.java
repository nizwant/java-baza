package clients;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {


    public List<Client> findClientByName(String name) throws SQLException {
        String query = "select * from Customers";

        List<Client> clients = new ArrayList<>();
//        try(Connection connection = hikariDataSource.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            ResultSet result = preparedStatement.executeQuery();
//
//            while (result.next()){
//                Client client = new Client();
//                client.setId(result.getString("CustomerID"));
//                clients.add(client);
//            }
//        }

        return clients;
    }

    public List<Client> findAllClient() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//            nie używam application.properties i ogólnie springa tylko się łącze jakbym byl jaskiniowiec ale działa
//            wiadomo trzeba zmienici hasło i uzytkownika
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=NORTHWND;encrypt=true;trustServerCertificate=true", "sa", "Strong.Pwd-123");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                Client c = new Client();
                c.setName(rs.getString("FirstName"));
                c.setSurname(rs.getString("LastName"));
                c.setId(rs.getString("EmployeeID"));
                clients.add(c);
            }
            statement.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
