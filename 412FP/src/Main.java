public class Main {

    public static void main(String[] args) {

        try {
            DBConnection.getConnection();
            DBConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
