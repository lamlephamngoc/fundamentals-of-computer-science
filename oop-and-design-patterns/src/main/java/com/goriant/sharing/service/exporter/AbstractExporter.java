package com.goriant.sharing.service.exporter;

import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.exception.ExportException;

import java.util.List;

/**
 * This class provides a skeletal implementation of the Exporter
 * @author Lam Le - lamle@gmx.com
 */
public abstract class AbstractExporter implements Exporter {

    @Override
    public Object export(List<PackageResult> pickedPackages) throws ExportException {
        throw new UnsupportedOperationException();
    }
}
