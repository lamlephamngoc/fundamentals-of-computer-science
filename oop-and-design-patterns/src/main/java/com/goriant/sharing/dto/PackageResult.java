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
public class PackageResult {

    public static final PackageResult EMPTY_PACKAGE = new PackageResult();

    private double maxCost;

    private List<Item> pickedItems;
}
