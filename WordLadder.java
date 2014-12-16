public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> used = new HashSet<String>();
        used.add(start);
        int wordLen = start.length();
        
        queue.add(start);
        while (!queue.isEmpty()) {
            String path = queue.poll();
            String[] steps = path.split(" ");
            String lastStep = steps[steps.length-1];
            char[] next = lastStep.toCharArray();
            for (int i = 0; i < wordLen; i++) {
                for (next[i] = 'a'; next[i] <= 'z'; next[i]++) {
                    String nextStep = new String(next);
                    if (!dict.contains(nextStep) || used.contains(nextStep))
                        continue;
                    if (nextStep.equals(end))
                        return steps.length + 1;
                    used.add(nextStep);
                    queue.add(path+" "+nextStep);
                }
                next[i] = lastStep.charAt(i);
            }
        }
        
        return 0;
    }
}