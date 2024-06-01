
package org.pianomyn.JavaPlayground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Another {
  public static void main(String args[]) {
    List<Integer> nums = new ArrayList<>();
    nums.add(43);
    nums.add(31);
    nums.add(72);
    nums.add(29);

    Collections.sort(nums, new Comparator<Integer>() {
      @Override
      public int compare(Integer i, Integer j) {
        return i % 10 > j % 10 ? 1 : -1;
      }
    });

    PriorityQueue<Integer> pq = new PriorityQueue<>(
      new Comparator<Integer>() {
        @Override
        public int compare(Integer i, Integer j) {
          return i % 10 > j % 10 ? 1 : -1;
        }
      }
    );

    System.out.println(nums);
  }
}
