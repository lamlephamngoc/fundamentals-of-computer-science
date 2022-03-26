package com.goriant.sharing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lam Le - lamle@gmx.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Comparable<Item> {

    private int index;

    private double weight;

    private double cost;

    @Override
    public int compareTo(Item other) {
        return Double.compare(weight, other.getWeight());
    }
}
