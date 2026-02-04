package org.yevhenstadnik.newinjava.java21;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class SequencedCollections {

    public static void main(String[] args) {
        SequencedCollection<String> set = new LinkedHashSet<>(List.of("apple", "banana", "cherry"));
        set.addFirst( "pear");
        set.addLast( "orange");
        String pear = set.getFirst();
        String orange = set.getLast();
        pear = set.removeFirst();
        orange = set.removeLast();
        set.reversed().forEach(System.out::println);

        SequencedMap<String, Integer> map = new LinkedHashMap<>(Map.of(
                "apple", 1, "banana", 2, "cherry", 3
        ));
        map.putFirst("pear", 4);
        map.putLast("orange", 5);
        Map.Entry<String, Integer> pearEntry = map.firstEntry();
        Map.Entry<String, Integer> orangeEntry = map.lastEntry();
        pearEntry = map.pollFirstEntry();
        orangeEntry = map.pollLastEntry();
        SequencedSet<Map.Entry<String, Integer>> entriesSet = map.sequencedEntrySet();
        SequencedSet<String> keysSet = map.sequencedKeySet();
        SequencedCollection<Integer> valuesSet = map.sequencedValues();
        map.reversed().forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
