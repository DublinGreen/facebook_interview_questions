int numberOfWays(int[] arr, int k) {
    // Write your code here
    int validPairs = 0;

    for(int depth1 = 0 ; depth1 < arr.length; depth1++){   
      if(arr[depth1] < k){   
        for(int depth2 = 0; depth2 < arr.length; depth2++){
          if(depth1 < arr.length){
            int indexToUse = depth1 + 1;
              if(depth2 >= indexToUse){  
                int total = arr[depth1] + arr[depth2];
                if(total == k){
                  validPairs++;
                } 
              } 
          }
        }
      } 
    }
    return validPairs;
  }
