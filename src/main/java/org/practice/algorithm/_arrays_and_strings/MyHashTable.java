package org.practice.algorithm._arrays_and_strings;

import java.util.LinkedList;

public class MyHashTable {
  class Node {
    private String key;
    private Object value;

    public Node(String key, Object value){
      this.key = key;
      this.value = value;
    }

    String key() {
      return key;
    }

    Object value() {
      return value;
    }

    void value(Object value){
      this.value = value;
    }
  }

  LinkedList<Node>[] data;

  public MyHashTable(int size) {
    this.data = new LinkedList[size]; // 배열방
  }

  int getHashCode(String key){
    int hasCode = 0;
    for(char c:key.toCharArray()){
      hasCode += c;
    }
    return hasCode;
  }

  int covertToIndex(int hashCode){
    return hashCode % data.length;
  }

  Node searchKey(LinkedList<Node> list, String key) {
    if(list == null) return  null;
    for(Node node : list){
      if(node.key().equals(key)){
        return node;
      }
    }
    return null;
  }

  void put(String key, Object value){
    int hashCode = getHashCode(key);
    int index = covertToIndex(hashCode);
    System.out.println(key+"- hashCode : "+hashCode+ ", Index : "+index);
    LinkedList<Node> list = data[index];

    if(list == null){
      list = new LinkedList<Node>();
      data[index] = list;
    }

    Node node = searchKey(list, key);

    if(node == null){
      list.addLast(new Node(key, value));
    } else {
      node.value(value);
    }
  }

  Object get(String key){
    int hashCode = getHashCode(key);
    int index = covertToIndex(hashCode);
    LinkedList<Node> list = data[index];
    Node node = searchKey(list, key);
    return node == null? "Not Found":node.value();
  }
}

class Main {
  public static void main(String[] args) {
    MyHashTable hash = new MyHashTable(3);
    hash.put("yong", "Friend");
    hash.put("jung", "Colleague");
    hash.put("kim", 9128312);
    hash.put("yong", "Lover");
    System.out.println(hash.get("yong"));
    System.out.println(hash.get("choi"));
  }
}
