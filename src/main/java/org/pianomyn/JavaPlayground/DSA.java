package org.pianomyn.JavaPlayground;

import java.util.*;

public class DSA {
  public static int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int left = 0, right = n - 1;

    while(left <= right) {
      int mid = left + (right - left) / 2;

      if(arr[mid] == target) {
        return mid;
      } else if(arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }


  public static List<Integer> bfs(Map<Integer, List<Integer>> adjList, int start) {
    List<Integer> traversal = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> frontier = new LinkedList<>();

    // enqueue starting node
    frontier.add(start);
    visited.add(start);

    while(!frontier.isEmpty()) {
      int current = frontier.poll();

      // get neighbours, if not visited, add to frontier, mark as visited
      enqueueNeighbours(adjList, current, visited, frontier);
      traversal.add(current);
    }

    return traversal;
  }

  private static void enqueueNeighbours(Map<Integer, List<Integer>> adjList, int current, Set<Integer> visited, Queue<Integer> frontier) {
    for(int neighbour : adjList.get(current)) {
      if(visited.contains(neighbour)) {
        continue;
      }

      visited.add(neighbour);
      frontier.add(neighbour);
    }
  }
  public static List<Integer> dfs(Map<Integer, List<Integer>> adjList, int start) {
    List<Integer> traversal = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> frontier = new Stack<>();

    // stack starting node
    frontier.add(start);
    visited.add(start);

    while(!frontier.isEmpty()) {
      int current = frontier.pop();

      // get neighbours, if not visited, add to frontier, add to visited
      stackNeighbours(adjList, current, visited, frontier);
      traversal.add(current);
    }

    return traversal;
  }

  private static void stackNeighbours(Map<Integer, List<Integer>> adjList, int current, Set<Integer> visited, Stack<Integer> frontier) {
    for(int neighbour : adjList.get(current)) {
      if(visited.contains(neighbour)) {
        continue;
      }

      visited.add(neighbour);
      frontier.add(neighbour);
    }
  }

  public static void djikstras() {

  }

}
