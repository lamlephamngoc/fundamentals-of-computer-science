package com.goriant.sharing.service.exporter;

import static com.goriant.sharing.Utils.isEmpty;
import static java.util.stream.Collectors.joining;

import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.exception.ExportException;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

/**
 * Export result to Text format implementation
 * @author Lam Le - lamle@gmx.com
 */
@Slf4j
public class ExporterTextImpl extends AbstractExporter {

    private final static ExporterTextImpl exporter = new ExporterTextImpl();

    /**
     * Apply singleton eager initialization design pattern
     *
     * @return
     */
    public static Exporter getInstance() {

        return exporter;
    }

    /**
     * Avoid incident instance from default constructor
     */
    private ExporterTextImpl() {
    }

    @Override
    public Object export(final List<PackageResult> packageResults) throws ExportException {

        // guard
        if (isEmpty(packageResults)) return "-";

        final StringBuilder sb = new StringBuilder();

        try {
            for (PackageResult packageResult : packageResults) {

                final List<Item> pickedItems = packageResult.getPickedItems();
                if (isEmpty(pickedItems))
                    sb.append("-");
                else {
                    // sort by index ascending
                    pickedItems.sort(Comparator.comparing(Item::getIndex));

                    sb.append(
                            pickedItems
                                    .stream()
                                    .map(Item::getIndex)
                                    .map(Object::toString)
                                    .collect(joining(","))
                    );
                }
                sb.append("\n");
            }

        } catch (Exception e) {
            throw new ExportException(e);
        }
        return sb.toString();
    }
}
