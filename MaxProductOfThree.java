import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public class MaxProductOfThree {


    /**
     * Given a non-empty array A,
     * return the value of the maximal product of any triplet.
     * 
     * Check these combinations:
     * 
     * o first 3 elements (highest values)
     * o last 3 elements (lowest values – can have 2 large negative values 
     *   that create a positive and then multipled by a positive)
     * o first element and last 2 elements
     * o first 2 elements and last element
     * 
     * Runtime: O(n) - Space: O(6)
     */
    static public int maxProductOfThree(int[] arr) {

        // **** initialization ****
        int[] maxArr = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] minArr = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        // **** traverse the array looking for the maximum values - O(n + 6) ****
        for (int v : arr) {

            // **** update max values - O(3) ****
            maxValues(maxArr, v);

            // **** update min values - O(3) ****
            minValues(minArr, v);
        }

        // ???? ????
        System.out.println("<<< maxArr: " + Arrays.toString(maxArr));
        System.out.println("<<< minArr: " + Arrays.toString(minArr));

        // **** [1] first 3 elements ****
        int maxVal = maxArr[0] * maxArr[1] * maxArr[2];

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** [2] last 3 elements ****
        int p = minArr[0] * minArr[1] * minArr[2];
        if (p > maxVal) maxVal = p;

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** [3] first element and last 2 elements ****
        p = maxArr[0] * minArr[0] * minArr[1];
        if (p > maxVal) maxVal = p;

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** [4] first 2 elements and last element ****
        p = maxArr[0] * maxArr[1] * minArr[0];
        if (p > maxVal) maxVal = p;

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** return this product ****
        return maxVal;
    }


    /**
     * Auxiliary function.
     * Keep 3 largest values in array.
     * 
     * Runtime: O(3) - Space: O(0)
     */
    static private void  maxValues(int[] maxArr, int v) {
        if (v > maxArr[0]) {
            maxArr[2] = maxArr[1];
            maxArr[1] = maxArr[0];
            maxArr[0] = v;
        } else if (v > maxArr[1]) {
            maxArr[2] = maxArr[1];
            maxArr[1] = v;
        } else if (v > maxArr[2]) {
            maxArr[2] = v;
        }
    }


    /**
     * Auxiliary function.
     * Keep 3 mallest values in array.
     * 
     * Runtime: O(3) - Space: O(0)
     */
    static private void minValues(int[] minArr, int v) {
        if (v < minArr[0]) {
            minArr[2] = minArr[1];
            minArr[1] = minArr[0];
            minArr[0] = v;
        } else if (v < minArr[1]) {
            minArr[2] = minArr[1];
            minArr[1] = v;
        } else if (v < minArr[2]) {
            minArr[2] = v;
        }
    }


    /**
     * Given a non-empty array A,
     * return the value of the maximal product of any triplet.
     * 
     * Check these combinations:
     * 
     * o first 3 elements (highest values)
     * o last 3 elements (lowest values – can have 2 large negative values 
     *   that create a positive and then multipled by a positive)
     * o first element and last 2 elements
     * o first 2 elements and last element
     * 
     * Runtime: O(n * log(n)) - Space: O(n)
     */
    static public int maxProductOfThree0(int[] arr) {

        // **** initialization - create and populate list ****
        List<Integer> lst   = new ArrayList<>();
        for (int v : arr)
            lst.add(v);

        // ???? ????
        System.out.println("<<< lst: " + lst.toString());
        
        // **** sort the list - O(n * log(n)) ****
        Collections.sort(lst, (a,b) -> b - a);

        // ???? ????
        System.out.println("<<< lst: " + lst.toString());

        // **** first 3 elements ****
        int maxVal = lst.get(0) * lst.get(1) * lst.get(2);

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** last 3 elements ****
        int siz = lst.size();
        int p = lst.get(siz - 1) * lst.get(siz - 2) * lst.get(siz - 3);

        // **** update max value ****
        if (p > maxVal) maxVal = p;

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** first element and last 2 elements ****
        p = lst.get(0) * lst.get(siz - 1) * lst.get(siz - 2);

        // **** update max value ****
        if (p > maxVal) maxVal = p;

        // ???? ????
        System.out.println("<<< maxVal: " + maxVal);

        // **** first 2 elements and last element ****
        p  = lst.get(0) * lst.get(1) * lst.get(siz - 1);

        // **** update max value ****
        if (p > maxVal) maxVal = p;

        // **** return max value ****
        return maxVal;
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] arr ****
        int[] arr = Arrays.stream(br.readLine().trim().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** call function of interest and display result ****
        System.out.println("main <<< result: " + maxProductOfThree0(arr));

        // **** call function of interest and display result ****
        System.out.println("main <<< result: " + maxProductOfThree(arr));
    }

}