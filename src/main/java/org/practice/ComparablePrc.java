package org.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparablePrc {
  static class Score implements Comparable<Score>{
    int math;
    int english;

    public Score(int math, int english){
      this.math = math;
      this.english = english;
    }

    @Override
    public String toString() {
      return "Score{" +
          "math=" + math +
          ", english=" + english +
          '}';
    }

    @Override
    public int compareTo(Score o) {
      if(o.english != this.english ){
        return o.english - this.english;
      }
      return o.math - this.math;
    }
  }

  public static void main(String[] args) {
    List<Score> scoreList = new ArrayList<>();
    scoreList.add(new Score(10, 20));
    scoreList.add(new Score(11, 20));
    scoreList.add(new Score(5, 30));
    Collections.sort(scoreList);
    System.out.println(scoreList.toString());
  }
}
