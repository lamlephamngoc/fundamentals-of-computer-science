package com.goriant.sharing.service.parser;

import static com.goriant.sharing.ErrorMessage.ERROR_MSG_PACKAGE_STRING_LINE_INFO_NULL_OR_EMPTY;
import static com.goriant.sharing.Utils.isEmpty;

import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.Package;
import com.goriant.sharing.exception.InputInvalidFormatException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Text file format parser implementation
 *
 * @author Lam Le - lamle@gmx.com
 */
@Slf4j
public class ParserTextImpl extends AbstractParser {

    public static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+(?:\\.\\d+)?)");

    private final static ParserTextImpl parser = new ParserTextImpl();

    /**
     * Apply singleton eager initialization design pattern
     *
     * @return
     */
    public static Parser getInstance() {
        return parser;
    }

    /**
     * Avoid incident instance from default constructor
     */
    private ParserTextImpl() {
    }

    @Override
    public List<Package> parse(File inputFile) throws IOException {

        final List<Package> packages = new ArrayList<>();

        try (final BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (isEmpty(line))
                    throw new InputInvalidFormatException(ERROR_MSG_PACKAGE_STRING_LINE_INFO_NULL_OR_EMPTY);

                final String[] rawPackage = line.split(":");
                final double maxWeight = Double.valueOf(rawPackage[0]);
                final List<Item> items = determinePackages(rawPackage[1]);

                packages.add(
                        Package.builder()
                                .items(items)
                                .maxWeight(maxWeight)
                                .build()
                );
            }
        }
        return packages;
    }

    private List<Item> determinePackages(final String rawPackages) {

        final List<Item> items = new ArrayList<>();

        final Matcher matcher = NUMBER_PATTERN.matcher(rawPackages);

        Item pack = new Item();
        int count = 0;

        while (matcher.find()) {
            count++;
            if (count % 2 == 0) {
                pack.setWeight(Double.parseDouble(matcher.group(1)));
            } else if (count % 3 == 0) {
                pack.setCost(Double.parseDouble(matcher.group(1)));
                count = 0;
            } else {
                pack = new Item();
                items.add(pack);
                pack.setIndex(Integer.parseInt(matcher.group(1)));
            }
        }
        return items;
    }
}
