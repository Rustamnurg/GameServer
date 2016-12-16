package Server;

import java.io.IOException;

/**
 * Created by Rustam on 12.12.16.
 */
public class Main {
    public static void main(String[] args) {
        Server server = null;
        try {
            server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
