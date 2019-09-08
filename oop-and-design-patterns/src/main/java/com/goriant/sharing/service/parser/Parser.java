package com.goriant.sharing.service.parser;

import com.goriant.sharing.dto.Package;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Lam Le - lamle@gmx.com
 */
public interface Parser {

    List<Package> parse(File inputFile) throws IOException;
}
