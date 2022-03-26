package com.goriant.sharing.service.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

/**
 * @author Lam Le - lamle@gmx.com
 */
public class ParserExcelImplTest {

    @Test
    public void parse() {

        // when
        Throwable thrown = catchThrowable(() -> new ParserExcelImpl().parse(null));

        // then
        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}