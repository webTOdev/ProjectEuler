/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

import java.math.BigDecimal;

/**
 *
 * @author nut
 */
public class Problem16 {

    private static String twoPowerThousand = new BigDecimal(Math.pow(2, 1000)).toString();
    private static long sum = 0;

    public static void main(String args[]) {
        tokenIntoThreeDigitString();
        System.out.println("Sum " + sum);
        System.out.println(twoPowerThousand);
    }

    private static void tokenIntoThreeDigitString() {
        int length = twoPowerThousand.length();
        for (int i = 0; i < length; i += 3) {
            String digits = twoPowerThousand.substring(i, (i + 3) > length ? length : i + 3);
            System.out.println(digits);
            int threeDigitNum = Integer.parseInt(digits);
            sumOfThreeDigit(threeDigitNum);
        }
    }

    private static void sumOfThreeDigit(int n) {

        do {
            sum += n % 10;

            n = n / 10;
        } while (!(n == 0));

    }
}
