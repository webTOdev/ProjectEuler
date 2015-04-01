/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nut
 */
public class Problem17 {
    private static Map<Integer,String> dictionary = new HashMap<Integer, String>();
    private static void createDictionary(){
                    dictionary.put(0, "zero");
                    dictionary.put(1, "one");
                    dictionary.put(2, "two");
                    dictionary.put(3, "three");
                    dictionary.put(4, "four");
                    dictionary.put(5, "five");
                    dictionary.put(6, "six");
                    dictionary.put(7, "seven");
                    dictionary.put(8, "eight");
                    dictionary.put(9, "nine");
                    dictionary.put(10, "ten");
                    dictionary.put(11, "eleven");
                    dictionary.put(12, "twelve");
                    dictionary.put(13, "thirteen");
                    dictionary.put(14, "fourteen");
                    dictionary.put(15, "fifteen");
                    dictionary.put(16, "sixteen");
                    dictionary.put(17, "seventeen");
                    dictionary.put(18, "eighteen");
                    dictionary.put(19, "nineteen");
                    dictionary.put(20, "twenty");
                    dictionary.put(30, "thirty");
                    dictionary.put(40, "forty");
                    dictionary.put(50, "fifty");
                    dictionary.put(60, "sixty");
                    dictionary.put(70, "seventy");
                    dictionary.put(80, "eighty");
                    dictionary.put(90, "ninety");
                    dictionary.put(100, "hundred");
                    dictionary.put(1000, "thousand");
                   
    } ;
    public static void  main(String args[]){
        createDictionary();
        long sum =0;
        for(int i=1;i<=1222;i++){
            String theNum = handleNumbers(i).replace(" ", "");
            System.out.println(theNum);
            sum+=theNum.length();
            
        
        }
        System.out.println(sum);
        
    }
    
    private static String handleNumbers(int n){
        String str = "";
        switch(new Integer(n).toString().length()){
            case 1:
              str+=  handleOneDigitNumber(n);
                break;
            case 2:
              str+=  handleTwoDigitNumber(n);
                break;
            case 3:
                str+=handleThreeDigitNumber(n);
                break;
            case 4:
                str+=handleFourDigitNumber(n);
                break;
        }
        return str;
    }
    
    private static String handleOneDigitNumber(int n){
       
        return dictionary.get(n);
    }
    private static String handleTwoDigitNumber(int n){
        String str = new Integer(n).toString();
        if(str.startsWith("1")){
            return dictionary.get(n);
        }
        if(str.startsWith("0")){
        return dictionary.get(Integer.parseInt(str.substring(1)));
        }
        if((n%10) == 0){
            return dictionary.get(n);
        }
        String word = appendZero(n/10, 1);
      
         word +=" "+dictionary.get(n%10);
         return word;
        
       
       
    }
    private static String handleThreeDigitNumber(int n){
         String str = new Integer(n).toString();
         String word ="";
         if(str.endsWith("00"))
         {
             word=handleOneDigitNumber(n/100)+" "+dictionary.get(100);
         }
         else
         {
             word=handleOneDigitNumber(n/100)+" "+dictionary.get(100)+" and "+handleTwoDigitNumber(n%100);
         }
         return word;
         
    }
    
    private static String handleFourDigitNumber(int n){
         String str = new Integer(n).toString();
         String word ="";
         if(str.endsWith("000"))
         {
             word=handleOneDigitNumber(n/1000)+" "+dictionary.get(1000);
         }
         else
         {
             word=handleOneDigitNumber(n/1000)+" "+dictionary.get(1000)+handleThreeDigitNumber(n%1000);
         }
         return word;
         
    }
    private static  String appendZero(int n,int howMany){
        if(n==0)
            return "";
        StringBuffer sb = new StringBuffer();
        sb.append(n);
        for(int i=0;i<howMany;i++){
            sb.append("0");
        }
        int num = Integer.parseInt(sb.toString());
        return dictionary.get(num);
    }
    
}
