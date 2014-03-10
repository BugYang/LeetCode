public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        return combineHelper(n, k, 1);
    }

    public ArrayList<ArrayList<Integer>> combineHelper(int n, int k, int cur) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (k == 0) {
            result.add(list);
        } else if (n-cur+1 == k) {
            for (int i = cur; i <= n; i++) {
                list.add(i);
            }
            result.add(list);
        } else {
            result.addAll(combineHelper(n, k, cur+1));
            ArrayList<ArrayList<Integer>> lists = combineHelper(n, k-1, cur+1);
            for (int i = 0; i < lists.size(); i++) {
                lists.get(i).add(0, cur);
            }
            result.addAll(lists);
        }
        return result;
    }
}
