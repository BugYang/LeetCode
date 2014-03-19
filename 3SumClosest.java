public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int[] numCopy = Arrays.copyOf(num, num.length);
        Arrays.sort(numCopy);
        int result = numCopy[0] + numCopy[1] + numCopy[2];
        for (int i = 0; i < numCopy.length-2; i++) {
            int closest = numCopy[i]+ twoSumClosest(target-numCopy[i], numCopy, i+1, numCopy.length-1);
            if (Math.abs(closest-target) < Math.abs(result-target)) {
                result = closest;
            }
        }
        return result;
    }

    public int twoSumClosest(int target, int[] num, int begin, int end) {
        int result = num[begin] + num[end];

        while (begin < end) {
            int closest = num[begin]+num[end];
            if (Math.abs(closest-target) < Math.abs(result-target)) {
                result = num[begin] + num[end];
            }

            if (closest < target) {
                begin++;
            } else if (closest > target) {
                end--;
            } else {
                break;
            }
        }

        return result;
    }

}
