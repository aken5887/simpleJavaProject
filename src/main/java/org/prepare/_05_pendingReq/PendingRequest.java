package org.prepare._05_pendingReq;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class PendingRequest {
    private final String REQUEST_URL = "http://codingtest.brique.kr:8080/random";

    public static void main(String[] args) {
        PendingRequest pq = new PendingRequest();
        List<Quote> quotes = pq.requestUrlCount(100);
        Map<Quote, Integer> sortedQuotes = pq.sortByCount(quotes, org.prepare._05_pendingReq.SortOrder.DESC);
        Iterator<Quote> itr = sortedQuotes.keySet().iterator();

        int total = 0;
        int cnt = 0;
        while(itr.hasNext()) {
            Quote q = itr.next();
            cnt = sortedQuotes.get(q);
            total += cnt;
            System.out.println("count:" + cnt + ", " + q.toString());
        }
        System.out.println("total : "+total);
    }

    public Map<Quote, Integer> sortByCount(List<Quote> quotes, SortOrder sortOrder){
        Map<Quote, Integer> sortedQuotes = new LinkedHashMap<>();
        Map<Long, Integer> countMap = new HashMap<>();
        Map<Long, Quote> quoteMap = new HashMap<>();
        for(Quote quote:quotes){
            countMap.put(quote.getId(), countMap.getOrDefault(quote.getId(), 0)+1);
            if(!quoteMap.containsKey(quote.getId())) quoteMap.put(quote.getId(), quote);
        }

        List<Map.Entry<Long, Integer>> entries = new ArrayList<>(countMap.entrySet());
        entries.sort(new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                if(SortOrder.DESC.equals(sortOrder)){
                    return Integer.compare(o2.getValue(), o1.getValue());
                } else {
                    return Integer.compare(o1.getValue(), o2.getValue());
                }
            }
        });

        for(Map.Entry<Long, Integer> entry:entries){
            sortedQuotes.put(quoteMap.get(entry.getKey()), entry.getValue());
        }

        return sortedQuotes;
    }

    public List<Quote> requestUrlCount(int count) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Quote> quotes = new ArrayList<>();
        for(int i=0; i<count; i++) {
            try{
                URL url = new URL(REQUEST_URL);
                URLConnection urlConnection = url.openConnection();
                Quote quote = objectMapper.readValue(urlConnection.getInputStream(), Quote.class);
                quotes.add(quote);
            }catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return quotes;
    }
}
