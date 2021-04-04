package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8089;

    public static void main(String[] args)  {
        Socket connection=null;
        try {
            connection = new Socket(HOST, PORT);
            System.out.println("Client connected to the server " + connection.getInetAddress());
            Scanner send = new Scanner(System.in);
            Scanner in = new Scanner(connection.getInputStream());
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            Thread sendMsg = new Thread(()->{
                while (true) {
                    String msg = send.nextLine();
                    out.println(msg);
                    if ("/end".equals(msg)) {
                        break;
                    }
                }
            });
            sendMsg.setDaemon(true);
            sendMsg.start();
            Thread rcvdMsg = new Thread(()->{
                while (true) {
                    String msg = in.nextLine();
                    if ("/end".equals(msg)) {
                        out.println(msg);
                        break;
                    }
                    System.out.println(msg);
                }
            });
            rcvdMsg.start();
            try {
                rcvdMsg.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
