import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class PairSums {

  // Add any helper functions you may need here


  int numberOfWays(int[] arr, int k) {
    // Write your code here
    int validPairs = 0; // valid pair counter
    
    //iterate over arr to get value to add to equal k
    for(int depth1 = 0 ; depth1 < arr.length; depth1++){   
      // if arr[depth1] < k (just checking to make solution faster)
      if(arr[depth1] < k){  
        // iterate over arr again but this time looking for value to add with arr[depth1]
        // e.g look for arr[depth1] + arr[depth2] to equal k
        for(int depth2 = 0; depth2 < arr.length; depth2++){
          // very important from the arr, we only moving forward down the array 
          // indexToUse is the current slot in the arr we checking, from where depth1 is plus 1
          int indexToUse = depth1 + 1;
          // if depth2 >= indexToUse, this is to ensure we only moving forward in the arr
          if(depth2 >= indexToUse){  
            // add arr[depth1] + arr[depth2]
            int total = arr[depth1] + arr[depth2];
            // if the total == k
            // !!! we got a pair
            if(total == k){
              validPairs++; // add to the validPairs counter
            } 
          } 
        }
      } 
    }
    return validPairs; // return the validPairs
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  
  public void run() {
    int k_1 = 6;
    int[] arr_1 = {1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new PairSums().run();
  }
}
