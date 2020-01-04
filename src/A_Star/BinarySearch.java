package A_Star;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// Java implementation of recursive Binary Search
public class BinarySearch {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    public Pair<Integer,Integer> binarySearch(List<Integer> arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr.get(mid) == x)
                return new Pair<>(mid,arr.get(mid));

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
        else {
            if(r == arr.size() -1)
            return new Pair<>(r,arr.get(r)) ;
            else return new Pair<>(r+1,arr.get(r+1));
        }

        // We reach here when element is not present
        // in array
    }

    // Driver method to test above
    public static void main(String args[])
    {
//        BinarySearch ob = new BinarySearch();
//        int[] arr1= { 2, 3, 4, 10, 40 };
//        List<Integer> arr= new ArrayList<>();
//        for (int i = 0; i < arr1.length; i++) {
//            arr.add(arr1[i]);
//        }
//        int n = arr.size();
//        int x = 3;
//        int result = ob.binarySearch(arr, 0, n - 1, x);
//        if (result == -1)
//            System.out.println("Element not present");
//        else
//            System.out.println("Element found at index " + result);
    }
}
/* This code is contributed by Rajat Mishra */
