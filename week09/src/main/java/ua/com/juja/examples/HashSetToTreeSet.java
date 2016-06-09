package ua.com.juja.examples;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetToTreeSet {
    public static void main(String[] args) {
        Set<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("Dimass1"));     //L=3
        hashSet.add(new Person("Dim2"));    //L=4
        hashSet.add(new Person("Di3"));     //L=3
        hashSet.add(new Person("Dim4"));    //L=4
        hashSet.add(new Person("Dima5"));   //L=5
        hashSet.add(new Person("Di6"));   //L=5
        hashSet.add(new Person("Dimon7"));  //L=6
        hashSet.add(new Person("Dimas8"));  //L=6
        hashSet.add(new Person("Di9"));     //L=3
        hashSet.add(new Person("Di10"));    //L=4

        System.out.println("hashSet size is " + hashSet.size());
        System.out.println(hashSet.toString());

        Set<Person> treeSet = new TreeSet<>(hashSet);

        System.out.println();
        System.out.println("treeSet size is " + treeSet.size());
        System.out.println(treeSet);
    }

    private static class Person implements Comparable<Person>{

        private final int num;
        private final String name;
        private static int count = 1;

        public Person(String name) {
            this.name = name;
            this.num = count++ ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (num != person.num) return false;
            return name != null ? name.equals(person.name) : person.name == null;

        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return 50;
        }

        @Override
        public String toString() {
            return "{" +
                    "a=" + num +
                    ",n='" + name + '\'' +
                    "L=" + name.length() +
                    '}' ;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.length() - o.name.length(); //compare with mane length
//            return this.num - o.num;                   //compare with serial number
        }
    }
}
