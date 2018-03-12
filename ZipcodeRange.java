package RangePackage;

public class ZipcodeRange 
{
	private int low;
	private int high;
	
	ZipcodeRange(int low, int high)
	{
		if(low <= high) 
		{
			this.low = low;
			this.high = high;
		} 
		else 
		{
			this.low = high;
			this.high = low;	
		}
	}

	public int getLow() 
	{
		return low;
	}

	public int getHigh() 
	{
		return high;
	}
	
	public void setLow(int low) 
	{
		this.low = low;
	}

	public void setHigh(int high) 
	{
		this.high = high;
	}
	
	public boolean equals(Object compareTarget)
	{
		boolean retVal = false;
        if (compareTarget instanceof ZipcodeRange) 
        {
            ZipcodeRange targetRange = (ZipcodeRange) compareTarget;
            if (this.getLow() == targetRange.getLow() && this.getHigh() == targetRange.getHigh())
            {
            	retVal = true;
            }
        }
        return retVal;
	}
	
	public String toString() 
	{
		return String.format("['%d','%d']", low, high );
	}
}
