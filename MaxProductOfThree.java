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
     */
    static public int maxProductOfThree0(int[] arr) {

        // **** initialization ****
        int[] maxArr = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        // ???? ????
        System.out.println("<<< maxArr: " + Arrays.toString(maxArr));

        // **** traverse the array looking for the maximum values ****
        for (int v : arr) {

            // **** ****
            maxValues(maxArr, v);

            // ???? ????
            System.out.println("<<< maxArr: " + Arrays.toString(maxArr));
        }

        // **** return this product ****
        return maxArr[0] * maxArr[1] * maxArr[2];
    }


    /**
     * Auxiliary function.
     * Keep three largest values in first argument.
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
     * Given a non-empty array A,
     * return the value of the maximal product of any triplet.
     * 
     * Possible combinations: 
     * o first 3 elements (highest values)
     * o last 3 elements (lowest values – can have 2 large negative values that create a positive and then multipled by a positive)
     * o first element and last 2 elements
     * o first 2 elements and last element
     * 
     * Runtime: O(n * log(n)) - Space: O(n)
     */
    static public int maxProductOfThree(int[] arr) {

        // **** initialization ****
        int maxVal          = Integer.MIN_VALUE;

        // **** create and populate list ****
        List<Integer> lst   = new ArrayList<>();
        for (int v : arr)
            lst.add(v);

        // ???? ????
        System.out.println("<<< lst: " + lst.toString());
        
        // **** sort the list - O(n * log(n)) ****
        Collections.sort(lst);

        // ???? ????
        System.out.println("<<< lst: " + lst.toString());

        // **** first 3 elements ****
        int a = lst.get(0);
        int b = lst.get(1);
        int c = lst.get(2);
        int p = a * b * c;

        // ???? ????
        System.out.println("<<< p: " + p);

        // **** update max value ****
        maxVal = maxVal > p ? maxVal : p;

        // **** last 3 elements ****
        int siz = lst.size();
        int z = lst.get(siz - 1);
        int y = lst.get(siz - 2);
        int x = lst.get(siz - 3);
        p = x * y * z;

        // ???? ????
        System.out.println("<<< p: " + p);

        // **** update max value ****
        maxVal = maxVal > p ? maxVal : p;

        // **** first element and last 2 elements ****
        p = a * y * z;

        // ???? ????
        System.out.println("<<< p: " + p);

        // **** update max value ****
        maxVal = maxVal > p ? maxVal : p;

        // **** first 2 elements and last element ****
        p  = a * b * z;

        // ???? ????
        System.out.println("<<< p: " + p);

        // **** update max value ****
        maxVal = maxVal > p ? maxVal : p;

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
        System.out.println("main <<< result: " + maxProductOfThree(arr));
    }

}