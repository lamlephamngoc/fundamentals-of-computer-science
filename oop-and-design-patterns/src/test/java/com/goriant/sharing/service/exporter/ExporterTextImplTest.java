package com.goriant.sharing.service.exporter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.goriant.BaseTest;
import com.goriant.sharing.dto.Item;
import com.goriant.sharing.dto.PackageResult;
import com.goriant.sharing.exception.ExportException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExporterTextImplTest extends BaseTest {

    private Exporter exporter;

    @BeforeEach
    public void setup() {
        exporter = ExporterTextImpl.getInstance();
    }

    @Test
    public void export_text_should_return_ordered_index() {

        // given
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().index(1).build());
        items.add(Item.builder().index(2).build());
        items.add(Item.builder().index(3).build());

        PackageResult packageResult = PackageResult.builder()
                .pickedItems(items)
                .build();

        // when
        String exported = (String) exporter.export(Collections.singletonList(packageResult));

        // then
        assertThat(exported).isEqualTo("1,2,3\n");
    }

    @Test
    public void export_get_runtime_exception_should_throw_ExportException() {

        // given
        PackageResult packageResult = mock(PackageResult.class);
        when(packageResult.getPickedItems()).thenThrow(RuntimeException.class);

        // when
        Throwable thrown = catchThrowable(() -> exporter.export(Collections.singletonList(packageResult)));

        // then
        assertThat(thrown)
                .isInstanceOf(ExportException.class)
                .hasCauseInstanceOf(RuntimeException.class);

    }
}