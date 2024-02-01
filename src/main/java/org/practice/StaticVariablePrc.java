package org.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class StaticVariablePrc {
  static Integer staticNum;

  public static void main(String[] args) {
    Integer number = 3;
    addOne(number);
    System.out.println(number);

    staticNum = 3;
    addOne();
    System.out.println(staticNum);
  }

  static void addOne(Integer number){
    number++;
  }

  static void addOne(){
    staticNum++;
  }
}
