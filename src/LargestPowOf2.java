
public class LargestPowOf2 {

	public static int largestPowOf2(int n) {
		
		int ret=1;
		
		for(int i=2; i<=n; i=i*2) {
			if(n < i) break;
			ret = i;	
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestPowOf2(2));
		System.out.println(largestPowOf2(1));
		System.out.println(largestPowOf2(7));
		System.out.println(largestPowOf2(12));
		System.out.println(largestPowOf2(32));
		System.out.println(largestPowOf2(33));
		System.out.println(largestPowOf2(128));
		System.out.println(largestPowOf2(1000));
		System.out.println(largestPowOf2(4000));
		System.out.println(largestPowOf2(1200));
		System.out.println(largestPowOf2(33260));
		System.out.println(largestPowOf2(600));
	}

}
