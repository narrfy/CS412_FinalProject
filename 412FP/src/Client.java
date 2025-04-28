
public class Client {

    public static void main(String[] args) {

        ViewHome view = new ViewHome();
        Controller controller = new Controller(view);
        controller.start();

    }

}
