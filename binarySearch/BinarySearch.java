package binarySearch;

public class BinarySearch {

    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        // split the array in half
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];
        // fill them up
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[left.length + i];
        }
        // recursively call until only 1 element is in the array
        mergeSort(left);
        mergeSort(right);

        int lc = 0;   // counter for left array
        int rc = 0;   // counter for right array
        // MERGING : compare the front element of left and the right array
        // take the smaller one and add it to the array on the current position
        // if there is no element left on one of the side,
        // add the remaining elements to the array from the other side.
        for (int ac = 0; ac < arr.length; ac++) {
            if (lc >= left.length) {
                arr[ac] = right[rc];
                rc++;
                continue;
            }
            if (rc >= right.length) {
                arr[ac] = left[lc];
                lc++;
                continue;
            }
            if (left[lc] < right[rc]) {
                arr[ac] = left[lc];
                lc++;
            } else {
                arr[ac] = right[rc];
                rc++;
            }
        }

        return arr;
    }

    public int[] quickSort(int[] arr){




        return arr;
    }


//    public int bSearch(int[] thearray){
//
//    }
}
