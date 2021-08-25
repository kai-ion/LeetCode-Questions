public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String ans = "";
        String[] x = num1.split("\\+|i");
        String[] y = num2.split("\\+|i");
        int real1 = Integer.parseInt(x[0]);
        int img1 = Integer.parseInt(x[1]);
        int real2 = Integer.parseInt(y[0]);
        int img2 = Integer.parseInt(y[1]);
        ans = ((real1 * real2 - img1 * img2) + "+" + (real1 * img2 + img1 * real2) + "i");
        return ans;
    }

    public static void main(String[] args) {

    }
}