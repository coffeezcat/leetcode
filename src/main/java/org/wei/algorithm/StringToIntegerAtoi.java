package org.wei.algorithm;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String str = "   -42";
        System.out.println(new Solution().myAtoi(str));
    }
   public static class Solution {
        public int myAtoi(String str) {
            try {
                if(str.startsWith(" ")){
                    return 0;
                }
                return Integer.parseInt(str);
            }catch (Exception e){
                return 0;
            }

        }
    }
}
