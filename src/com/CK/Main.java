package com.CK;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];

        int p = prerequisites.length;
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }
        Queue<Integer> list = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) list.offer(i);
        }

        while (!list.isEmpty()) {
            int curr = list.poll();
            res.add(curr);
            for (int i = 0; i < p; i++) {
                if (prerequisites[i][1] == curr) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0)
                        list.offer(prerequisites[i][0]);
                }
            }
        }
        if (res.size() != numCourses) return new int[0];
        int[] returnArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            returnArr[i] = res.get(i);
        }
        return returnArr;
    }
}


