package Main;

/**
 *
 * @author Augusto Souza 2017376
 */
public class DBCountry {
    
/**
     * read country database by query
     * @param query
     * @return 
     */
    public static List<Country> readDBByQuery(String query){
        List<Country> read_all = new ArrayList<Country>();
        if (DBConnection.connect == null) {
            return null;
        }
        try {
            //get result set
            DBConnection.resultSet = DBConnection.statement.executeQuery(query);
            Statement cannon_statement = DBConnection.connect.createStatement();
            while (DBConnection.resultSet.next()) {
                
                Country country = new Country();
                //read database item and initialize country object
                String code = String.valueOf(DBConnection.resultSet.getString("Code"));
                String name = String.valueOf(DBConnection.resultSet.getString("Name"));
                String continent = String.valueOf(DBConnection.resultSet.getString("Continent"));
                float surface = DBConnection.resultSet.getFloat("SurfaceArea");
                String head = String.valueOf(DBConnection.resultSet.getString("HeadOfState"));
                
                //set all values
                country.setCode(code);
                country.setName(name);
                country.setContinent(continent);
                country.setSurface(surface);
                country.setHead(head);
                
                read_all.add(country);
            }
            cannon_statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            DBConnection.reconnect();
            return null;
        }
        return read_all;
    }
}