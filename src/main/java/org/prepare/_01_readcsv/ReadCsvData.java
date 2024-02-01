package org.prepare._01_readcsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvData {
    private List<String> nonDigits = new ArrayList<>();
    public static void main(String[] args) {
        ReadCsvData csvData = new ReadCsvData();
        final String filePath = "src/main/java/org/prepare/_01_readcsv";
        List<String> lines = csvData.readData(filePath+"/sample.csv");
        List<CsvLine> csvLines = csvData.getCsvLines(lines);
        csvData.makeSummaryTxt(filePath+"/summary.txt", csvLines);
    }

    private void makeSummaryTxt(String filePath, List<CsvLine> csvLines){
        File file = new File(filePath);
        try(FileWriter fileWriter = new FileWriter(file)){
            for(CsvLine line:csvLines){
                fileWriter.write(line.toString()+"\n");
            }
            fileWriter.write("total Line :"+ (nonDigits.size() + csvLines.size())+"\n");
            fileWriter.write("character :");
            for(String s:nonDigits){
                fileWriter.write(s+",");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<CsvLine> getCsvLines(List<String> lines){
        List<CsvLine> csvLines = new ArrayList<>();
        for(String line:lines){
            String[] strs = line.split(",");
            double[] numbers = new double[strs.length];
            boolean isLine = true;
            for(int i=0; i<strs.length; i++) {
                if(!isNumber(strs[i])) {
                    isLine = false;
                    nonDigits.add(strs[i]);
                    break;
                } else {
                    numbers[i] = Double.parseDouble(strs[i]);
                }
            }
            if(isLine){
                csvLines.add(new CsvLine(numbers));
            }
        }
        return csvLines;
    }

    public boolean isNumber(String s){
        try{
            Double.parseDouble(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private List<String> readData(String filepath){
        List<String> stringList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(filepath);
            BufferedReader bf = new BufferedReader(fileReader);
        ){
            String line = "";
            while((line = bf.readLine()) != null){
                stringList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringList;
    }
}
