package query_executor;

import model.Developer;

import java.sql.*;

public class DeveloperQueryExecutor {
    public static void printAllDevelopers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Developers;");
        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("id"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("specialty: " + resultSet.getString("specialty"));
            System.out.println("salary: " + resultSet.getInt("salary"));
            System.out.println();
        }
        resultSet.close();
        statement.close();
    }

    public static void addDeveloper(Connection connection, Developer developer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into Developers (name, specialty, salary) values (?, ?, ?)");
        preparedStatement.setString(1, developer.getName());
        preparedStatement.setString(2, developer.getSpecialty());
        preparedStatement.setInt(3, developer.getSalary());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public static void deleteDeveloper(Connection connection, int idForDelete) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from Developers where id = ?");
        preparedStatement.setInt(1, idForDelete);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void updateDeveloper(Connection connection, int idForUpdate, Developer developer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update Developers set name = ?, specialty = ?, salary = ? where id = ?");
        preparedStatement.setString(1, developer.getName());
        preparedStatement.setString(2, developer.getSpecialty());
        preparedStatement.setInt(3, developer.getSalary());
        preparedStatement.setInt(4, idForUpdate);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
