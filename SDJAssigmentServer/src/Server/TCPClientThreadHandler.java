package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;

import Server.model.DOB;
import Server.model.Member;
import Server.model.MemberList;

public class TCPClientThreadHandler implements Runnable
{

   private Socket socket;
   private DataInputStream inFromClient;
   private DataOutputStream outToClient;
   
   public TCPClientThreadHandler(Socket socket)
   {
      this.socket = socket;
   }
   
   @Override
   public void run()
   {

      DOB dob1 = new DOB(2,5,1995);
      DOB dob2 = new DOB(2,5,1995);
      DOB dob3 = new DOB(2,5,1995);
      DOB dob4 = new DOB(2,5,1995);
      Member member1 = new Member("Noah", "Toftsvej 7","noah@gmail.com" , "71388607", true, 2016, dob1);
      Member member2 = new Member("Naed", "Toftsvej 4","Naed@gmail.com" , "7147890", true, 2017, dob2);
      Member member3 = new Member("Jon", "Toftsvej 2","Jon@gmail.com" , "71871291", false, 2015, dob3);
      Member member4 = new Member("Yamen", "Toftsvej 9","Yamen@gmail.com" , "71334093", true, 2016, dob4);
      
      MemberList memberList= new MemberList();
      memberList.addMember(member1);
      memberList.addMember(member2);
      memberList.addMember(member3);
      memberList.addMember(member4);
      
      System.out.println(memberList.toString());

      Gson gson = new Gson();
      String members = gson.toJson(memberList, MemberList.class);
      
      
      try {
         inFromClient = new DataInputStream(socket.getInputStream());
         outToClient = new DataOutputStream(socket.getOutputStream());
         
         String message = inFromClient.readUTF();
         
         switch (message) {
            case "members":
               outToClient.writeUTF(members);   
               break;
               // Never should reach this block
            default:
              outToClient.writeUTF("Wrong input s");
              break;
            }  
                        
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
