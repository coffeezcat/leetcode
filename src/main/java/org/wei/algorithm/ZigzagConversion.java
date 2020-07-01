package org.wei.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *Z字形变换
 *将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 */
public class ZigzagConversion {

    private static final  String  STR = "ABC";
    public static void main(String[] args) {
        String res = new Solution().convert(STR,2);
        System.out.println(res);

    }

    public static class Solution {
        
        public String convert(String s, int numRows) {
            if(s==null||s.equals("")){
                return "";
            }
            int len = s.length();
            int  single =0;
            if(numRows> 1){
               single = numRows+numRows-2;
            }else {
                return s;
            }

            int all = len%single==0?len/single:len/single+1;
            Character[][] chars = new Character[numRows][all*(numRows-1)];
            char[] charArr = s.toCharArray();
            int acl = 0;
            for (int i = 0; i <len ; i++) {
                int mod = i%single;
                int cl = 0;
                int cRow=0;
                if(mod<numRows){
                    cl =acl;
                    cRow = mod;
                }else{
                    cl = ++acl;
                    cRow = 2*(numRows-1)-mod;
                }
                if(mod==single-1){
                    acl++;
                }
                chars[cRow][cl] =charArr[i];
            }
            return format(chars);
        }

        private String format(Character[][] chars){
            StringBuilder sb = new StringBuilder();

            for (Character[] row:chars) {
                for (Character c:row) {
                    if(c!=null){
                        sb.append(c);
                    }
                }
            }
            return sb.toString();
        }
    }

    /**
     * 上下循环
     * */
    public static class Solution1 {
        public String convert(String s, int numRows) {
            if(s==null||s.equals("")||numRows==1){
                return s;
            }
            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++)
                rows.add(new StringBuilder());
            boolean goingDown = false;
            int curRow = 0;
            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
                curRow += goingDown ? 1 : -1;
            }
            StringBuilder ret = new StringBuilder();
            for (StringBuilder row : rows) ret.append(row);
            return ret.toString();
        }
    }
}
