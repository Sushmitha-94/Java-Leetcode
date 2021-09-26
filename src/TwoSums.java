import java.util.HashMap;

public class TwoSums {
	
	
	/*
	 *  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

		Example 1:
		
		Input: nums = [2,7,11,15], target = 9
		Output: [0,1]
		Output: Because nums[0] + nums[1] == 9, we return [0, 1].
		Example 2:
		
		Input: nums = [3,2,4], target = 6
		Output: [1,2]
		Example 3:
		
		Input: nums = [3,3], target = 6
		Output: [0,1]
		 
		
		Constraints:
		
		2 <= nums.length <= 104
		-109 <= nums[i] <= 109
		-109 <= target <= 109
		Only one valid answer exists.
		 
		
		Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
	 */
	
	// My Solution O(N^2) using arrays
	// Runtime: 49 ms, faster than 27.97% of Java online submissions for Two Sum.
	// Memory Usage: 39.1 MB, less than 70.64% of Java online submissions for Two Sum.
	
	public static int[] twoSum(int[] nums, int target) {
        if(nums.length>0){            
            for(int i=0;i<nums.length;i++){
                for(int j=i+1; j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        return new int[] {i,j};
                    }
                }
            }
            
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {3,2,4};
		int[] ret = twoSumB(nums, 6);
		if(ret!=null) {
			System.out.println("["+ret[0]+","+ret[1]+"]");
		}

	}
	
	//Better Solution
	/*	Hash Map
		The problem can be solved in O(N) time, using extra space.
		- Create a new HashMap
		- Iterate over the array
  		- Subtract current array element from target
  		- Check if the above difference exists in HashMap
    	- If YES, then return the current index and the value of the difference in HashMap
    	- If NO, then store the current element as HashMap key and current index as its value
		- Return empty array as a result if nums array iteration is completed in the above step
	 */
	
	public static int[] twoSumB(int[] nums, int target) {
		
		// Contains the difference required and the index. 
		// For eg., Input: nums = [3,2,4], target = 6
		// mapNum={[3,1],[4,2],[2,3]} => [(6-3), index of 3], breaks to add match is found
		HashMap<Integer, Integer> mapNum = new HashMap<Integer,Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(!mapNum.containsKey(nums[i])) 
				mapNum.put(target-nums[i], i);
			else
				return new int[] {mapNum.get(nums[i]), i};
		}
		
		return null;
	}

}
