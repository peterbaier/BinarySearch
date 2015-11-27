package binarySearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BinarySearchTest {
    BinarySearch bs;
    int[] myArray = {21,23,4,87,43,76,32,2,45,6,3,2,7};

    @Before
    public void setUp() throws Exception {
        bs = new BinarySearch();
    }

    @Test
    public void testMergeSort() throws Exception {
        int[] result = bs.mergeSort(myArray);
        System.out.println("Pre-written array sorted: ");
        for(int x : result ) {
            System.out.print(x + " ");
        }
        assertArrayEquals(new int[]{2,2,3,4,6,7,21,23,32,43,45,76,87},result);
        System.out.println("");
    }

    @Test
    public void testMergeSortWithRandomArray(){
        int[] randArray = new int[30];
        System.out.println("\nRandom Array elements unsorted: ");
        for (int i = 0; i < randArray.length ; i++) {
            randArray[i] = (int)(Math.random()*200 + 1);
            System.out.print(randArray[i] + " ");
        }
        System.out.println("\nand Sorted: ");
        int[] result = bs.mergeSort(randArray);
        for(int x : randArray ) {
            System.out.print(x + " ");
        }
        System.out.println("\n");


    }
}