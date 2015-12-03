package binarySearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BinarySearchTest {
    BinarySearch bs;
    int[] myArray;
    int[] expected;
    int[] randArray;

    @Before
    public void setUp() throws Exception {
        myArray = new int[]{21,23,4,87,43,76,32,2,45,6,3,2,7};
        expected = new int[]{2,2,3,4,6,7,21,23,32,43,45,76,87};
        bs = new BinarySearch();
        randArray = new int[13];

    }

    @Test
    public void testMergeSort() throws Exception {
        int[] result = bs.mergeSort(myArray);
        System.out.println("Pre-written array sorted by MergeSort: ");
        for(int x : result ) {
            System.out.print(x + " ");
        }
        assertArrayEquals(expected,result);
        System.out.println("");

    }

    @Test
    public void testMergeSortWithRandomArray(){
        System.out.println("\nRandom Array elements unsorted: ");
        for (int i = 0; i < randArray.length ; i++) {
            randArray[i] = (int)(Math.random()*200 + 1);
            System.out.print(randArray[i] + " ");
        }
        System.out.println("\nand Sorted by MergeSort: ");
        int[] result = bs.mergeSort(randArray);
        for(int x : result ) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }

    @Test
    public void quickSortTest(){
        int[] result = bs.quickSort(myArray,0,myArray.length-1);
        System.out.println("Pre-written array sorted by QuickSort: ");
        for(int x : result ) {
            System.out.print(x + " ");
        }
        assertArrayEquals(expected,result);
        System.out.println("");

    }

    @Test
    public void testQuickSortWithRandomArray(){
        for (int i = 0; i < randArray.length ; i++) {
            randArray[i] = (int)(Math.random()*200 + 1);
        }
        for(int x : randArray ) {
            System.out.print(x + " ");
        }
        System.out.println("");
        int[] exp = bs.mergeSort(randArray);
        int[] act = bs.quickSort(randArray, 0, randArray.length - 1);

        for(int x : exp ) {
            System.out.print(x + " ");
        }
        System.out.println("");
        for(int x : act ) {
            System.out.print(x + " ");
        }
        System.out.println("");

        assertArrayEquals(exp,act);
    }

    @Test
    public void notRandomQuickSort(){
        int[] arr = new int[] {121,143,105,75,85,96,72,107,51,75,75,102,96};
        int[] exp = new int[] {51,72,75,75,75,85,96,96,102,105,107,121,143,};
        assertArrayEquals(exp, bs.quickSort(arr, 0, arr.length - 1));


    }

    @Test
    public void multipleTest(){
        for (int i = 0; i < 50; i++) {
            System.out.println(i+1+".");
        testQuickSortWithRandomArray();

        }
    }
}