package com.partition.toolkit;

import com.google.common.collect.Streams;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Partition<T> {

    private final List<T> origin;

    private Partition(List<T> origin) {
        this.origin = origin;
    }

    public static <T> Partition<T> of(List<T> origin) {
        if (origin == null) {
            throw new IllegalArgumentException("Original list cannot be null");
        }

        return new Partition<T>(origin);
    }

    List<List<T>> partitions(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size should be a positive number!");
        }

        if (size > origin.size()) {
            throw new IllegalArgumentException("Size should not surpass the list's size!");
        }

        return Streams.zip(IntStream.range(0, origin.size()).boxed(), origin.stream(), Pair::new)
                .collect(groupingBy(pair -> pair._1 / size))
                .values().stream()
                .map(list -> list.stream().map(pair -> pair._2).collect(toList()))
                .collect(toList());
    }

}
