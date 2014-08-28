public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permuteHelper(num, 0, num.length-1);
    }

    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int begin, int end) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (begin > end) {
            return result;
        }
        if (begin == end) {
            ArrayList<Integer> p = new ArrayList<Integer>();
            p.add(num[begin]);
            result.add(p);
            return result;
        }

        ArrayList<ArrayList<Integer>> subResult = permuteHelper(num, begin + 1, end);
        for (ArrayList<Integer> list : subResult) {
            for (int i = 0; i <= end - begin; i++) {
                ArrayList<Integer> p = new ArrayList<Integer>();
                p.addAll(list.subList(0, i));
                p.add(num[begin]);
                p.addAll(list.subList(i, end -begin));
                result.add(p);
            }
        }
        return result;
    }
}
