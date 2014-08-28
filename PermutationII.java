public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        if (num == null || num.length == 0)
            return result;

        Arrays.sort(num);
        List<Integer> permutation = new LinkedList<Integer>();
        boolean[] used = new boolean[num.length];
        permuteUniqueHelper(num, used, permutation, result);
        
        return result;
    }
    
    public void permuteUniqueHelper(int[] num, boolean[] used, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == num.length) {
            result.add(new LinkedList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i-1] && !used[i-1])
                continue;
            if (!used[i]) {
                permutation.add(num[i]);
                used[i] = true;
                permuteUniqueHelper(num, used, permutation, result);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
