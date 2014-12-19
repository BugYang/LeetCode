public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++)
            factorial[i] = i * factorial[i-1];

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++)
            list.add(i);
          
        StringBuilder sb = new StringBuilder();  
        for (int i = n; i > 0; i--) {
            int idx = (k-1)/factorial[i-1];
            sb.append(list.remove(idx));
            k -= factorial[i-1] * idx;
        }
        
        return sb.toString();
    }
}