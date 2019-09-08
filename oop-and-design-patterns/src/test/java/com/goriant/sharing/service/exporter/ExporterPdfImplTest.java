package com.goriant.sharing.service.exporter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Test;

/**
 * @author Lam Le - lamle@gmx.com
 */
public class ExporterPdfImplTest {

    @Test
    public void export() {
        Throwable thrown = catchThrowable(()-> new ExporterPdfImpl().export(null));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}