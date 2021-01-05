import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {
  
  class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
  }

  // Add any helper functions you may need here
  

  Node reverse(Node head) {
    // Write your code here
    Node current = head;
    Node next = null;
    ArrayList<Integer> returnValue = new ArrayList<>();
    
    int currentInt = 0;
    int nextInt = 0;
        
    while(current != null){
      currentInt = current.data;    
      //System.out.println("current : " + currentInt);

      next = current.next;
      if(next != null){
        nextInt = next.data;  
        //System.out.println("next : " + nextInt);
      }
      
      boolean isCurrentEven =  (currentInt  % 2 == 0) ? true : false;
      boolean isNextEven =  (nextInt  % 2 == 0) ? true : false;
            
      //System.out.println("isCurrentEven : " + isCurrentEven);
      //System.out.println("isNextEven : " + isNextEven);
      
      if(isCurrentEven && isNextEven){
        if(next != null){
          returnValue.add(nextInt);
          returnValue.add(currentInt);
        }        
      }else{
        if(!returnValue.contains(currentInt)){
          returnValue.add(currentInt);  
        }
      }

      current = next;
    }
    
    int[] tempArr = new int[returnValue.size()];
    Iterator it = returnValue.iterator();
    int counter = 0;
    
    while(it.hasNext()){
      tempArr[counter] = (int) it.next();
      counter++;
    }
    
    Node returnNode = createLinkedList(tempArr);
    //System.out.println("returnValue : " + returnValue.toString());
    return returnNode;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void printLinkedList(Node head) {
    System.out.print("[");
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
      if (head != null)
        System.out.print(" ");
    }
    System.out.print("]");
  }
  void check(Node expectedHead, Node outputHead) {
    boolean result = true;
    Node tempExpectedHead = expectedHead;
    Node tempOutputHead = outputHead;
    while (expectedHead != null && outputHead != null) {
      result &= (expectedHead.data == outputHead.data);
      expectedHead = expectedHead.next;
      outputHead = outputHead.next;
    }
    if (!(expectedHead == null && outputHead == null)) result = false;

    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printLinkedList(tempExpectedHead); 
      System.out.print(" Your output: ");
      printLinkedList(tempOutputHead);
      System.out.println();
    }
    test_case_number++;
  }
  Node createLinkedList(int[] arr) {
    Node head = null;
    Node tempHead = head;
    for (int v : arr) {
      if (head == null) {
        head = new Node(v);
        tempHead = head;
      } else {
        head.next = new Node(v);
        head = head.next;
      }
    }
    return tempHead;
  }
  
  public void run() {
  
    int[] arr_1 = {1, 2, 8, 9, 12, 16};
    int[] expected1 = {1, 8, 2, 9, 16, 12};
    Node head_1 = createLinkedList(arr_1);
    Node expected_1 = createLinkedList(expected1);
    Node output_1 = reverse(head_1);
    check(expected_1, output_1);

    int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
    int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
    Node head_2 = createLinkedList(arr_2);
    Node expected_2 = createLinkedList(expected2);
    Node output_2 = reverse(head_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
