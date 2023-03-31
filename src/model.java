import javax.swing.*;
import java.sql.*;


public class model {

    public static void main(String[] args) {
        Connection conn = null;
        JPasswordField pf = new JPasswordField();


        // Set up connection to database
        try {
            /*conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop"+
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    user,password);
*/
            conn = DriverManager.getConnection("jdbc:mysql://" + env.DBURL + ":" + env.port + "/" + env.DBname + "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    env.user, env.password);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "select * from " + env.DBtable;
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("createdAt") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getInt("authorId");
                System.out.println(output);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getData() {

        return null;
    }
}
