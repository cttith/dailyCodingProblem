/*
 * This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array 
is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], 
the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class Problem2 {

	
	public static int[] withDivision(int list[]) {
		
		int totalProduct = 1;
		for(int i = 0; i < list.length; i++)
		{
			totalProduct *= list[i];
		}
		
		for(int i = 0; i < list.length; i++) 
		{
			list[i] = totalProduct/list[i];
		}
		
		
		return list;
	}
	
	// arr[i] = (left[0]*left[1]*...,left[i-1]) * (right[i+1]*right[i+2]*....right[n])
	public static int[] withoutDivision(int list[]) {
		int n = list.length;
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = 1;
		right[n-1] = 1;
		
		// left arr -- product of everything to the left of list[i] at left[i]
		for(int i = 1; i < n; i++) 
		{
			left[i] = list[i-1] * left[i-1];
		}
		// right arr -- product of everything to the right of list[i] at right[i]
		for(int i = n-2; i >= 0; i--)
		{
			right[i] = right[i+1] * list[i+1];
		}
		// arr[i] = (left[0]*left[1]*...,left[i-1]) * (right[i+1]*right[i+2]*....right[n])

		for(int i = 0; i < list.length; i++)
		{
			list[i] = left[i]*right[i];
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		int list[] = {1, 2, 3, 4, 5};
		int ans[] = null;
		int ans1[] = null;
		ans = withDivision(list);
		int list1[] = {1, 2, 3, 4, 5};

		ans1 = withoutDivision(list1);
		
		for(int i =0; i < ans.length; i++)
		{
			System.out.print(ans[i] + " ");
		}
		
		System.out.print("\n");
		for(int i = 0; i < ans1.length; i++)
		{
			System.out.print(ans1[i] + " ");
		}
		
	}
}
