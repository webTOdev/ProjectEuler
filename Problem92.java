/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nut
 */
public class Problem92 {

    private static List<Long> listOfNumbersThatReached89 = new ArrayList<Long>();
     private static List<Long> listOfNumbersThatReached1 = new ArrayList<Long>();
       private static List<Long> listOfThisChain = new ArrayList<Long>();
       
       private static Map<Long,Long> factorial = new HashMap<Long,Long>(); 

    public static void main(String args[]) {
        
        long start = System.currentTimeMillis();
        int count = 0;
        for (long i = 1; i < 1000000; i++) {
            long number = i;
            listOfThisChain.clear();
            while (true) {
               

                 if(listOfNumbersThatReached89.contains(number) || listOfNumbersThatReached1.contains(number)){
                     if(listOfNumbersThatReached89.contains(number)){
                      count+= listOfThisChain.size();
                      listOfNumbersThatReached89.addAll(listOfThisChain); 
                      }
                    break;
                }
                  listOfThisChain.add(number);
                long sum = sumOfDigitsSquare(number);

                if (sum == 1 || sum == 89) {
                 //   System.out.print(sum);
                    if (sum == 89) {
                        listOfNumbersThatReached89.addAll(listOfThisChain); 
                     //   System.out.println(listOfThisChain);
                        count+= listOfThisChain.size();
                      //  System.out.println(count);
                    }
                    
                    else {
                        listOfNumbersThatReached1.addAll(listOfThisChain);
                    }
                    break;
                }


                number = sum;
            }
            
         //    System.out.println(listOfThisChain);
         //     System.out.println(listOfNumbersThatReached89);
        //     System.out.println(count);
            
        }

        //    System.out.println(44+" "+sumOfDigitsSquare(44));

        System.out.println("89 reached " + count + " times");
            long end = System.currentTimeMillis();
              System.out.println("Exuction time"+(end-start)+" ms");
        
        
     
    }
    
    
    private static void factorial(long n){
        
       
        long fact = 1;
        for(long i=1;i<=n;i++){
            fact*=i;
        }
        
        factorial.put(n, fact);
        
     
    
    }
    
    

    private static long sumOfDigitsSquare(long number) {

        long squareSum = 0;
        while (number > 0) {

            int digit = (int) (number % 10);
            number = number / 10;

            squareSum += digit * digit;
        }

        return squareSum;

    }
    
    private static int[] numOfDigits(long number){
    
        int array[] = new int[10];
        while (number > 0) {

            int digit = (int) (number % 10);
            number = number / 10;

           array[digit]++;
        }
        
        return array;
        
        
    }
}
