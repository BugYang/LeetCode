public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int idx1 = 0, idx2 = 0, num1, num2;
        
        while (idx1 < versions1.length && idx2 < versions2.length) {
            num1 = Integer.parseInt(versions1[idx1++]);
            num2 = Integer.parseInt(versions2[idx2++]);
            if (num1 != num2)
                return num1 > num2 ? 1 : -1;
        }
        
        for (; idx1 < versions1.length; idx1++)
            if (Integer.parseInt(versions1[idx1]) != 0)
                return 1;
        for (; idx2 < versions2.length; idx2++)
            if (Integer.parseInt(versions2[idx2]) != 0)
                return -1;

        return 0;
    }
}