package com.potterkata;
import java.util.*;
import java.util.stream.Collectors;

public class Potter {
    static Double price(Integer [] books)
    {
        List<Set<Integer>> groups =  setOfBooks(books);
        optimizeSets(groups);

        double price = 0.0;

        for(Set<Integer> group : groups) {
            price += group.size() * 8 * promotion(group);
        }

        return price;
    }

    private static void optimizeSets(List<Set<Integer>> groups) {
        List<Set<Integer>> groupsOf3 = groups.stream().filter(g -> g.size() == 3).collect(Collectors.toList());

        for(Set<Integer> group : groupsOf3) {
            Optional<Set<Integer>> groupsOf5 =  groups
                    .stream()
                    .filter(s -> s.size() == 5)
                    .findFirst();

            if(groupsOf5.isPresent()) {
                Optional<Integer> book = groupsOf5.get().stream().filter(b -> !group.contains(b)).findFirst();

                if(book.isPresent()) {
                    group.add(book.get());
                    groupsOf5.get().remove(book.get());
                }
            }
        }
    }

    private static List<Set<Integer>> setOfBooks(Integer[] books) {
        List<Set<Integer>> groups = new ArrayList<>();
        for(Integer book : books) {
            Optional<Set<Integer>> set = groups.stream()
                    .filter( s -> !s.contains(book))
                    .findFirst();
            if(set.isPresent()) {
                set.get().add(book);
            } else {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(book);
                groups.add(newSet);
            }
        }

        return groups;
    }

    public static Double promotion(Set<Integer> books) {
        if(books.size() == 2)
            return 0.95;
        if(books.size() == 3)
            return 0.9;
        if(books.size() == 4)
            return 0.80;
        if(books.size() == 5)
            return 0.75;
        return 1.0;
    }
}
