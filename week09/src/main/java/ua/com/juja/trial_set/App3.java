package ua.com.juja.trial_set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class App3 {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>();
        set.add("A");
        set.add("AB");
        set.add("B");
        set.add("A");
        set.add("BA");
        set.add("B");

        String s = "ava+v";
        String b = s.substring(3,4);
        System.out.println(Integer.valueOf(b));

        System.out.println(set);
        System.out.println(set.iterator().next());
        System.out.println(set.floor("B"));
        System.out.println(set.floor(" A"));
        System.out.println(set.lower("BB"));
        System.out.println(set.tailSet("AB", true).size());
        System.out.println(set.headSet("ABC", true).size());
        System.out.println(set.subSet("AB", true, "BCA", true).size());
        System.out.println(set.subSet("AB", false, "BCA", false).size());
        System.out.println(set.first());
        System.out.println(set.pollFirst());
    }
}