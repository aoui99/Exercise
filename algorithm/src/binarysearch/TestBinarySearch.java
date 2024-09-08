package binarysearch;

import org.junit.Test;

import static binarysearch.BinarySearch.binarySearchBasic;
import static org.junit.Assert.assertEquals;

public class TestBinarySearch {
    @Test
    public void test1() {
        int[] a = {7,13,21,30,38,44,52,53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(-1, binarySearchBasic(a, 10));

    }
}
