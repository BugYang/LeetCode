public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        int[] sorted_num = Arrays.copyOf(num, num.length);
        Arrays.sort(sorted_num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        int new_cnt = 1;
        for (int i = 0; i < sorted_num.length; i++) {
            int len = result.size();
            int begin = i > 0 && sorted_num[i] == sorted_num[i-1] ? len-new_cnt : 0;
            new_cnt = 0;
            for (int j = begin; j < len; j++) {
                ArrayList<Integer> set = (ArrayList<Integer>)result.get(j).clone();
                set.add(sorted_num[i]);
                result.add(set);
                new_cnt++;
            }
        }
        return result;
    }
}
