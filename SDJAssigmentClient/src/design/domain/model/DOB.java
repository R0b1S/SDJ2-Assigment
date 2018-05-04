package design.domain.model;

import java.io.Serializable;

public class DOB implements Serializable
{
   private static final long serialVersionUID = 1L;
   
   private int day;
   private int month;
   private int year;

   public DOB()
   {
      this.day = 0;
      this.month = 0;
      this.year = 0;
   }

   public DOB(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }

   public int getDay()
   {
      return day;
   }

   public void setDay(int day)
   {
	  if(checkValidity(day, this.month, this.year)) 
		  this.day = day;
	  else 
		  throw new RuntimeException("Invalid day");
      
   }
   
   public int getMonth()
   {
      return month;
   }

   public void setMonth(int month)
   {
	   if(checkValidity(this.day, month, this.year)) 
			  this.month = month;
		  else 
			  throw new RuntimeException("Invalid month");
   }

   public int getYear()
   {
      return year;
   }

   public void setYear(int year)
   {
	   if(checkValidity(this.day, this.month, year)) 
			  this.year = year;
		  else 
			  throw new RuntimeException("Invalid year");
   }

   public boolean equals(Object obj) {
      if(!(obj instanceof DOB))
         return false;
      
      DOB other = (DOB) obj;
      if(!(this.getDay() == other.getDay() &&
            this.getMonth() == other.getMonth() &&
            this.getYear() == other.getYear()))
         return false;
      
      return true;
   }

   //checkValidity if new set date/month/year is valid
   public boolean checkValidity(int day, int month, int year) {
	   if(day < 1 || day > 31) return false;
	   else if(month < 1 || month > 12) return false;
	   else if(year < 1900 || year > 2018) return false;
	   return true;
   }
   
   public String toString() {
      return (day < 10 ? "0"+day : day) + "-" + (month < 10 ? "0"+month : month) + "-" + year;
   }
   
}
