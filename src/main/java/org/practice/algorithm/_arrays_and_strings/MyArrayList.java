package org.practice.algorithm._arrays_and_strings;

import java.util.stream.IntStream;

public class MyArrayList<T> {
  private T[] data;
  private int size;
  private int index; //마지막 데이터의 위치

  public MyArrayList(){
    this.size = 1; // 초기 값은 1로 생성
    this.data = (T[]) new Object[this.size]; // 초기 배열 생성
    this.index = 0;
  }

  public void add(Object obj){
    System.out.println("[add] index : "+this.index+", size : "+this.data.length);
   if(this.index == this.size-1){ // 배열 방이 다 찬경우
     doubling();
   }
    data[this.index] = (T) obj; // 가져온 데이터를 배열 방 제일 끝에 추가
    this.index++;
  }

  private void doubling() {
    this.size = this.size * 2;
    Object[] newData = new Object[this.size];
    for(int i=0; i<data.length; i++){ // 현재 배열 방을 돌면서 데이터를 복사
      newData[i] = data[i];   // 값이 아니라 참조 값이 복사된다.(Object 이기때문)
    }
    this.data = (T[]) newData;
    System.out.println("[doubling] after doubling - index :"+this.index+", size :"+this.size
    +", data size :"+ this.data.length);
  }

  public Object get(int i) throws Exception {
    if(i<0) {
      throw new Exception("Index can not be negative value");
    }else if(i>this.index-1){
      throw new ArrayIndexOutOfBoundsException();
    }
    return this.data[i];
  }

  public void remove(int i) throws Exception{
    if(i<0) {
      throw new Exception("Index can not be negative value");
    }else if(i>this.index-1){
      throw new ArrayIndexOutOfBoundsException();
    }
    System.out.println("[remove] removed data : "+this.data[i]+" with index "+this.index);
    for(int j=i; j<this.data.length-1; j++){
      this.data[j] = this.data[j+1];
    }
    this.index--;
    System.out.println("[remove] after remove with index : "+this.index);
  }
}

class Main2 {
  public static void main(String[] args) throws Exception {
    MyArrayList<String> stringList = new MyArrayList<>();
    IntStream.range(0,10)
        .forEach(i -> stringList.add("나는 문자열-"+String.valueOf(i)));
    System.out.println(stringList.get(5));
    stringList.remove(5);
    System.out.println(stringList.get(5));

    MyArrayList<Integer> numberList = new MyArrayList<>();
    IntStream.range(0,10)
        .forEach(i -> numberList.add(i));
    System.out.println(numberList.get(1));
    stringList.remove(1);
    System.out.println(numberList.get(1));
  }
}