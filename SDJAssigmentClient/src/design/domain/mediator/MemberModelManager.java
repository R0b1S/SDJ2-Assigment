package design.domain.mediator;

import design.domain.model.Member;
import design.domain.model.MemberList;
import singleton.Log;
import singleton.LogLine;

public class MemberModelManager implements MemberModel
{
   private MemberPersistence adapter;
   
   public MemberModelManager() {
      adapter = new MemberAdapter();
   }
      
   @Override
   public Member[] getListAllMembers()
   {
      Log.getLog().addToLog(new LogLine("Sending request for all members."));
      Member[] temp = adapter.load("members");
      Log.getLog().addToLog(new LogLine("Sending list of all members."));
      return temp;
   }

   @Override
   public Member[] getListUnpaidMembers()
   {      
      MemberList temp = new MemberList();
      Log.getLog().addToLog(new LogLine("Sending request for all members."));
      for(Member member : adapter.load("members"))
         if(!member.getPaidFee())
            temp.addMember(member);
      Log.getLog().addToLog(new LogLine("Sending list of all members that havent paid fee."));
      return temp.getAllMembers();
   }

}
