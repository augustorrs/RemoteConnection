
package Main;

/**
 *
 * @author Augusto Souza 2017376
 */

public class DBConnection {

public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    
/**
     * Connect database 
     * @return 
     */
    public static boolean connection() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection(DBParams.DATABASE_PATH, DBParams.DB_USER, DBParams.DB_PASS);
                statement = connect.createStatement();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
