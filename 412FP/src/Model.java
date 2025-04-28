import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model {

    // Table = user
    // Cols = username, password, money

    private Connection connection;

    // Constructor to connect to the db
    public Model() {
        try {
            this.connection = DBConnection.getConnection();
            System.out.println("Connected to database");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Query to get the top 3 players
    public Map<String, Float> getTopPlayers(){
        Map<String, Float> returnMap = new HashMap();
        String cmd = "SELECT username, money FROM user ORDER BY money LIMIT 3;";

        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(cmd);

            while(resultSet.next()){
                float money = resultSet.getFloat("money");
                String username = resultSet.getString("username");
                returnMap.put(username, money);
            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(returnMap);
        return returnMap;
    }

    // Query to get a single user (and password)
    public Map<String, String> getUserLogin(String username){
        Map<String, String> returnMap = new HashMap();
        String cmd = "SELECT username, password FROM user WHERE username = ? LIMIT 1;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(cmd)){
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                String password = resultSet.getString("password");
                returnMap.put(username, password);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(returnMap);
        return returnMap;
    }

    // Query to get a single user (and money)
    public Map<String, Float> getUserMoney(String username){
        Map<String, Float> returnMap = new HashMap();
        String cmd = "SELECT username, money FROM user WHERE username = ? LIMIT 1;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(cmd)){
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                Float money = resultSet.getFloat("money");
                returnMap.put(username, money);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(returnMap);
        return returnMap;
    }

    // Create a new user
    public void createUser(String username, String password){
        String cmd = "INSERT INTO user(username, password, money) VALUES(?, ?, 10.0);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(cmd)){
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            System.out.println("This user already exists");
        }
        System.out.println("User created" + username);
    }

    // Update the given users money
    public void updatePlayerMoney(String username, float value) {
        if (value != 0){
            Map<String, Float> user = getUserMoney(username);
            System.out.println("Updating user " + username + " with money " + value);
            float totalMoney = user.get(username) + value;

            String cmd = "UPDATE user SET money = ? WHERE username=?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {
                preparedStatement.setFloat(1, totalMoney);
                preparedStatement.setString(2, username);

                int rows = preparedStatement.executeUpdate();
                System.out.println("Data Updated, Rows Affected: " + rows);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
