package design.controller;

import design.domain.mediator.MemberModel;
import design.domain.model.Member;
import design.domain.model.MemberList;
import design.view.View;
import singleton.Log;
import singleton.LogLine;

public class Controller
{
   private View console;
   private MemberModel model;
   
   public Controller(View console, MemberModel model) {
      this.console = console;
      this.model = model;
   }
   
   public void execute(String what) {
      
      switch(what) {
         case "list-all":
            MemberList tempListAll = new MemberList();
            for(Member member : model.getListAllMembers())
               tempListAll.addMember(member);
            Log.getLog().addToLog(new LogLine("Showing all members on cosole."));
            console.show(tempListAll.toString());
            break;
         case "list-unpaid":
            MemberList tempListUnpaid = new MemberList();
            for(Member member : model.getListUnpaidMembers())
               tempListUnpaid.addMember(member);
            Log.getLog().addToLog(new LogLine("Showing all members that havent paid fee on console."));
            console.show(tempListUnpaid.toString());
            break;
         //Never should be default
         default:
            System.out.println("Wrong input");
      }
   }
}
