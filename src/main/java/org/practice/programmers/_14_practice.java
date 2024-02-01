package org.practice.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class _14_practice {
    public static void main(String[] args) {
        String[] strs = new String[2];
    }


    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<Character, String> map = new HashMap<>();
        int index = 0;
        for(String s:strings){
            map.put(s.charAt(n), s);
    }
    List<Map.Entry<Character, String>> entries = new ArrayList<>(map.entrySet());
    entries.sort(new Comparator<Map.Entry<Character, String>>() {
        @Override
        public int compare(Map.Entry<Character, String> o1, Map.Entry<Character, String> o2) {
            return o1.getKey() - o2.getKey();
        }
    });
    return answer;
}
}
