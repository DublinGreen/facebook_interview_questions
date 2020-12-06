import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    System.out.println("input : " + input);
    System.out.println("rotationFactor : " + rotationFactor);
    
    String alphabetsLower = "abcdefghijklmnopqrstuvwxyz"; // String of lower alphabets
    String alphabetsUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // String of upper alphabets
    String numbers = "0123456789"; // String of numbers    
    char[] finalChar = new char[input.length()];
    
    // Just because we are lazy to type, convert String to char[]
    char[] alphabetsLowerChar = new char[alphabetsLower.length()]; 
    for (int i = 0; i < alphabetsLower.length(); i++) { 
      alphabetsLowerChar[i] = alphabetsLower.charAt(i); 
    } 
    
    // Just because we are lazy to type, convert String to char[]
    char[] alphabetsUpperChar = new char[alphabetsUpper.length()]; 
    for (int i = 0; i < alphabetsUpper.length(); i++) { 
      alphabetsUpperChar[i] = alphabetsUpper.charAt(i); 
    }
    
    // Just because we are lazy to type, convert String to char[]
    char[] numbersChar = new char[numbers.length()]; 
    for (int i = 0; i < numbers.length(); i++) { 
      numbersChar[i] = numbers.charAt(i); 
    }
        
    char[] inputChar = new char[input.length()]; // char[] of input
    
    // iterate input and do logic   
    for (int i = 0; i < input.length(); i++) { 
      System.out.println(inputChar[i]); 
      inputChar[i] = input.charAt(i); 
      
      // using Arrays.binarySearch from import java.util.Arrays
      // It returns an index or negative number
      int retValLower = Arrays.binarySearch(alphabetsLowerChar, input.charAt(i));
      int retValUpper = Arrays.binarySearch(alphabetsUpperChar, input.charAt(i));
      int retValNumber = Arrays.binarySearch(numbersChar, input.charAt(i));

      //Check if retValLower is a valid index
      if(retValLower >= 0){        
        int index = 0;
        int indexAlt = 0; // Use this when we need to recycle
        index = retValLower + rotationFactor;

        /*
        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);
        */        
        if(index > alphabetsLower.length()){
          indexAlt = index - (alphabetsLower.length()); // Calculate how to recycle
          
          if(indexAlt > alphabetsLower.length()){
            //dex = retValLower + rotationFactor;
            int indexAltMod = alphabetsLower.length() - retValLower;
            indexAltMod = rotationFactor % retValLower;            
            finalChar[i] = alphabetsLower.charAt(indexAltMod);
          }else{
            finalChar[i] = alphabetsLower.charAt(indexAlt);  
          }
        }else{
          finalChar[i] = alphabetsLower.charAt(index);
        }
        
      }
      //Check if retValUpper is a valid index
      else if(retValUpper >= 0){
        int index = 0;
        int indexAlt = 0;
        index = retValUpper + rotationFactor;
                
        if(index > alphabetsUpper.length()){
          indexAlt = index - (alphabetsUpper.length());
          
          if(indexAlt > alphabetsUpper.length()){            
            int indexAltMod = alphabetsUpper.length() - retValUpper;
            indexAltMod = rotationFactor % indexAltMod;
            finalChar[i] = alphabetsUpper.charAt(indexAltMod);
          }else{
            finalChar[i] = alphabetsUpper.charAt(indexAlt);  
          }
        }else{
          finalChar[i] = alphabetsUpper.charAt(index);
        }
      }
      else if(retValNumber >= 0){
        int index = 0;
        int indexAlt = 0;
        index = retValNumber + rotationFactor;
        
        if(index > numbers.length()){
          indexAlt = index - (numbers.length());
          
          if(indexAlt > alphabetsUpper.length()){            
            int indexAltMod = numbers.length() - retValNumber;
            indexAltMod = rotationFactor % indexAltMod;
            finalChar[i] = numbers.charAt(indexAltMod);
          }else{
            finalChar[i] = numbers.charAt(indexAlt);  
          }
        }else{
          finalChar[i] = numbers.charAt(index);
        }
      }
      else if(retValLower == -1 && retValUpper == -1 && retValNumber == -1){
        finalChar[i] = inputChar[i];
      }else{
        finalChar[i] = inputChar[i];
      }
      
      
      retValLower = 0;
      retValUpper = 0;
      retValNumber = 0;
    }
    
    
    //String finalString = new String(finalChar);
    //System.out.println("finalString : " + finalString);
    return finalString;
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(String expected, String output) {
    boolean result = (expected.equals(output));
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printString(expected); 
      System.out.print(" Your output: ");
      printString(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
  
  public void run() {
    String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
