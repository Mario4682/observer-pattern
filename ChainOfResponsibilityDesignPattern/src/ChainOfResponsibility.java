abstract class RupeesHandler
{
 RupeesHandler rupeesHandler;

 public void nextHandler( RupeesHandler rupeesHandler)
 {
 this.rupeesHandler= rupeesHandler;
 }

 public abstract void fetchRupees( long givenAmount );

}

class FiveHundredRupeesHandler extends RupeesHandler
{

 public void fetchRupees(long givenAmount)
 {
	 long numberofNotesToBeFetched = givenAmount / 500;
	 if (numberofNotesToBeFetched > 0)
	 {
		 if(numberofNotesToBeFetched >1)
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Five Hundred Rupees notes are Fetched by FiveHundredRupeesHandler \n");
		 }
		 else
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Five Hundred Rupees note is Fetched by FiveHundredRupeesHandler \n");
		 
		 }
	 }
	
	 long pendingRupeesToBeProcessed = givenAmount % 500;
	
	 if (pendingRupeesToBeProcessed > 0)
	 {
	 rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
	
	 }

 }

}

class HundredRupeesHandler extends RupeesHandler
{

 public void fetchRupees(long givenAmount)
 {
	 long numberofNotesToBeFetched = givenAmount / 100;
	 if (numberofNotesToBeFetched > 0)
	 {
		 if(numberofNotesToBeFetched >1)
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Hundred Rupees notes are Fetched by HundredRupeesHandler \n");
		 }
		 else
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Hundred Rupees note is Fetched by HundredRupeesHandler \n");
		 
		 }
	 }
	
	 long pendingRupeesToBeProcessed = givenAmount % 100;
	
	 if (pendingRupeesToBeProcessed > 0)
	 {
	 rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
	
	 }

 }

}

class FiftyRupeesHandler extends RupeesHandler
{

 public void fetchRupees(long givenAmount)
 {
	 long numberofNotesToBeFetched = givenAmount / 50;
	 if (numberofNotesToBeFetched > 0)
	 {
		 if(numberofNotesToBeFetched >1)
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Fifty Rupees notes are Fetched by FiftyRupeesHandler \n");
		 }
		 else
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Fifty Rupees note is Fetched by FiftyRupeesHandler \n");
		 
		 }
	 }
	
	 long pendingRupeesToBeProcessed = givenAmount % 50;
	
	 if (pendingRupeesToBeProcessed > 0)
	 {
	 rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
	
	 }

 }

}

class TwentyRupeesHandler extends RupeesHandler
{

 public void fetchRupees(long givenAmount)
 {
	 long numberofNotesToBeFetched = givenAmount / 20;
	 if (numberofNotesToBeFetched > 0)
	 {
		 if(numberofNotesToBeFetched >1)
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Twenty Rupees notes are Fetched by TwentyRupeesHandler \n");
		 }
		 else
		 {
		 System.out.println(numberofNotesToBeFetched + " ,Twenty Rupees note is Fetched by TwentyRupeesHandler \n");
		 
		 }
	 }
	
	 long pendingRupeesToBeProcessed = givenAmount % 20;
	
	 if (pendingRupeesToBeProcessed > 0)
	 {
	 rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
	
	 }

 }

}

class FiveRupeesHandler extends RupeesHandler
{

	public void fetchRupees(long givenAmount)
	{
		long numberofNotesToBeFetched = givenAmount / 5;
		if (numberofNotesToBeFetched > 0)
		{
			if(numberofNotesToBeFetched >1)
			{
			System.out.println(numberofNotesToBeFetched + " ,Five Rupees notes are Fetched by FiveRupeesHandler \n");
			}
			else
			{
			System.out.println(numberofNotesToBeFetched + " ,Five Rupees note is Fetched by FiveRupeesHandler \n");
			
			}
		}
		
		long pendingRupeesToBeProcessed = givenAmount % 5;
		
		if (pendingRupeesToBeProcessed > 0)
		{
		rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		
		}
	
	}

}

class Kiosk
{
 private static FiveHundredRupeesHandler fivehundredRupeesHandler = new FiveHundredRupeesHandler();
 private static HundredRupeesHandler hundredRupeesHandler = new HundredRupeesHandler();
 private static FiftyRupeesHandler   fiftyRupeesHandler   = new FiftyRupeesHandler();
 private static TwentyRupeesHandler  twentyRupeesHandler  = new TwentyRupeesHandler();
 private static FiveRupeesHandler    fiveRupeesHandler    = new FiveRupeesHandler();

 static
 {
 // Construct the chain of Rupees Handlers
 fivehundredRupeesHandler.nextHandler(hundredRupeesHandler);
 hundredRupeesHandler.nextHandler(fiftyRupeesHandler);
 fiftyRupeesHandler.nextHandler(twentyRupeesHandler);
 twentyRupeesHandler.nextHandler(fiveRupeesHandler);
 }

 public void payment( long givenAmount )
 {

 fivehundredRupeesHandler.fetchRupees(givenAmount);
 }
}

public class ChainOfResponsibility {
	public static void main( String[] args )
	 {
	 Kiosk kiosk = new Kiosk();
	 
	 System.out.println("\n ----------------Paid Amount 1755-----------------------\n");
	 
	 kiosk.payment(1755);
	 
	 System.out.println("\n ----------------Paid Amount 2275-----------------------\n");
	 
	 kiosk.payment(2275);
	 }
}
