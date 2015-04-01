/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuler.net;

/**
 *
 * @author nut
 */
public class Problem4 {

    public static void main(String args[]) {

        int last = 0;

        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int now = checkIfPalindrome(i, j);
                if (now != -1 && now > last) {
                    last = now;

                }
            }

            System.out.println(last);

        }
    }

    private static int checkIfPalindrome(int x, int y) {

        Long multiple = new Long(x * y);
        String s = multiple.toString();
        StringBuffer sb = new StringBuffer(s);
        if (sb.reverse().toString().equals(s)) {
            System.out.println("Palindrome " + s);
            return Integer.parseInt(s);
        }
        return -1;
    }
}
