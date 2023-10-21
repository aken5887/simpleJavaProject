package org.practice.algorithm._arrays_and_strings;

public class MyStringBuilder {
  private char[] value;
  private int size;
  private int index;

  public MyStringBuilder(){
    this.size = 1; // 초기 사이즈
    this.value = new char[this.size];
    this.index = 0;
  }

  public void append(String str){
    if(str == null) str = "null";
    int len = str.length();
    System.out.println("[append] before append - len :"+len+", size:"+size+", index:"+index);
    ensureCapacity(len);
    for(int i=0; i<len; i++){
      this.value[index] = str.charAt(i);
      index++;
    }
    System.out.println("[append] after append - size:"+size+", index:"+index);
  }

  private void ensureCapacity(int len) {
    if(len+index > size){
      this.size = (len+index) * 2;
      char[] newData = new char[size];
      for(int i=0; i<value.length; i++){
        newData[i] = value[i];
      }
      this.value = newData;
      System.out.println("[ensureCapacity] size:"+size+", index:"+index);
    }
  }

  public String toString(){
    return new String(value, 0, index); // 0번방 부터 index방까지의 char을 출력
  }
}

class Main3 {
  public static void main(String[] args) {
    MyStringBuilder sb = new MyStringBuilder();
    sb.append("yong");
    sb.append(" is smart");
    System.out.println(sb.toString());
  }
}
