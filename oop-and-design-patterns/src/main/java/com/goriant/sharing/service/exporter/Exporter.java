package com.goriant.sharing.service.exporter;

import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.exception.ExportException;

import java.util.List;

/**
 * @author Lam Le - lamle@gmx.com
 */
public interface Exporter {

    Object export(List<PackageResult> pickedPackages) throws ExportException;
}
