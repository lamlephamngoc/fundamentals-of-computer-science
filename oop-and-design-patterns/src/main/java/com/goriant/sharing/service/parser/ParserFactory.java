package com.goriant.sharing.service.parser;

/**
 * Factory method creates Parser by its type
 * @author Lam Le - lamle@gmx.com
 */
public class ParserFactory {

    public static Parser create(final ParserType type) {

        final Parser defaultParser = ParserTextImpl.getInstance();

        if (null == type) return defaultParser;

        switch (type) {
            case TEXT:
                return defaultParser;
            case CSV:
                return new ParserCsvImpl();
            case EXCEL:
                return new ParserExcelImpl();
            default:
                return defaultParser;
        }
    }
}
