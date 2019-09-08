package com.goriant.sharing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lam Le - lamle@gmx.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    private double maxWeight;

    private List<Item> items;
}
