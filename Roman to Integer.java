//https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int len = s.length();
        int ans = map.get(s.charAt(0));
        int previous = ans;
        for (int i = 1 ; i < len ; i++) {
            char curr = s.charAt(i);
            int val = map.get(curr);
            if (previous < val) {
                ans = ans - previous + val - previous;
                
            }
            
            else    
                ans = ans + val;
            
            previous = val;
        }
        
        return ans;
    }
}