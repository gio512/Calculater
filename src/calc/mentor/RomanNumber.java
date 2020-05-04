package calc.mentor;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RomanNumber {

    private final static TreeMap<Integer, String> map = new TreeMap<>();
    private final static Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

    static {
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(8, "VIII");
        map.put(7, "VII");
        map.put(6, "VI");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(3, "III");
        map.put(2, "II");
        map.put(1, "I");
    }

    public static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    public static boolean equalsToRoman(String str) {
        boolean equals = false;
        for (int i = 0; i <= 10; i++) {
            if(str.equals(map.get(i))){
                equals = true;
            }
        }
        return equals;
    }

    public static int parseInt(String str) {
        int num = 0;
        for (Map.Entry<Integer, String> pair : entrySet) {
            if (str.equals(pair.getValue())) {
                num = pair.getKey();
            }
        }
        return num;
    }
}
