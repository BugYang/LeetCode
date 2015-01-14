public class Solution {
    public String largestNumber(int[] num) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(num.length, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s1 = Integer.toString(i1), s2 = Integer.toString(i2);
                if (s1.length() != s2.length()) {
                    String t1 = s1+s2;
                    String t2 = s2+s1;
                    s1 = t1;
                    s2 = t2;
                }
                for (int i = 0; i < s1.length(); i++)
                    if (s1.charAt(i) != s2.charAt(i))
                        return -Character.compare(s1.charAt(i), s2.charAt(i));
                return 0;
            }
        });
        
        for (int i : num)
            pq.add(i);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++)
            sb.append(pq.poll());
        
        String result = sb.toString();
        for (int i = 0; i < result.length(); i++)
            if (result.charAt(i) != '0')
                return result;
        return "0";
    }
}