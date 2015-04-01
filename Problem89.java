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
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nut
 */
public class Problem89 {

    private static String strArray[] = new String[1000];
    private static String romansList[] = new String[1000];

    public static void main(String args[]) {


        readFile();
        long previous = 0;
        long now = 0;

        for (int i = 0; i < 1000; i++) {
            long num = getNumberFromRoman(strArray[i]);
            String optimizedRoamLetter = romanNumeral(num);

            romansList[i] = optimizedRoamLetter;
            
            previous+=strArray[i].length();
            now+=romansList[i].length();
            System.out.println(num + " " + strArray[i] + " " + romansList[i]);
        }
        
          System.out.println("Letters reduced to "+previous+"-"+now+"="+(previous-now));
        
        


    }

    private static String romanNumeral(long num) {

        String str = "";
        while (num >= 1000) {
            str += "M";
            num -= 1000;
        }
        while (num >= 900) {
            str += "CM";
            num -= 900;
        }
        while (num >= 500) {
            str += "D";
            num -= 500;
        }
        while (num >= 400) {
            str += "CD";
            num -= 400;
        }
        while (num >= 100) {
            str += "C";
            num -= 100;
        }
        while (num >= 90) {
            str += "XC";
            num -= 90;
        }
        while (num >= 50) {
            str += "L";
            num -= 50;
        }
        while (num >= 40) {
            str += "XL";
            num -= 40;
        }
        while (num >= 10) {
            str += "X";
            num -= 10;
        }
        while (num >= 9) {
            str += "IX";
            num -= 9;
        }
        while (num >= 5) {
            str += "V";
            num -= 5;
        }
        while (num >= 4) {
            str += "IV";
            num -= 4;
        }
        while (num >= 1) {
            str += "I";
            num -= 1;
        }

        return str;

    }

    private static long getNumberFromRoman(String roman) {

        if (roman.length() == 0) {
            return -1;
        }
        int i = 0;
        int number = 0;
        while (i < roman.length()) {

            int letter = letterToNumber(roman.charAt(i));
            if (letter < 0) {
                return -1;
            }
            i++;

            if (i == roman.length()) {
                // There is no letter in the string following the one we have just processed.
                // So just add the number corresponding to the single letter to arabic.
                number += letter;
            } else {
                // Look at the next letter in the string.  If it has a larger Roman numeral
                // equivalent than number, then the two letters are counted together as
                // a Roman numeral with value (nextNumber - number).
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > letter) {
                    // Combine the two letters to get one value, and move on to next position in string.
                    number += (nextNumber - letter);
                    i++;
                } else {
                    // Don't combine the letters.  Just add the value of the one letter onto the number.
                    number += letter;
                }
            }

        }

        return number;

    }

    private static int letterToNumber(char letter) {
        // Find the integer value of letter considered as a Roman numeral.  Return
        // -1 if letter is not a legal Roman numeral.  The letter must be upper case.
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    private static void readFile() {

        File file;
        FileReader fd;
        BufferedReader bd;
        StringTokenizer st;



        try {
            file = new File("d://problem89.txt");
            fd = new FileReader(file);
            bd = new BufferedReader(fd);
            String str1;
            int k = 0;
            while ((str1 = bd.readLine()) != null) {

                strArray[k++] = str1;
            }

        } catch (IOException ex) {
            Logger.getLogger(Problem89.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
