import java.sql.Connection;

public class Model {

    private Connection connection;

    public Model() {
        try {
            this.connection = DBConnection.getConnection();
            System.out.println("Connected to database");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String getTopPlayers(){


        return "";
    }

    public String getUser(String username){

        return "";
    }

    public void createUser(String username, String password){

    }

    public void updatePlayerMoney(float value){

    }


}
