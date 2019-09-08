package com.goriant.sharing.service.exporter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Test;

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