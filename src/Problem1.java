import java.util.HashMap;
import java.util.Iterator;

/* 
 * This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

 */

 
public class Problem1 {

	public static boolean twoNums(int list[], int target) {
		
		HashMap<Integer,Integer> valIndexMap = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < list.length; i++)
		{
			valIndexMap.put(list[i], i);
		}
		
	    int differenceVal;
	    
	    for(int key : valIndexMap.keySet())
	    {
	    	differenceVal = target - key;
	    	if(valIndexMap.containsKey(differenceVal))
	    	{
	    		return true;
	    	}
	    }
	    
	  
		return false;
	}
	
	public static void main(String args[]) {
		
		int nums[] = {10,15,3,7};
		int target = 13;
		
		if(twoNums(nums,target))
		{
			System.out.println("Success");
		}else {
			System.out.println("Fail");
		}
	}
	
	
}
