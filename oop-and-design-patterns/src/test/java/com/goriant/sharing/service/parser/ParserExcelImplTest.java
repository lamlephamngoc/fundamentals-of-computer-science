package com.goriant.sharing.service.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Test;

/**
 * @author Lam Le - lamle@gmx.com
 */
public class ParserExcelImplTest {

    @Test
    public void parse() {

        Throwable thrown = catchThrowable(() -> new ParserExcelImpl().parse(null));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}