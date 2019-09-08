package com.goriant.sharing;

import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.dto.Package;
import com.goriant.sharing.service.parser.Parser;
import com.goriant.sharing.service.problem_solver.Solver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam Le - lamle@gmx.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageManager {

    private String inputFilePath;

    private Parser parser;

    private Solver solver;

    public List<PackageResult> solve() throws IOException {

        final File inputFile = new File(this.inputFilePath);
        final List<Package> packages = parser.parse(inputFile);

        sortPackagesByWeightAscending(packages);

        final List<PackageResult> pickedPackages = new ArrayList<>(packages.size());
        for (Package aPackage : packages)
            pickedPackages.add(solver.solve(aPackage));

        return pickedPackages;
    }

    private void sortPackagesByWeightAscending(List<Package> packages) {
        for (Package wrapper : packages)
            wrapper.getItems().sort(Item::compareTo);
    }
}
