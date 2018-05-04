import design.controller.Controller;
import design.domain.mediator.MemberModel;
import design.domain.mediator.MemberModelManager;
import design.view.Console;
import design.view.View;

public class MainClass
{
   public static void main(String[] args) {

      View console = new Console();
      MemberModel model = new MemberModelManager();
      Controller controller = new Controller(console, model);
      
      console.start(controller);
   }
   
   
   

}
