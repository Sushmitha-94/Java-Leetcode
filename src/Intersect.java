import java.util.ArrayList;
import java.util.HashMap;

public class Intersect {

	public static int[] intersect(int[] nums1, int[] nums2) {
		String nums2Str = nums2.toString();
		HashMap<Integer, ArrayList<Integer>> mapInt = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<nums1.length;i++) {
			if(i>0) {
				if(mapInt.containsKey(nums1[i])) {
					mapInt.get(nums1[i]).add(nums1[i-1]);
				}
				else {
					mapInt.put(nums1[i], new ArrayList<Integer>());
					mapInt.get(nums1[i]).add(nums1[i-1]);
				}
			}
			if(i<nums1.length-1) {
				if(mapInt.containsKey(nums1[i])) {
					mapInt.get(nums1[i]).add(nums1[i+1]);
				}
				else {
					mapInt.put(nums1[i], new ArrayList<Integer>());
					mapInt.get(nums1[i]).add(nums1[i+1]);
				}
			}
		}
		
		for(int j=0; j < nums2.length ; j++) {
			if(mapInt.containsKey(nums2[j])) {
				if(j>0) {
					if(mapInt.get(nums2[j]).contains(nums2[j-1])) {
						int[] ret = {nums2[j],nums2[j-1]};
						return ret;
					}
				}
				if(j<nums2.length-1) {
					if(mapInt.get(nums2[j]).contains(nums2[j+1])) {
						return new int[] {nums2[j],nums2[j+1]};
					}
				}
			}
		}
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
		int[] ret = intersect(nums1,nums2);
		System.out.println(ret[0]);
		System.out.println(ret[1]);
	}

}
