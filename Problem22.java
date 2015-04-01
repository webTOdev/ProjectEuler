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
import javax.swing.text.Position;

/**
 *
 * @author nut
 */
public class Problem22 {

    private static List<String> names = new ArrayList<String>();
    private static long sum = 0;

    public static void main(String args[]) {
        readNames();
        System.out.println(calculateSum());
        System.out.println(names.indexOf("\""));
    }

    private static void readNames() {
        File file;
        FileReader fd;
        BufferedReader bd;
        StringTokenizer st;

        try {
            file = new File("d://problem22.txt");
            fd = new FileReader(file);
            bd = new BufferedReader(fd);
            String str1;
            int count = 0;
            while ((str1 = bd.readLine()) != null) {
                st = new StringTokenizer(str1, "\"\",");
                while (st.hasMoreTokens()) {
                    names.add(st.nextToken());
                    count++;
                }

            }
            } catch (IOException ex) {
            Logger.getLogger(Problem22.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static long calculateSum(){
            //   System.out.println(count);
            Collections.sort(names);
            int index = 0, numericPosition = 0;
            for (String name : names) {
                index = names.indexOf(name);
                numericPosition = numericPosition(name);
                System.out.println(name + " at " + index + " Numeric " + numericPosition);
                sum += (index+1) * numericPosition;
            }
            return sum;
    }
        

    private static int numericPosition(String str) {

        String input = str.toUpperCase(); //note the to lower case in order to treat a and A the same way
        int position = 0;
        for (int i = 0; i < input.length(); ++i) {
            position += input.charAt(i) - 'A' + 1;
        }

        return position;

    }
}
