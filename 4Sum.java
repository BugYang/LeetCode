public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length-3; i++) {
            if (i > 0 && num[i] == num[i-1])
                continue;
            for (int j = i+1; j < num.length-2; j++) {
                if (j > i+1 && num[j] == num[j-1])
                    continue;
                for (int k = j+1; k < num.length-1; k++) {
                    if (k > j+1 && num[k] == num[k-1])
                        continue;
                    if (Arrays.binarySearch(num, k+1, num.length, target-num[i]-num[j]-num[k]) >= 0)
                        result.add(getList(num[i], num[j], num[k], target-num[i]-num[j]-num[k]));
                }
            }
        }
        return result;
    }
    
    public List<Integer> getList(int a, int b, int c, int d) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return list;
    }
}