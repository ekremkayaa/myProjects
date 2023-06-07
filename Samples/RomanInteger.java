import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Scanner;
public class RomanInteger {
    public static void main(String[] args) {
        System.out.println(intToRoman(345));
        System.out.println(intToRoman(2528));
        System.out.println(intToRoman(39));
        System.out.println(romanToInt("XC"));
    }
    public static String intToRoman(int number){
        //range of number is 1-3000
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number/1000] + hundreds[(number % 1000 ) / 100] + tens[(number % 100) / 10] + units[number % 10];
    }
    public static int romanToInt(String roman){
        Map<Character,Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int result = 0;
        for(int i = 0; i<roman.length(); i++){
            if(i>0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1)))
                result += map.get(roman.charAt(i)) - 2 * map.get(roman.charAt(i - 1));
            else
                result += map.get(roman.charAt(i));
        }
        return result;
    }
}

