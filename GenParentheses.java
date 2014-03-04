public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        return genParenHelper(n, n, 0);
    }

    public ArrayList<String> genParenHelper(int numLeftParen, int numRightParen, int numRightAllowed) {
        ArrayList<String> result = new ArrayList<String>();
        if (numLeftParen > 0) {
            String pre = "(";
            ArrayList<String> posts = genParenHelper(numLeftParen - 1, numRightParen, numRightAllowed+1);
            for (String post : posts) {
                result.add(pre+post);
            }
        }
        if (numRightParen > 0 && numRightAllowed > 0) {
            String pre = ")";
            ArrayList<String> posts = genParenHelper(numLeftParen, numRightParen-1, numRightAllowed-1);
            for (String post : posts) {
                result.add(pre+post);
            }
        }
        if (numLeftParen + numRightParen + numRightAllowed == 0) {
            result.add("");
        }
        return result;
    }
}
