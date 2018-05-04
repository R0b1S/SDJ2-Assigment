package singleton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Log{
   
   private static File logFile;
   private static Log log;
   
   private Log(){

   }

   public static Log getLog(){
      if(log == null)
         log = new Log();

      logFile = new File("log-" + new DateTime().getStringDate());
      if(!logFile.exists() && logFile.getName().equals("log-" + new DateTime().getStringDate()))
         logFile = new File("log-" + new DateTime().getStringDate());
      return log;
   }
   
   public void addToLog(LogLine line) {
      BufferedWriter out = null;
      
      try
      {
         out = new BufferedWriter(new FileWriter(logFile, true));
         out.write(new DateTime().getTimestamp() + line + "\n");
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            out.close();
         }catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
   
}