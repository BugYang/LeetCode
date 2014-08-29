public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return result;

        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        combinationSum2Helper(num, used, target, result, 0);
        return result;
    }
    
    public void combinationSum2Helper(int[] num, boolean[] used, int remain, List<List<Integer>> result, int idx) {
        if (remain == 0) {
            List<Integer> comb = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++)
                if (used[i])
                    comb.add(num[i]);
            result.add(comb);
            return;
        }
        if (idx >= num.length)
            return;
        
        for (int i = idx; i < num.length; i++) {
            if (i > 0 && num[i] == num[i-1] && !used[i-1])
                continue;
            if (num[i] <= remain) {
                used[i] = true;
                combinationSum2Helper(num, used, remain - num[i], result, i + 1);
                used[i] = false;
            }
        }
    }
}