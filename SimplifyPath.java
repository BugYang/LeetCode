public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.equals(""))
            return path;
            
        LinkedList<String> list = new LinkedList<String>();
        
        String[] tokens = path.split("/");
        for (String token : tokens) {
            if (token.equals("") || token.equals("."))
                continue;
            if (token.equals("..")) {
                if (list.size() != 0)
                    list.removeLast();
                continue;
            }
            list.addLast(token);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        for (String token : list) {
            sb.append(token);
            sb.append('/');            
        }
        if (sb.length() > 1)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}