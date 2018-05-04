package singleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
   
   private Date date;

   public DateTime()
   {
      date = Calendar.getInstance().getTime();
   }

   // Returns current time stamp(date time) in String format
   public String getTimestamp() {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      return sdf.format(date);
   }

   // Returns current date in String format
   public String getStringDate()
   {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      return sdf.format(date);
   }
}