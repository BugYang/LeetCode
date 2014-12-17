public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        Set<String> used = new HashSet<String>();
        used.add(start);
        Set<String> levelUsed = new HashSet<String>();
        boolean found = false;
        Map<String, Set<String>> father = new HashMap<String, Set<String>>();
        int wordLen = start.length();

        while (!found && !queue.isEmpty()) {
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                String lastStep = queue.poll();
                char[] next = lastStep.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    for (next[j] = 'a'; next[j] <= 'z'; next[j]++) {
                        String nextStep = new String(next);
                        if (!dict.contains(nextStep) || used.contains(nextStep))
                            continue;
                        if (!father.containsKey(nextStep))
                            father.put(nextStep, new HashSet<String>());
                        father.get(nextStep).add(lastStep);
                        if (nextStep.equals(end)) {
                            found = true;
                        } else if (!levelUsed.contains(nextStep)) {
                            levelUsed.add(nextStep);
                            queue.add(nextStep);
                        }
                    }
                    next[j] = lastStep.charAt(j);
                }
            }
            
            Iterator<String> iter = levelUsed.iterator();
            while (iter.hasNext()) {
                used.add(iter.next());
                iter.remove();
            }
        }
        
        LinkedList<String> path = new LinkedList<String>();
        path.add(end);
        if (father.containsKey(end))
            getPath(start, end, father, path, result);
        
        return result;
    }
    
    public void getPath(String start, String end, Map<String, Set<String>> father, LinkedList<String> path, List<List<String>> result) {
        if (end.equals(start)) {
            ArrayList<String> list = new ArrayList<String>();
            for (String step : path)
                list.add(step);
            result.add(list);
            return;
        }
        
        Set<String> fathers = father.get(end);
        Iterator<String> iter = fathers.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            path.addFirst(next);
            getPath(start, next, father, path, result);
            path.removeFirst();
        }
    }
}