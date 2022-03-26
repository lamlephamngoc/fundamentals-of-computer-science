package com.goriant.sharing.service.problem_solver;

import static org.assertj.core.api.Assertions.assertThat;

import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.Package;
import com.goriant.sharing.dto.PackageResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KnapsackAlgorithmSolverTest {

    private Solver solver;

    @BeforeEach
    public void setup() {
        solver = KnapsackAlgorithmSolver.getInstance();
    }

    @Test
    public void test_algorithm_data_set_01() {

        List<Item> items = new ArrayList<>();
        items.add(packageOf(1, 90.72, 13));
        items.add(packageOf(2, 33.8, 40));
        items.add(packageOf(3, 43.15, 10));
        items.add(packageOf(4, 37.97, 16));
        items.add(packageOf(5, 46.81, 36));
        items.add(packageOf(6, 48.77, 79));
        items.add(packageOf(7, 81.8, 45));
        items.add(packageOf(8, 19.36, 79));
        items.add(packageOf(9, 6.76, 64));

        Package wrapper = Package.builder()
                .maxWeight(56.0)
                .items(items)
                .build();

        PackageResult packageResult = solver.solve(wrapper);

        assertThat(packageResult.getPickedItems().toString())
                .containsSubsequence("index").containsSubsequence("8")
                .containsSubsequence("index").containsSubsequence("9");
    }

    private Item packageOf(int index, double weight, double cost) {
        return Item.builder()
                .index(index)
                .weight(weight)
                .cost(cost)
                .build();
    }

    @Test
    public void test_algorithm_data_set_02() {
        List<Item> items = new ArrayList<>();

        items.add(packageOf(3, 3.98, 16));
        items.add(packageOf(2, 14.55, 74));
        items.add(packageOf(4, 26.24, 55));
        items.add(packageOf(7, 60.02, 74));
        items.add(packageOf(5, 63.69, 52));
        items.add(packageOf(6, 76.25, 75));
        items.add(packageOf(1, 85.31, 29));
        items.add(packageOf(9, 89.95, 78));
        items.add(packageOf(8, 93.18, 35));

        Package wrapper = Package.builder()
                .maxWeight(75.0)
                .items(items)
                .build();

        PackageResult packageResult = solver.solve(wrapper);

        assertThat(packageResult.getPickedItems().toString())
                .containsSubsequence("index").containsSubsequence("2")
                .containsSubsequence("index").containsSubsequence("7");
    }

    @Test
    public void test_algorithm_data_set_03() {
        List<Item> items = new ArrayList<>();

        items.add(packageOf(1, 1, 10));
        items.add(packageOf(2, 2, 20));
        items.add(packageOf(3, 3, 30));

        Package wrapper = Package.builder()
                .maxWeight(3.0)
                .items(items)
                .build();

        PackageResult packageResult = solver.solve(wrapper);

        assertThat(packageResult.getPickedItems().toString())
                .containsSubsequence("index").containsSubsequence("1")
                .containsSubsequence("index").containsSubsequence("2");

    }
}