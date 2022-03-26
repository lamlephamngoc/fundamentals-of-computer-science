package com.goriant.sharing.service.exporter;

/**
 * factory method creates exporter by its type
 * @author Lam Le - lamle@gmx.com
 */
public final class ExporterFactory {

    public static Exporter create(ExporterType type) {

        final Exporter defaultExporter = ExporterTextImpl.getInstance();

        if (type == null) return defaultExporter;

        switch (type) {
            case PRINTING:
                return defaultExporter;
            case PDF:
                return new ExporterPdfImpl();
            case EXCEL:
                return new ExporterExcelImpl();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
