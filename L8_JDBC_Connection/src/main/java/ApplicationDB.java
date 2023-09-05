import service.DeveloperService;

import java.sql.*;
import java.util.Scanner;

import static query_executor.DeveloperQueryExecutor.*;

public class ApplicationDB {
    private static final String DATA_BASE_URL =
            "jdbc:sqlite:" + "/Users/cmazur/QA Java Automation Course/L8_JDBC_Connection/src/main/resources/developers.db";

    public static void main(String[] args) throws SQLException {
        if(isDriverExists()) {
            Connection connection = DriverManager.getConnection(DATA_BASE_URL);
            String action;


            do {
                System.out.print("Switch your case: ");
                action = new Scanner(System.in).nextLine();
                switch (action) {
                    case "1":
                        printAllDevelopers(connection);
                        break;
                    case "2":
                        addDeveloper(connection, DeveloperService.inputDeveloper());
                        break;
                    case "3":
                        System.out.print("Enter id for delete: ");
                        int idForDelete = new Scanner(System.in).nextInt();
                        deleteDeveloper(connection, idForDelete);
                        break;
                    case "4":
                        System.out.print("Enter id for update: ");
                        int idForUpdate = new Scanner(System.in).nextInt();
                        updateDeveloper(connection, idForUpdate, DeveloperService.inputDeveloper());
                        break;
                    case "5":
                        break;
                }
            } while(!"5".equals(action));
            connection.close();
        }


        /*System.out.println(DATA_BASE_URL);
        Connection connection = DriverManager.getConnection(DATA_BASE_URL);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Developers;");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("specialty"));
            System.out.println(resultSet.getInt("salary"));
        }
        statement.close();
        connection.close();*/
    }

    public static boolean isDriverExists() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver was not found");
            return false;
        }
    }
}
