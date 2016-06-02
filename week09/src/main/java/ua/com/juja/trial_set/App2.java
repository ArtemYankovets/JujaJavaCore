package ua.com.juja.trial_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(map.size(), map.size());
        map.put(map.size(), map.size());
        map.put(map.size(), map.size());
        System.out.println(new HashSet<>(map.values()).size());
        System.out.println(map);
    }
}