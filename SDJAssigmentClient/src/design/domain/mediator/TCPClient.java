package design.domain.mediator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;

public class TCPClient
{
   private static InetAddress host;
   private static final int PORT = 2468;
   
   public TCPClient() {
      
      try {
         host = InetAddress.getLocalHost();
      } catch (UnknownHostException e) {
         System.out.println("Unable to fint the Host ID!");
         System.exit(1);
      }

   }
   
   public String accessServer(String loadWhat) {
      
      Socket clientSocket = null;
      String resp = "";
      
      try {
         clientSocket = new Socket(host, PORT);
         
         DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
         DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
         
         outToServer.writeUTF(loadWhat);
         
         resp = inFromServer.readUTF();
        
      } catch (IOException ioe) {
         System.out.println("\n Error can`t connect to server!");
      } catch (NoSuchElementException nse) {
         System.out.println("error");
      } finally {
         try {
            //System.out.println("\n Closing connection to the server!");
            if(clientSocket != null)
               clientSocket.close();
         } catch (IOException ioe) {
            System.out.println("Unable to close connection to the server!");
            System.exit(1);
         }
      }
      
      return resp;
   }
}
