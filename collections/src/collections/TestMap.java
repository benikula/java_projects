package collections;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        String[] s = {"aaa", "aaa", "aaa", "abc", "vvv", "aaa"}; 
        // Initialize frequency table from command line
        for (String a : s) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }
}