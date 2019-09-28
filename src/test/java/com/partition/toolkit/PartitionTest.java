package com.partition.toolkit;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PartitionTest {

    @Test
    public void test_partitions_of_2() {
        Partition<Integer> partition = new Partition<>(asList(1, 2, 3, 4, 5));
        List<List<Integer>> result = partition.partitions(2);

        List<List<Integer>> expected = asList(asList(1, 2), asList(3, 4), singletonList(5));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_partitions_of_3() {
        Partition<Integer> partition = new Partition<>(asList(1, 2, 3, 4, 5));
        List<List<Integer>> result = partition.partitions(3);

        List<List<Integer>> expected = asList(asList(1, 2, 3), asList(4, 5));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_partitions_of_1() {
        Partition<Integer> partition = new Partition<>(asList(1, 2, 3, 4, 5));
        List<List<Integer>> result = partition.partitions(1);

        List<List<Integer>> expected = asList(singletonList(1), singletonList(2), singletonList(3), singletonList(4), singletonList(5));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_fail_for_negative_partition_size() {
        Partition<Integer> partition = new Partition<>(asList(1, 2, 3, 4, 5));
        Throwable result = catchThrowable(() -> partition.partitions(-1));

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_fail_for_0_partition_size() {
        Partition<Integer> partition = new Partition<>(asList(1, 2, 3, 4, 5));
        Throwable result = catchThrowable(() -> partition.partitions(0));

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_fail_when_partition_size_exceeds_list_size() {
        Partition<Integer> partition = new Partition<>(asList(1, 2, 3, 4, 5));
        Throwable result = catchThrowable(() -> partition.partitions(-1));

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}