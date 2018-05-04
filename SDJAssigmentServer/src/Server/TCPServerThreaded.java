package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerThreaded
{

   private static ServerSocket listeningSocket;
   private static final int PORT = 2468;
   
   public TCPServerThreaded() {
      
      
      try {
         listeningSocket = new ServerSocket(PORT);
         System.out.println("ServerSocket: " + listeningSocket);
      }catch (IOException e) {
         e.printStackTrace();
      }
      
      
      
   }
   
   public void listenToClient() {
      
      Socket connSocket = null;
      
      while(true) {
         
         try {
            connSocket = listeningSocket.accept();
            System.out.println("Socket: " + connSocket);
            
            Thread ct = new Thread(new TCPClientThreadHandler(connSocket));
            ct.start();
         }catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void main(String[] args) {
      
      new TCPServerThreaded().listenToClient();
   }
}
