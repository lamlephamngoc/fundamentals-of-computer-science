package com.goriant.sharing.service.problem_solver;

import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.Package;
import com.goriant.sharing.dto.PackageResult;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Knapsack 01 solution uses dynamic programming for enhance performance
 * this is a heart of application
 * <p>
 * Time complexity : O (n * W)
 * n : number of items
 * W : Max weight
 *
 * @author Lam Le - lamle@gmx.com
 */
@Slf4j
public class KnapsackAlgorithmSolver implements Solver {

    private final static KnapsackAlgorithmSolver SOLVER = new KnapsackAlgorithmSolver();

    public static KnapsackAlgorithmSolver getInstance() {
        return SOLVER;
    }

    private KnapsackAlgorithmSolver() {
    }

    /**
     * this is a heart of application
     * we apply knapsack 01 solution for solving this problem
     *
     * @param aPackage
     * @return
     */
    public PackageResult solve(final Package aPackage) {

        final double maxWeight = aPackage.getMaxWeight();

        return knapsack(maxWeight, aPackage.getItems());
    }

    private PackageResult knapsack(double maxWeight, List<Item> items) {

        int i, weight;
        int n = items.size();
        double K[][] = new double[n + 1][(int) maxWeight + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (weight = 0; weight <= maxWeight; weight++) {
                if (i == 0 || weight == 0) {
                    K[i][weight] = 0;
                } else if (items.get(i - 1).getWeight() <= weight) {
                    int remainingWeight = weight - ((int) items.get(i - 1).getWeight());
                    double currentVal = items.get(i - 1).getCost() + K[i - 1][remainingWeight];
                    double previousVal = K[i - 1][weight];

                    if (currentVal >= previousVal) {
                        K[i][weight] = currentVal;
                    } else {
                        K[i][weight] = previousVal;
                    }
                } else {
                    K[i][weight] = K[i - 1][weight];
                }
            }
        }

        final double maxCost = K[n][(int) maxWeight];

        final List<Item> pickedItems = new ArrayList<>();
        traceRouteBackward(K, maxWeight, items, pickedItems);

        return PackageResult.builder()
                .maxCost(maxCost)
                .pickedItems(pickedItems)
                .build();
    }

    private static void traceRouteBackward(double[][] maxCostMatrix, double maxWeight, List<Item> items, List<Item> pickedItems) {

        int maxRight = maxCostMatrix[0].length - 1;

        for (int i = maxCostMatrix.length - 1; i > 0; i--) {

            double currentItemWeight = items.get(i - 1).getWeight();

            if (!maxCostEqualsPreviousMaxCost(
                    maxCostMatrix[i][maxRight],
                    maxCostMatrix[i - 1][maxRight])

                    && (maxWeight - currentItemWeight) >= 0) {

                pickedItems.add(items.get(i - 1));
                maxWeight -= currentItemWeight;
            }
        }
    }

    private static boolean maxCostEqualsPreviousMaxCost(double currentMaxCost, double previousMaxCost) {
        return currentMaxCost == previousMaxCost;
    }
}
