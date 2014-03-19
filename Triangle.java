public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[] result = new int[n];
        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> row = triangle.get(i);
            result[i] = result[i-1] + row.get(i);
            for (int j = i-1; j >= 1; j--) {
                result[j] = row.get(j) + Math.min(result[j], result[j-1]);
            }
            result[0] += row.get(0);
        }

        int min = result[0];
        for (int j = 1; j < n; j++) {
            min = Math.min(min, result[j]);
        }
        return min;
    }
}
