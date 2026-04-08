package DynamicProgramming;

import java.util.Arrays;

public class LongestSubStringNoRepeat {
    public int longestSubStringWithoutDuplication(String str) {
        boolean[] flag = new boolean[26];
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            while (flag[c - 'a']) {
                flag[str.charAt(left) - 'a'] = false;
                left++;
            }
            flag[c - 'a'] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        LongestSubStringNoRepeat test = new LongestSubStringNoRepeat();
        System.out.println(test.longestSubStringWithoutDuplication(str));
    }
}
