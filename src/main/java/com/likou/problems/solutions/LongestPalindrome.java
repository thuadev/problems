package com.likou.problems.solutions;

import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huati@gridsum.com
 * @Created 2020/10/8 10:32
 **/
public class LongestPalindrome {

    //暴力解法
    public String longestPalindrome_1(String s) {
        //回文字符串
        String longestStr = "";
        //双层循环得到所有的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String subStr = s.substring(i, j);
                if (subStr.length() > longestStr.length()) {
                    if (isPalindrome(subStr)) {
                        longestStr = subStr;
                    }
                }
            }
        }
        return longestStr;
    }

    //中心扩散法 扩散的过程中判定回文字符串
    public String longestPalindrome_2(String s) {
        //单层循环
        int length = s.length();
        int maxLen = 0;
        int maxStart = -1;
        for (int i = 0; i < length; i++) {
            int left = i - 1;
            int right = i + 1;
            int len = 1;
            //向左扩散 左边与中心点相等则继续
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                len = i - left + 1;
                left--;
            }
            //向右扩散 右边与中心点相等则继续
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                len = right - i + 1;
                right++;
            }
            //左右同时扩散 左右两边相等则继续
            while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                len = right - left + 1;
                right++;
                left--;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left + 1;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    //回文字符串判定
    public boolean isPalindrome(String subStr) {
        int length = subStr.length();
        char[] chars = subStr.toCharArray();
        //abcba d abcba
        //adda
        boolean isEven = length % 2 == 0;
        int halfLength = isEven ? length / 2 : (length - 1) / 2;
        String left = subStr.substring(0, halfLength);
        String right = subStr.substring(isEven ? halfLength : halfLength + 1);
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        for (int i = 0; i < leftArray.length; i++) {
            if (leftArray[i] != rightArray[halfLength - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
