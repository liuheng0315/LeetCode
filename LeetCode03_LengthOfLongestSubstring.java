package leetcode;

import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode03_LengthOfLongestSubstring {
    //寻找最长不重复的字串
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        int i = 0, j = 0, ans = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(j - i, ans);
            } else {
                set.remove(s.charAt(i++));
            }

        }
        return ans;
    }
    //时间效率更高的解法
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int ans=0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }
            hashMap.put(s.charAt(j), j+1);
            ans = Math.max(j - i + 1, ans);
        }
        return ans;
    }
}
