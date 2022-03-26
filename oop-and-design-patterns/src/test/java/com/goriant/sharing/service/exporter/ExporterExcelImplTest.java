package com.goriant.sharing.service.exporter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


/**
 * @author Lam Le - lamle@gmx.com
 */
public class ExporterExcelImplTest {

    @Test
    public void export() {
        Throwable thrown = catchThrowable(() -> new ExporterExcelImpl().export(null));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);

    }
}