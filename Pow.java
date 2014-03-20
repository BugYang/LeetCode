public class Solution {
    public double pow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1/pow(x, n+1)/x;
            }
            return 1/pow(x, -n);
        } else if (n == 0) {
            return 1;
        } else{
            if (n %2 == 0) {
                double p = pow(x, n/2);
                return p*p;
            } else {
                return x*pow(x, n-1);
            }
        } 
    }
}
