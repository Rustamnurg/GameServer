package Gameplay;


import Specialty.Hunter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Rustam on 16.12.16.
 */


public class Gameplay {

        private static Gameplay _instance = null;

        private Gameplay() {}

        public static synchronized Gameplay getInstance() {
            if (_instance == null)
                _instance = new Gameplay();
            return _instance;
        }

    private int healthFirst;
    private int healthSecond;

    public void play() throws IOException {


        ServerSocket s1 = new ServerSocket(3457);
        while (true) {

            Socket socket = s1.accept();
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);



            String line = null;
                line = in.readUTF();
                if(line.equals("go")){
                    Hunter hunter = new Hunter();
                    out.writeUTF(hunter.blow("Mag"));
                }

               // out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush();
                System.out.println(line);
                System.out.println();

        }
    }





    public boolean gameIsContinues() {
        if (getHealthFirst() == 0 || getHealthSecond() == 0) {
            //игра закончина
            return false;
        }
        return true;
    }









    public int getHealthFirst() {
        return healthFirst;
    }

    public void setHealthFirst(int healthFirst) {
        this.healthFirst = healthFirst;
    }


    public int getHealthSecond() {
        return healthSecond;
    }

    public void setHealthSecond(int healthSecond) {
        this.healthSecond = healthSecond;
    }

}