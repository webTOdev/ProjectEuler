/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nut
 */
public class Problem42 {
    
      private static List<String> words = new ArrayList<String>();
      private static List<Double> triangleNumbers = new ArrayList<Double>();
      
      public static void main(String args[]){
          
          int count=0;
          readNames();
          createTriangleNumbers();
          
          Collections.sort(words);
          for(String s : words){
          if(isTriangle(s)){
          
              System.out.println(" "+s );
              count++;
          }
          }
          
        
           System.out.println("Total "+words.size()+" Triangle words "+count);
         
         
      
      }
      
      private static boolean isTriangle(String word){
      
          char[] arr = word.toLowerCase().toCharArray();
          double sum = 0;
          
          for(char c:arr){
           
              sum+=c-96;
          
          }
          if(triangleNumbers.contains(sum)){
          System.out.print(sum);
          return true;
          }
          
          return false;
      }
      
      private static void createTriangleNumbers(){
      
          Double v;
          for(int i=1;i<=100;i++){
          v=0.5*i*(i+1);
          triangleNumbers.add(v);
          
          }
      
      }
      
        private static void readNames() {
        File file;
        FileReader fd;
        BufferedReader bd;
        StringTokenizer st;

        try {
            file = new File("d://problem42.txt");
            fd = new FileReader(file);
            bd = new BufferedReader(fd);
            String str1;
            int count = 0;
            while ((str1 = bd.readLine()) != null) {
                st = new StringTokenizer(str1, "\"\",");
                while (st.hasMoreTokens()) {
                    words.add(st.nextToken());
                    count++;
                }

            }
            } catch (IOException ex) {
            Logger.getLogger(Problem22.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
