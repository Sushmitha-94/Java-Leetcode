import java.util.ArrayList;
import java.util.List;

public class MatrixSpider {

	public static List<Integer> spiralOrder(int[][] matrix) {
        int k=matrix.length-1;
        int l=matrix[0].length-1;
        int i=0,j=0;
        int m;
        List<Integer> ret = new ArrayList<Integer>();
        
        while(i<=k && j<=l){
            for(m=j;m<=l;m++){
            	ret.add(matrix[i][m]);
            }
            i++;
            
            for(m=i;m<=k;m++) {
            	ret.add(matrix[m][l]);
            }
            l--;
            
            if(i<=k) {
	            for(m=l;m>=j;m--) {
	            	ret.add(matrix[k][m]);
	            }
	            k--;
            }
            
            if(j<=l) {
	            for(m=k;m>=i;m--) {
	            	ret.add(matrix[m][j]);
	            }
	            j++;
            }
        }
        return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat= { { 1, 2, 3,4 },
                {  5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
		List<Integer> ret = spiralOrder(mat);
		System.out.println(ret.toString());
	}

}
