public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                row[j] = (j == 0 || j == i) ? 1 : row[j-1] + row[j];
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < row.length; i++) {
            result.add(row[i]);
        }
        return result;
    }
}
