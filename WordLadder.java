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

public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		Set<String> used = new HashSet<String>();
		used.add(start);
		int wordLen = start.length();
		int level = 1;
		int levelSize = 1;

		while (!queue.isEmpty()) {
			String front = queue.poll();
			char[] next = front.toCharArray();
			for (int i = 0; i < wordLen; i++) {
				for (next[i] = 'a'; next[i] <= 'z'; next[i]++) {
					String nextStep = new String(next);
					if (!dict.contains(nextStep) || used.contains(nextStep))
						continue;
					if (nextStep.equals(end))
						return level+1;
					used.add(nextStep);
					queue.add(nextStep);
				}
				next[i] = front.charAt(i);
			}

			levelSize--;
			if (levelSize == 0) {
				level++;
				levelSize = queue.size();
			}
		}

		return 0;
	}
}
