package RangePackage;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

public class ZipcodeRangeMerger 
{
	private static ArrayList<ZipcodeRange> _ranges = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		System.out.println("Input Ranges as two integers seperated by a comma, example:12345,67890\nEnter nothing to end the inputs and display result.");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   
		
		String input;
		try 
		{
			input = reader.readLine();
			while (input != null && !(input.equals("")))
			{
				if (input.length() != 11)
				{
					System.out.println("Zip codes are 5 digits, please correct ouur input and try again.");
					
				}
				else if (input.charAt(5) == ',')
				{
					try
					{
						int rangeLow = Integer.parseInt(input.substring(0, 5));
						int rangeHigh = Integer.parseInt(input.substring(6, 11));
						
						ZipcodeRange range = new ZipcodeRange(rangeLow, rangeHigh);	// Add will fix these if in wrong order.
						
						ZipcodeRangeMerger.addRange(range);
						System.out.println("Range Succesfully Entered. Please enter another, or hit enter to end.");
					}
					catch (NumberFormatException ex)
					{
						System.out.println("You Entered an invalid Range, please try again.");
					}
				}
				else
				{
					System.out.println("Please correct your format");
				}
				input = reader.readLine();
			}
			
		} 
		catch (IOException e)
		{
			System.out.println("IO Exception");
			e.printStackTrace();
		}
		
		ZipcodeRangeMerger.printRange();
		
		// Printing the read line
	}
	
	public static List<ZipcodeRange> getZipRanges()
	{
		return _ranges;
	}
	   
	public static void clear() 
	{
		_ranges.clear();
	}

	public static void addRange(ZipcodeRange newRange) 
	{
		if(_ranges.isEmpty())	// First range in
		{
			_ranges.add(newRange);
		}
		else // Determine if merge, or simple add
		{
			ListIterator<ZipcodeRange> rangeIterator = _ranges.listIterator();
			boolean insertRange = true;	// Add the range to the range list at the end of loop if true.
			while( rangeIterator.hasNext()) 
			{
				ZipcodeRange range = rangeIterator.next();	
				
				if( range.getLow() <= newRange.getLow() && range.getHigh() >= newRange.getHigh()) // New range is contained within pre-existing range.	
				{
					insertRange = false;
				}
				
				else if( range.getLow() > newRange.getHigh() || range.getHigh() < newRange.getLow()) // New range is not contained within.
				{
					insertRange = true;
				}
				
				else  // Partial containment, update one end of an existing range.
				{
					insertRange = true;
					if(range.getLow() < newRange.getLow())
					{
						newRange.setLow(range.getLow());
					}
					if(range.getHigh() > newRange.getHigh())
					{
						newRange.setHigh(range.getHigh());
					}	
					rangeIterator.remove();
					
				}
			}
			if(insertRange)
			{
				_ranges.add(newRange);
			}
		}
   }
	
	public static int size() 
	{
		return _ranges.size();
	}
	
   public static void printRange() 
   {
	   if(!_ranges.isEmpty()) 
	   {
		   for(ZipcodeRange range :_ranges) 
		   {
			   System.out.println(range.toString());
		   }
	   }
   }
   
   
   

}
