  int[] countSubarrays(int[] arr) {
    // Write your code here
    int[] answer = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int count = 1;
      int localMax = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < localMax) {
          count++;
        } else {
          break;
        }      
      }
      for (int k = i - 1; k >= 0; k--) {
        if (arr[k] < localMax) {
          count++;
        } else {
          break;
        }
      }
      answer[i] = count;
    }
    return answer; 
  }
