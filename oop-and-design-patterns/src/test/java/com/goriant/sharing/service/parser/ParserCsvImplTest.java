package com.goriant.sharing.service.parser;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
/**
 * @author Lam Le - lamle@gmx.com
 */
public class ParserCsvImplTest {

    @Test
    public void parse() {
        Throwable thrown = catchThrowable(()-> new ParserCsvImpl().parse(null));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}