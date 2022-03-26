package com.goriant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.goriant.sharing.PackageManager;
import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.Package;
import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.service.parser.Parser;
import com.goriant.sharing.service.problem_solver.Solver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

/**
 * @author Lam Le - lamle@gmx.com
 */
public class ItemManagerTest extends BaseTest {

    @Mock
    private Parser parser;

    @Mock
    private Solver solver;

    private PackageManager packageManager;

    @BeforeEach
    public void setup() {
        packageManager = PackageManager.builder()
                .inputFilePath("")
                .solver(solver)
                .parser(parser)
                .build();
    }

    @Test
    public void test_solve_problem() throws Exception {

        // given
        Package aPackage = Package.builder()
                .items(Collections.singletonList(Item.builder().build()))
                .build();
        when(parser.parse(any())).thenReturn(Collections.singletonList(aPackage));
        when(solver.solve(any())).thenReturn(PackageResult.builder().build());

        List<PackageResult> results = packageManager.solve();

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).getMaxCost()).isEqualTo(0.0);
    }
}