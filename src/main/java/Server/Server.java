package Server;

import Gameplay.Gameplay;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Rustam on 14.12.16.
 */
public class Server {
    final int PORT = 3456;
    ArrayList<Connection> connections;

    public Server() throws IOException {
        connections = new ArrayList<>();
        go();
    }

    public void go() throws IOException {
        ServerSocket s1 = new ServerSocket(PORT);
        while (true) {
            Socket client = s1.accept();
            connections.add(new Connection(this, client));

            if(connections.size()>=2){
                Gameplay.getInstance().play();
                System.out.println(connections.size());
            }


//            for(Connection elem: connections){
//                 System.out.println(elem.socket.getRemoteSocketAddress().toString());
//               System.out.println("Dsa");
//            }
        }

    }

}
