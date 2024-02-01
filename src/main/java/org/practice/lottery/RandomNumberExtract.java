package org.practice.lottery;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomNumberExtract {
    private static Set<Integer> pick = new HashSet<>();
    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0; i<5; i++){
            pick = new HashSet<>();
            while(pick.size() < 6){
                int number = random.nextInt(45) + 1;
                pick.add(number);
            }
            AtomicInteger h = new AtomicInteger(1);
            pick.stream()
                    .sorted()
                    .forEach(number -> {
                        System.out.print(number);
                        if(h.get() <= 5) System.out.print(",");
                        h.getAndIncrement();
                    });
            System.out.println();
        }
    }
}
