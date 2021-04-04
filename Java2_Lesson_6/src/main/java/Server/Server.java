package Server;

import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        Socket client = null;
        try {
            serverSocket = new ServerSocket(8089);
            System.out.println("Server has started");
            client = serverSocket.accept();
            System.out.println("Client has just connected to server"+client.getInetAddress());
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            Scanner send = new Scanner(System.in);
            Thread sendMsg = new Thread(() -> {
                while (true){
                    String msg = send.nextLine();
                    out.println("Server's message: "+msg);
                    if("/end".equals(msg)){
                        break;
                    }
                }
            });
            sendMsg.setDaemon(true);
            sendMsg.start();
            Thread rcvdMsg =new Thread(()->{
                while (true){
                    String str = in.nextLine();
                    if("/end".equals(str)){
                        out.println(str);
                        break;
                    }
                    System.out.println(str);
                    out.println("Server's reply "+str);
                }
            });
            rcvdMsg.start();
            try {
                rcvdMsg.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            disconnect(serverSocket,client);
            }
        }

    public static void disconnect(ServerSocket serverSocket, Socket client){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
