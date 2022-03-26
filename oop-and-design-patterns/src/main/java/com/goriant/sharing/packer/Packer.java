package com.goriant.sharing.packer;

import static com.goriant.sharing.ErrorMessage.ERROR_MSG_FILE_INPUT_DOES_NOT_EXISTS;

import com.goriant.sharing.PackageManager;
import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.exception.APIException;
import com.goriant.sharing.service.exporter.Exporter;
import com.goriant.sharing.service.exporter.ExporterFactory;
import com.goriant.sharing.service.exporter.ExporterType;
import com.goriant.sharing.service.parser.Parser;
import com.goriant.sharing.service.parser.ParserFactory;
import com.goriant.sharing.service.parser.ParserType;
import com.goriant.sharing.service.problem_solver.KnapsackAlgorithmSolver;
import com.goriant.sharing.service.problem_solver.Solver;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Lam Le - lamle@gmx.com
 */
@Slf4j
public final class Packer {

    private Packer() {
    }

    public static String pack(final String filePath) throws APIException {

        // guard
        if (!Files.exists(Paths.get(filePath))) throw new APIException(ERROR_MSG_FILE_INPUT_DOES_NOT_EXISTS);

        final Parser parser = ParserFactory.create(ParserType.TEXT);
        final Exporter exporter = ExporterFactory.create(ExporterType.PRINTING);
        final Solver solver = KnapsackAlgorithmSolver.getInstance();

        final PackageManager packageManager = PackageManager
                .builder()
                .inputFilePath(filePath)
                .parser(parser)
                .solver(solver)
                .build();
        final List<PackageResult> pickedPackages;
        try {
            pickedPackages = packageManager.solve();
        } catch (IOException ioe) {
            throw new APIException(ERROR_MSG_FILE_INPUT_DOES_NOT_EXISTS, ioe);
        } catch (Exception e) {
            throw new APIException(e);
        }
        return (String) exporter.export(pickedPackages);
    }
}
