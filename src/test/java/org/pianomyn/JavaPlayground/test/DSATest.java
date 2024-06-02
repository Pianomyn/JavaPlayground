package org.pianomyn.JavaPlayground.test;

import org.junit.jupiter.api.Test;
import org.pianomyn.JavaPlayground.DSA;

public class DSATest {
  @Test
  public void binarySearchEmptyTest() {
    assert(DSA.binarySearch(new int[]{}, 1) == -1);
  }
  @Test
  public void binarySearchSingleTest() {
    assert(DSA.binarySearch(new int[]{1}, 1) == 0);
  }

  @Test
  public void binarySearchMultipleTest() {
    assert(DSA.binarySearch(new int[]{1,2,3,4,5}, 4) == 3);
  }

  @Test
  public void binarySearchLeftEdgeTest() {
    assert(DSA.binarySearch(new int[]{1,2,3,4,5}, 5) == 4);
  }

  @Test
  public void binarySearchRightEdgeTest() {
    assert(DSA.binarySearch(new int[]{1,2,3,4,5}, 1) == 0);
  }

  @Test
  public void binarySearchNonExistantTest() {
    assert(DSA.binarySearch(new int[]{1,2,3,4,5}, 6) == -1);
  }
}
