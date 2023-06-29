import java.sql.*;
import java.util.Scanner;


public class Main {
    static String url = "jdbc:mysql://localhost:3306/project";
    static String username="root";
    static String password="";
    static Data data = new Data();

    public static void main(String[] args) {
        int choiceSwitch;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Add student\n2. Delete student\n3. Edit student\n4. Check students");
            try {
                choiceSwitch = Integer.parseInt(String.valueOf(scanner.nextLine()));
                switch (choiceSwitch) {
                    case 1 -> data.AddUser();
                    case 2 -> data.DeleteUser();
                    case 3 -> System.out.println("Not working... wait for update");
                    case 4 -> data.CheckUser();
                    default -> System.out.println("There isn't that option");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }



    }
}