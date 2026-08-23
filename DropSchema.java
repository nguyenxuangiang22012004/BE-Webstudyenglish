import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropSchema {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/english_learning_db";
        String user = "postgres";
        String password = "Giang2004@";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
             
            System.out.println("Dropping schema public...");
            stmt.execute("DROP SCHEMA public CASCADE;");
            System.out.println("Recreating schema public...");
            stmt.execute("CREATE SCHEMA public;");
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
