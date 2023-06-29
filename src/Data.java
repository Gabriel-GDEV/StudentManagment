import java.security.cert.Extension;
import java.sql.*;
import java.util.*;

public class Data {


    public void DeleteUser() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Main.url, Main.username, Main.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student ORDER by id");


            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " | Name: " + resultSet.getString(2) + " | Surname: " + resultSet.getString(3));
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("id to DELETE: ");
            int id = Integer.parseInt(scanner.nextLine());

            statement.executeUpdate("DELETE FROM student WHERE id="+id);
            System.out.println("Deleted User id = " + id);



            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void AddUser() {
        List<Integer> id = new ArrayList<Integer>();
        int userId = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Main.url, Main.username, Main.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student ORDER by id");

            while(resultSet.next()) {
                id.add(resultSet.getInt(1));
            }
            for(int i = 0; i<=100; i++) {
                if(!id.contains(i)){
                   userId = i;
                   id.add(i);

                   break;
                }
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("name to ADD: ");
            String name = scanner.nextLine();
            System.out.println("surname to ADD: ");
            String surname = scanner.nextLine();

            statement.executeUpdate("INSERT INTO student VALUES (" + userId + ", '" + name + "', '" + surname + "')");

            System.out.println("Added User id = " + id);

            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void CheckUser() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Main.url, Main.username, Main.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student ORDER by id");


            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " | Name: " + resultSet.getString(2) + " | Surname: " + resultSet.getString(3));
            }
            System.out.println();
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void EditUser() {
        List<Integer> id = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Main.url, Main.username, Main.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student ORDER by id");

            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " | Name: " + resultSet.getString(2) + " | Surname: " + resultSet.getString(3));
            }

            System.out.println("Which id you wanna edit?");


            int newid = Integer.parseInt(scanner.nextLine());

            System.out.println("name to EDIT: ");
            String name = scanner.nextLine();
            System.out.println("surname to EDIT: ");
            String surname = scanner.nextLine();

            statement.executeUpdate("UPDATE student SET name='" + name + "', surname='" + surname + "' WHERE id=" + newid);
            System.out.println("Changed student name and surname");

            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
//UPDATE Customers
//SET ContactName='Alfred Schmidt', City='Frankfurt'
//WHERE CustomerID=1;