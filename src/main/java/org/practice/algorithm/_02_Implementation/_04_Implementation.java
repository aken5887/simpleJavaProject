package org.practice.algorithm._02_Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.practice.algorithm.MyScanner;

public class _04_Implementation {

  public static void main(String[] args) {
    String S = MyScanner.scan.next();
    List<Character> stringList = new ArrayList<>();
    int result = 0;
    for(int i=0; i < S.length(); i++){{
      char str = S.charAt(i);
      if(Character.isLetter(str)){
        stringList.add(str);
      }else{
       result += (str - '0');
      }
    }}
    Collections.sort(stringList);
    String result2 = "";
    for (char element:stringList){
      result2 += String.valueOf(element);
    }
    System.out.println(result2+result);
  }
}
