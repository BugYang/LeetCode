public class Solution {
    public boolean oneBitDiff(int a, int b) {
        int c = a^b, cnt = 0;
        while (c > 0) {
            cnt += c & 1;
            c = c >> 1;
        }
        return cnt == 1;
    }

    public ArrayList<Integer> grayCode_bruteforce(int n) {
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow *= 2;
        }

        int[] seq = new int[pow];
        for (int i = 0; i < pow; i++) {
            seq[i] = i;
        }

        for (int i = 0; i < pow-1; i++) {
            if (oneBitDiff(seq[i], seq[i+1])) {
                continue;
            }
            for (int j = i+2; j < pow; j++) {
                if (oneBitDiff(seq[i], seq[j])) {
                    int t = seq[i+1];
                    seq[i+1] = seq[j];
                    seq[j] = t;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i : seq) {
            result.add(i);
        }
        return result;
    }

    public ArrayList<Integer> grayCode(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        int count = 1, t, t0, t1;
        while (n-- > 0) {
            for (int i = 0; i < count; i++) {
                t = queue.remove();
                t0 = t << 1 | (i%2 == 0 ? 0 : 1);
                t1 = t << 1 | (i%2 == 0 ? 1 : 0);
                queue.add(t0);
                queue.add(t1);
            }
            count *= 2;
        }

        return new ArrayList<Integer>(queue);
    }
}
