package singleton;

public class LogLine{

   private String text;

   public LogLine(String text){
      this.text = text;
   }

   public String getLogText(){
      if(text != null)
         return text;
      return "nothing";
   }

   public DateTime getDateTime(){
      return new DateTime();
   }

   public String getTimeStamp(){
      return new DateTime().getTimestamp();
   }

   public String toString(){
      return " :" + text;
   }
}