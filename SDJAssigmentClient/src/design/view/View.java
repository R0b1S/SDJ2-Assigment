package design.view;

import design.controller.Controller;

public interface View
{
   public void start(Controller controller);
   public void show(String text);
}
