package com.time2test;

public class Time2
{
   private int totalSecond; //0 - 86400
   
   //initiated by totalSecond
   private int hour; 
   private int minute; 
   private int second; 
   // Time2 no-argument constructor: 
   // initializes variable to zero
   
   public Time2()
   {
     this.totalSecond = 0;
     setTime();
   } 

   // Time2 constructor: totalSecond supplied
   public Time2(int totalSecond) 
   { 
      if(totalSecond < 0 || totalSecond >= 86400)
        throw new IllegalArgumentException("totalSeconds must be 0-86400");
      
      this.totalSecond = totalSecond;
      setTime();
   } 

   // Time2 constructor: another Time2 object supplied
   public Time2(Time2 time)
   {
      // invoke constructor with one arguments
      this(time.totalSecond);
   } 

   // Set Methods
   // set a new time value using universal time; 
   public void setTime()
   {
      setHour();
      setMinute();
      setSecond(); 
   } 

   // set hour 
   public void setHour() 
   { 
      this.hour = this.totalSecond / 3600;
   } 

   // set minute 
   public void setMinute() 
   { 
      this.minute = (this.totalSecond - this.hour * 3600) / 60; 
   } 

   // set second 
   public void setSecond() 
   { 
      this.second = this.totalSecond - this.hour * 3600 - this.minute * 60; 
   } 

   // Get Methods
   // get hour value
   public int getHour() 
   { 
      return this.hour; 
   } 

   // get minute value
   public int getMinute() 
   { 
      return this.minute; 
   } 

   // get second value
   public int getSecond() 
   { 
      return this.second; 
   } 

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format(
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   } 

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return String.format("%d:%02d:%02d %s", 
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   } 
} // end class Time2
