public class Solution {
    public ArrayList<ArrayList<Integer>> subsets_recur(int[] S) {
        int[] SS = Arrays.copyOf(S, S.length);
        Arrays.sort(SS);
        return subsetsHelper(SS, SS.length-1);
    }

    public ArrayList<ArrayList<Integer>> subsetsHelper(int[] S, int cur) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (cur == -1) {
            result.add(new ArrayList<Integer>());
        } else {
            result.addAll(subsetsHelper(S, cur-1));
            int len = result.size();
            for (int i = 0; i < len; i++) {
                ArrayList<Integer> set = (ArrayList<Integer>)result.get(i).clone();
                set.add(S[cur]);
                result.add(set);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> subsets_iter(int[] S) {
        int[] SS = Arrays.copyOf(S, S.length);
        Arrays.sort(SS);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int num : SS) {
            int len = result.size();
            for (int i = 0; i < len; i++) {
                ArrayList<Integer> set = (ArrayList<Integer>)result.get(i).clone();
                set.add(num);
                result.add(set);
            }
        }

        return result;
    }
}
