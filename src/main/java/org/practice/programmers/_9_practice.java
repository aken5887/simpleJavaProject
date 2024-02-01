package org.practice.programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 우선순위 큐
 */
public class _9_practice {
    public static void main(String[] args) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        PriorityQueue<User> userQueue = new PriorityQueue<>();
        userQueue.add(new User(33));
        userQueue.add(new User(41));
        userQueue.add(new User(20));
        System.out.println(userQueue.peek().getAge());

        System.out.println(8 + (8 >> 1));
    }

    static class User implements Comparable<User> {
        private int age;

        public User(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int compareTo(User user) {
            return Integer.compare(user.getAge(), this.age);
        }
    }
    int result = 0;
    void dfs(int[][] maps, int[] current, int count){
        int row = current[0];
        int column = current[1];
        // 종료
        if(row > maps.length || column > maps[0].length){
            return;
        }
        if(row == maps.length && column == maps[0].length){
            if(result == 0 || count < result){
                result = count;
            }
        }

        if(maps[row][column] == 0){
            return; // 벽
        } else {
            count++;
            dfs(maps, new int[]{row, column - 1}, count);
            dfs(maps, new int[]{row, column + 1}, count);
            dfs(maps, new int[]{row - 1, column}, count);
            dfs(maps, new int[]{row + 1, column}, count);
        }
    }
}
