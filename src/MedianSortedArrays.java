
/*4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106*/


public class MedianSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i=0,j=0;		
		int m = nums1.length, n = nums2.length;
		int size = m+n;
		int[] nums3 = new int[size];
		for(int k=0; k< size ; k++) {
			if((i<m && j<n && nums1[i]<nums2[j]) || (i<m && j>=n))
				nums3[k++] = nums1[i++];
			else if((i<m && j<n && nums1[i]>=nums2[j]) || (i>=m && j<n))
				nums3[k++] = nums2[j++];
			else
				break;
		}
		int index = (int) Math.floor(size/2);
		if(size==1)
			return nums3[0];
		else if (size>1) {
			if(size%2 !=0)
				return nums3[index];
			else
				return (nums3[index]+nums3[index-1])/2;
		}
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
