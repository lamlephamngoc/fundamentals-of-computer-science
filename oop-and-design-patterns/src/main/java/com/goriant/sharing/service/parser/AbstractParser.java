package com.goriant.sharing.service.parser;

import com.goriant.sharing.dto.Package;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This class provides a skeletal implementation of the Parser
 * @author Lam Le - lamle@gmx.com
 */
public abstract class AbstractParser implements Parser {

    @Override
    public List<Package> parse(File inputFile) throws IOException {
        throw new UnsupportedOperationException();
    }
}
