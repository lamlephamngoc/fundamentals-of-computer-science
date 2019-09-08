package com.goriant.sharing.service.problem_solver;

import com.goriant.sharing.dto.Package;
import com.goriant.sharing.dto.PackageResult;

/**
 * @author Lam Le - lamle@gmx.com
 */
public interface Solver {

    PackageResult solve(Package aPackage);

}
