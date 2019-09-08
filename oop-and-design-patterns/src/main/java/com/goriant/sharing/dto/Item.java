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
public class Item implements Comparable {

    private int index;

    private double weight;

    private double cost;

    @Override
    public int compareTo(Object other) {
        return Double.compare(weight, ((Item) other).getWeight());
    }
}
