package org.wei.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
   public static  class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s==null||s==""){
                return 0;
            }
            int len = s.length();
            char[] chars = s.toCharArray();
            int begin=0;
            int after =0;
            int max=0;
            Map<Character,Integer> characterMap = new HashMap<>();
            for (int i =0;i<len;i++){
                after++;
                if(characterMap.get(chars[i])!=null){
                    int tmp =characterMap.get(chars[i])+1;
                    begin = begin<tmp?tmp:begin;
                }
                characterMap.put(chars[i],i);
                max =Math.max(max,after-begin);

            }
            return max;
        }
    }
}
