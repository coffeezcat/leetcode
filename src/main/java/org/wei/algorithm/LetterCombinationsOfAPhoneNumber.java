package org.wei.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
       List<String> chars = new Solution().letterCombinations("234");
        System.out.println(chars);
    }
   static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            for (char num:digits.toCharArray()){
                result=build(result,num);
            }
            return result;
        }

        /**
         * generate
         * */
        private List<String> build(List<String> origin,char num){
             char[] chars = getChars(num).toCharArray();
             List<String> result = new ArrayList<>();
            if(origin.size() == 0){
                for (char var1:chars) {
                    result.add(String.valueOf(var1));
                }
            }
            for (String var2:origin) {
                for (char var1:chars) {
                    result.add(var2+var1);
                }
            }
            return result;
        }
        private String getChars(char num){
            switch (num){
                case '2':return "abc";
                case '3':return "def";
                case '4':return "ghi";
                case '5':return "jkl";
                case '6':return "mno";
                case '7':return "pqrs";
                case '8':return "tuv";
                case '9':return "wxyz";
            }
            return "";
        }
    }
}
