/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nut
 */
public class Problem45 {

    private static List<Long> triangleNumbers = new ArrayList<Long>();
    private static List<Long> pentagonNumbers = new ArrayList<Long>();
    private static List<Long> hexagonNumbers = new ArrayList<Long>();

    public static void main(String args[]) {

        createPentagonNumbers();
        createHexagonNumbers();
        long v;
        for (long i = 286; i <= 100000; i++) {
            v = (long) (0.5 * i * (i + 1));
         //   System.out.println(v);
            if(pentagonNumbers.contains(v) && hexagonNumbers.contains(v) ){
            System.out.println(v);
            }
        }
    }

    private static void createPentagonNumbers() {

        long v;
        for (long i = 166; i <= 100000; i++) {
            v = (long) (0.5 * i * (3 * i - 1));
            pentagonNumbers.add(v);
          //   System.out.println(v);
          

        }
    }

    private static void createHexagonNumbers() {

        long v;
        for (long i = 144; i <= 50000; i++) {
            v =  i * (2 * i - 1);
            hexagonNumbers.add(v);
              

        }
    }
}
