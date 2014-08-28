public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank, start, current, numStation = gas.length;

        start = current = 0;
        while (start < numStation) {
            tank = 0;
            while (current < start + numStation) {
                tank += gas[current % numStation] - cost[current % numStation];
                current++;
                if (tank < 0) {
                    start = current;
                    break;
                }
            }
            if (current == start + numStation)
                return start;
        }
        
        return -1;
    }
}