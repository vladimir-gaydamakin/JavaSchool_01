package ru.dataart.academy.java;

public class LongestSubstring {
    /**
     * @param checkString - input string to check
     * @return - length of max substring without repeatable characters
     * Example: dnmdncbb  -> 5 (mdncb)
     * amam -> 2 (am)
     */
    
    public  int getLengthOfLongestSubstring(String checkString) {
        int stringLength = checkString.length();
        if (stringLength <= 1) {
            return stringLength;
        }
        
        StringBuilder temp = new StringBuilder();
        int maxLength = 0;

        for (char ch : checkString.toCharArray()) {
            String current = String.valueOf(ch);
            if (temp.indexOf(current) != -1) {
                temp = new StringBuilder(temp.substring(temp.indexOf(current) + 1));
            }
            temp.append(ch);
            if (maxLength < temp.length()) {
                maxLength = temp.length();
            }            
        }
        return maxLength;
    }
}
