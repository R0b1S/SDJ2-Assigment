package design.domain.mediator;


import com.google.gson.Gson;

import design.domain.model.Member;
import design.domain.model.MemberList;

public class MemberAdapter implements MemberPersistence
{  
   private TCPClient client;
   
   public MemberAdapter()
   {
      client = new TCPClient();
   }
   
   @Override
   public Member[] load(String loadWhat)
   {
      String response = (String) client.accessServer(loadWhat);
      Gson gson = new Gson();
      
      return gson.fromJson(response, MemberList.class).getAllMembers();
   }

}
