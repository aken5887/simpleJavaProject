package org.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyBufferedReader {
    private static BufferedReader bufferedReader;
    public static BufferedReader getInstance(){
        if(bufferedReader == null){
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        return bufferedReader;
    }

    public static StringTokenizer getTokenizer(String delim){
        if(bufferedReader == null) getInstance();
        try{
            return new StringTokenizer(bufferedReader.readLine(), delim);
        } catch(IOException io) {
            return null;
        }
    }
}
