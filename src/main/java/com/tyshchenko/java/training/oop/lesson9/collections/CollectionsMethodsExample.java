package com.tyshchenko.java.training.oop.lesson9.collections;

import java.util.*;

/**
 * @author Alexander Tyshchenko.
 */
public class CollectionsMethodsExample {

    public static void main(String[] args) {
        CollectionsMethodsExample object = new CollectionsMethodsExample();
    }

    private Map<Integer, String> map = new HashMap<>();
    private NavigableMap<Integer, String> navigableMap = new TreeMap<>();
    private SortedMap<Integer, String> sortedMap = new TreeMap<>();
    private List<String> list = new ArrayList<>();
    private Set<String> set = new HashSet<>();

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    public Map<Integer, String> getMap() {
        return Collections.unmodifiableMap(map);
    }

    public Set<String> getSet() {
        return Collections.unmodifiableSet(set);
    }

    public Collection<String> getCollection() {
        return Collections.unmodifiableCollection(list);
    }

    public NavigableMap<Integer, String> getNavigableMap() {
        return Collections.unmodifiableNavigableMap(navigableMap);
    }

    public SortedMap<Integer, String> getSortedMap() {
        return Collections.unmodifiableSortedMap(sortedMap);
    }
}
