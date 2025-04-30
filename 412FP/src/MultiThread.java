import java.net.Socket;
import java.util.Random;

public class MultiThread implements Runnable{

    private Socket socket;
    private Random rand;

    public MultiThread(Socket socket) {
        this.socket = socket;
        rand = new Random();
    }

    @Override
    public void run() {

    }

    // Compare Password
    public Boolean checkPassword(String password) {


        return false;
    }

    // Calculate heads/tails
    public boolean coinFlip(int guess){
        int flip = rand.nextInt(0,2);

        if (guess == flip){
            return true;
        } else {
            return false;
        }
    }


    // Calculate dice roll
    public boolean diceRoll(int guess){
        int flip = rand.nextInt(1,7);

        if (guess == flip){
            return true;
        } else {
            return false;
        }
    }

}
