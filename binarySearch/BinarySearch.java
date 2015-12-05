package binarySearch;

public class BinarySearch {

    /**
     * @param arr is the array passed to the method
     * @return we got our arr array back sorted
     */
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

    /**
     * @param arr is the array passed to the method, which needs to be sorted
     * @param start is the index where the sorting should start
     * @param end is the index where the sorting should end
     * @return the array sorted
     * Sorts the array with the quicksort algorithm where the elements are
     * compared to the pivot
     */
    public int[] quickSort(int[] arr, int start, int end) {
        if (start >= end) return arr;
        // determine the pivot
        int pivot = arr[end];

        // puts all the elements on the left side of the pivot that less than the pivot
        // and to the right side the ones that greater than the pivot
        int leftIndex = start;
        int rightIndex = end - 1;
        while (leftIndex < rightIndex) {
            while (arr[leftIndex] < pivot && leftIndex+1 < end) leftIndex++;
            while (arr[rightIndex] >= pivot && rightIndex-1 >= 0) rightIndex--;
            if (leftIndex <= rightIndex) swap(arr, leftIndex, rightIndex);
        }
        // swaps the pivot to its final index place
        swap(arr, leftIndex, end);

        // recursively called with the same array, but decreasing the
        // range of the array without touching the pivot
        quickSort(arr, start, leftIndex - 1);
        quickSort(arr, leftIndex + 1, end);

        return arr;
    }

    /**
     * Swap elements in the array
     * @param arr contains the two elements need to be swapped
     * @param i is element index in the array swapped with element on index j
     * @param j is element index in the array swapped with element on index i
     */
    private static final void swap(int[] arr, int i, int j) {
        int placeholder = arr[i];
        arr[i] = arr[j];
        arr[j] = placeholder;
    }

    /**
     * Checks if the array is sorted
     * @param arr is the array will be checked
     * @return true if the array is sorted, false if not
     */
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    /**
     * Checks if the array is sorted and pass it through accordingly to the search method
     * @param original is the array to be checked
     * @param number is the number we are looking for
     * @return the index of the number or -1 if it hasn't been found
     */
    public int binarySearch(int[] original, int number) {
        return (original.length > 0 && !isSorted(original)) ?
                bSearch(quickSort(original, 0, original.length - 1), number, 0, original.length - 1) : bSearch(original, number, 0, original.length - 1);
    }

    /**
     * Search for the number by eliminating half of the array recursively
     * until either the number is found or no numbers left to check
     * @param sortedArray is already checked if it sorted
     * @param number is the number we are looking for
     * @param start is the first index of the range of array
     * @param end the last index of the range of array
     * @return the index of the number or -1 if it hasn't been found
     */
    private int bSearch(int[] sortedArray, int number, int start, int end) {
        if(start >= end && sortedArray[start] != number) return -1;
        int middle = (start + end) / 2;

        if(sortedArray[middle] == number) return middle;
        if (sortedArray[middle] > number) return bSearch(sortedArray, number, start, middle - 1);
        else if (sortedArray[middle] < number) return bSearch(sortedArray, number, middle + 1, end);
        else return -1;
    }

}
