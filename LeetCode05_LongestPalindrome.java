package leetcode;

import java.util.HashMap;

public class LeetCode05_LongestPalindrome {
    //最长的回文字符串
    public static void main(String[] args) {
        LeetCode05_LongestPalindrome lt = new LeetCode05_LongestPalindrome();
        String s = lt.longestPalindrome("ccc");
        System.out.println(s);
    }
    //方法1，中心扩散法
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return res;
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res=cur;
        }
    }
}
