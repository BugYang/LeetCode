public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] copyCandidates = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(copyCandidates);
        combinationSumHelper(copyCandidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void combinationSumHelper(int[] candidates, int cur, int target, ArrayList<Integer> prefix, ArrayList<ArrayList<Integer>> result) {
        if (cur == candidates.length) {
            return;
        }
        int newTarget = target;
        for (int i = 0; i <= target/candidates[cur]; i++) {
            if (newTarget > 0) {
                combinationSumHelper(candidates, cur+1, newTarget, (ArrayList<Integer>)prefix.clone(), result);
            } else if (newTarget == 0) {
                result.add((ArrayList<Integer>)prefix.clone());
                break;
            } else {
                break;
            }
            newTarget -= candidates[cur];
            prefix.add(candidates[cur]);
        }
    }
}
