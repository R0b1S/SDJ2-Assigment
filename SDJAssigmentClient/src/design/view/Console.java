package design.view;

import java.util.Scanner;

import design.controller.Controller;
import singleton.Log;
import singleton.LogLine;

public class Console implements View
{
   // Don`t need to store reference to the controller for this assigment
   //private Controller controller;
   private Scanner keyboard;
   
   public Console() {
      keyboard = new Scanner(System.in);
      //controller = null;
   }

   @Override
   public void start(Controller controller)
   {
      //this.controller = controller;
      int itemSelected;
      Log.getLog().addToLog(new LogLine("Starting program..."));
      do
      {
         itemSelected = menu();
         switch (itemSelected)
         {
            case 1:
               controller.execute("list-all");
               break;
            case 2:
               controller.execute("list-unpaid");
               break;
            case 3:
               System.out.println("Exiting program ...");
               Log.getLog().addToLog(new LogLine("Exiting program.. \n --------------------------------"));
               break;
            default:
               show("Wrong input c");
               break;
         }
         System.out.println("\nPress ENTER to continue...");
         keyboard.nextLine();
      }
      while (itemSelected != 3);
   }

   @Override
   public void show(String text)
   {
      System.out.println(text);
   }
   
   public int menu() {
      
      System.out.println("<3 Vippassana <3");
      System.out.println("----------------");
      System.out.println("1) List all members");
      System.out.println("2) List members (not payed fee)");
      System.out.println("3) Exit");
      System.out.print("\nSelect an item 1-3: ");
      int selection = keyboard.nextInt();
      keyboard.nextLine();
      return selection;
   }
}
