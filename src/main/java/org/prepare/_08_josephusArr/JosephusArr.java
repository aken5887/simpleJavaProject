package org.prepare._08_josephusArr;

import org.checkerframework.checker.units.qual.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class JosephusArr {
    public static void main(String[] args) {
        JosephusArr josephusArr = new JosephusArr();
        List<Integer> removed = josephusArr.solution(7, 3);
        System.out.println(removed);
    }

    private List<Integer> solution(int n, int m){
        // n 명의 사람 중에 순차적으로 m 번째 사람을 제거한다.
      List<Integer> person = new ArrayList<>();
      List<Integer> removed = new ArrayList<>();

      for(int i=1; i<=n ; i++){
          person.add(i);
      }

      int index = 0;
      while(!person.isEmpty()){
          index = (index + m - 1) % person.size();
          removed.add(person.remove(index));
      }
      return removed;
    }
}
