package org.prepare._01_readcsv;

public class CsvLine {
    private double min;
    private double max;
    private double sum;
    private double average;

    public CsvLine(double[] numbers){
        this.min = findMin(numbers);
        this.max = findMax(numbers);
        this.sum = findSum(numbers);
        this.average = findAverage(numbers);
    }

    private double findAverage(double[] numbers) {
        double sum = findSum(numbers);
        return sum / numbers.length;
    }

    private double findSum(double[] numbers) {
        double sum = 0;
        for(double number:numbers){
            sum += number;
        }
        return sum;
    }

    private double findMin(double[] numbers) {
        double min = Double.MAX_VALUE;
        for(double num:numbers){
            min = Math.min(num, min);
        }
        return min;
    }

    private double findMax(double[] numbers) {
        double max = Double.MIN_VALUE;
        for(double num:numbers){
            max = Math.max(max, num);
        }
        return max;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("min : ").append(this.min);
        sb.append(", max : ").append(this.max);
        sb.append(", sum : ").append(this.sum);
        sb.append(", average : ").append(this.average);
        return sb.toString();
    }

}
