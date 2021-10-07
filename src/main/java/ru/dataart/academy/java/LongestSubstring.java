package ru.dataart.academy.java;

import java.util.HashMap;

public class LongestSubstring {
    /**
     * @param checkString - input string to check
     * @return - length of max substring without repeatable characters
     * Example: dnmdncbb  -> 5 (mdncb)
     * amam -> 2 (am)
     */

    public static int getLengthOfLongestSubstring(String checkString) {
        int stringLength = checkString.length();
        if (stringLength <= 1) {
            return stringLength;
        }

        int maxLength = 1;
        int tempLength = 1;
        int leftBound = 1;
        HashMap<Character, Integer> charsMap = new HashMap<>();
        charsMap.put(checkString.charAt(0), 1);

        for (int i = 1; i < stringLength; i++) {
            char tmpChar = checkString.charAt(i);
            Integer tmpCharIndex = charsMap.get(tmpChar);

            if (tmpCharIndex == null || tmpCharIndex < leftBound) {
                tempLength++;
                maxLength = maxLength > tempLength ? maxLength : tempLength;
            } else {
                leftBound = tmpCharIndex;
                tempLength = i - leftBound + 1;
            }
            charsMap.put(tmpChar, i + 1);
        }
        return maxLength;
    }
}
