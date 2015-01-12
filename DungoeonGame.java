public class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;
		int[] health = new int[n];

		// init
		health[n-1] = dungeon[m-1][n-1] >= 0 ? 1 : 1-dungeon[m-1][n-1];
		for (int j = n-2; j >= 0; j--) {
			health[j] = dungeon[m-1][j] >= health[j+1] ? 1 : health[j+1]-dungeon[m-1][j];
		}

		// dp
		for (int i = m-2; i >= 0; i--) {
			health[n-1] = dungeon[i][n-1] >= health[n-1] ? 1 : health[n-1]-dungeon[i][n-1];
			for (int j = n-2; j >= 0; j--) {
				health[j] = (dungeon[i][j] >= health[j] || dungeon[i][j] >= health[j+1]) ? 1 : Math.min(health[j], health[j+1])-dungeon[i][j];
			}

		}

		return health[0];
	}
}
