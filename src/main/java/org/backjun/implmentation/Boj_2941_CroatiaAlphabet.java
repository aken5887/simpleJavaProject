package org.backjun.implmentation;

import java.util.Scanner;

/**
 * 2941번 크로아티아 알파벳
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_2941_CroatiaAlphabet {
    private static String[] croatiaes = {
      "c=",
      "c-",
      "dz=",
      "d-",
      "lj",
      "nj",
      "s=",
      "z=",
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        for(String s:croatiaes){
            word = word.replaceAll(s, "|");
        }
        System.out.println(word.length());
    }
}
