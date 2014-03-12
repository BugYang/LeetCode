public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char last = stack.pop();
                if (last == '(' && cur != ')' ||
                        last == '[' && cur != ']' ||
                        last == '{' && cur != '}') {
                    return false;
                        }
            }
        }
        return stack.empty();
    }
}
