package Server;

import java.io.*;
import java.net.Socket;

/**
 * Created by Rustam on 14.12.16.
 */

class Connection implements Runnable {
    Socket socket;
    Thread thread;
    Server server;

    public Connection(Server server, Socket socket) { //...
        this.socket = socket;
        this.server = server;
//...
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        System.out.println("Dsa");
        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();


            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);


            String line = null;
            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println(line);
                out.writeUTF(line);
                out.flush(); // заставляем поток закончить передачу данных.

            }
        } catch (Exception x) {
            x.printStackTrace();
        }


    }
}


