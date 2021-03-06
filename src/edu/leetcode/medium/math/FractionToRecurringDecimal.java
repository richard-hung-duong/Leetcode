package edu.leetcode.medium.math;

import java.util.HashMap;

/**
 * Created by hungduong on 10/19/16.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long nume = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        String sign = (numerator < 0) ^ (denominator < 0) ? "-" : "";
        if (deno == 0) {
            return "";
        } else if (nume == 0) {
            return "0";
        } else if (nume % deno == 0) {
            return sign + nume/deno + "";
        }

        HashMap<Long,Integer> map = new HashMap<Long, Integer>();
        StringBuffer rst = new StringBuffer(sign + nume/deno + ".");
        long end = nume%deno * 10;//The decimal portion of the value, after decimal point
        int i = 0;
        while (end != 0){
            if (map.containsKey(end)) {
                rst.insert(rst.indexOf(".") + map.get(end) + 1, "(");
                rst.append(")");
                return rst.toString();
            }
            rst.append(end/deno);
            map.put(end, i++);
            end = (end % deno) * 10;
        }
        return rst.toString();
    }
}
