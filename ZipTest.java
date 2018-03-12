package RangePackage;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;

public class ZipTest 
{
    
    @After
    public void after() 
    {
        ZipcodeRangeMerger.clear();
    }
  
    @Test
	public void test1() 	// Stopped using 5-digit long numbers here just to make creating / typing tests easier on me.
	{
    	ZipcodeRange range1 = new ZipcodeRange(0, 1);
		ZipcodeRange range2 = new ZipcodeRange(2, 3);
		ZipcodeRange range3 = new ZipcodeRange(4, 5);
		
		ZipcodeRangeMerger.addRange(range1);
		ZipcodeRangeMerger.addRange(range2);
		ZipcodeRangeMerger.addRange(range3);
		
		Assert.assertEquals("Size mismatch in test1", 3, ZipcodeRangeMerger.size());
		
		ZipcodeRange range4 = new ZipcodeRange(0, 1);
		ZipcodeRange range5 = new ZipcodeRange(2, 3);
		ZipcodeRange range6 = new ZipcodeRange(4, 5);
		ArrayList<ZipcodeRange> correctAnswer = new ArrayList<>();
		correctAnswer.add(range4);
		correctAnswer.add(range5);
		correctAnswer.add(range6);
		Assert.assertEquals("Ranges mismatch in test1", correctAnswer, ZipcodeRangeMerger.getZipRanges());
		
		after();
	}
    
	@Test
	public void test2() 
	{
		ZipcodeRange range1 = new ZipcodeRange(95616, 95618); // Woo Davis.
		ZipcodeRange range2 = new ZipcodeRange(95000, 95616);
		ZipcodeRange range3 = new ZipcodeRange(95618, 96123);
		ZipcodeRange range4 = new ZipcodeRange(94460, 94900);
		ZipcodeRange range5 = new ZipcodeRange(97123, 97742);
		
		ZipcodeRangeMerger.addRange(range1);
		ZipcodeRangeMerger.addRange(range2);
		ZipcodeRangeMerger.addRange(range3);
		ZipcodeRangeMerger.addRange(range4);
		ZipcodeRangeMerger.addRange(range5);
		
		//Test size
		Assert.assertEquals("Size mismatch in test2", 3, ZipcodeRangeMerger.size());
		
		//Test content
		ZipcodeRange f = new ZipcodeRange(95000, 96123);
		ArrayList<ZipcodeRange> correctAnswer = new ArrayList<>();
		correctAnswer.add(f);
		correctAnswer.add(range4);
		correctAnswer.add(range5);
		
		Assert.assertEquals("Ranges mismatch in test2", correctAnswer, ZipcodeRangeMerger.getZipRanges());
		after();
	}
	
	@Test
	public void test3() 
	{
		ZipcodeRange range1 = new ZipcodeRange(0, 1);
		ZipcodeRange range2 = new ZipcodeRange(2, 4);
		ZipcodeRange range3 = new ZipcodeRange(3, 5);
		
		ZipcodeRangeMerger.addRange(range1);
		ZipcodeRangeMerger.addRange(range2);
		ZipcodeRangeMerger.addRange(range3);
		
		Assert.assertEquals("Size mismatch in test3", 2, ZipcodeRangeMerger.size());
		
		ZipcodeRange range4 = new ZipcodeRange(0, 1);
		ZipcodeRange range5 = new ZipcodeRange(2, 5);
		
		ArrayList<ZipcodeRange> correctAnswer = new ArrayList<>();
		correctAnswer.add(range4);
		correctAnswer.add(range5);
		Assert.assertEquals("Ranges mismatch in test3", correctAnswer, ZipcodeRangeMerger.getZipRanges());
		
		after();
	}
}