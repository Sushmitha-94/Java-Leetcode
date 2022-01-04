import java.io.*;
import java.util.*;

public class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
        List<Integer> newA = a.subList(0, 4);
        for(int i=0;i<a.size();i++){
            int newP = (i+d)%a.size();
            newA.add(newP,a.get(i));
        }
        return newA;
    }

    public static void main(String[] args) {
       List<Integer> a =new ArrayList<Integer>(5);
       a.add(1);
       a.add(2);
       a.add(3);
       a.add(4);
       a.add(5);
       List<Integer> ab = rotLeft(a,2);
       System.out.println(ab.toString());
    }
}