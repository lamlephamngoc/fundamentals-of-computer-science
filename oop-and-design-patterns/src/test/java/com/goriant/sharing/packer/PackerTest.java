package com.goriant.sharing.packer;

import static com.goriant.sharing.ErrorMessage.ERROR_MSG_FILE_INPUT_DOES_NOT_EXISTS;
import static com.goriant.sharing.ErrorMessage.ERROR_MSG_PACKAGE_STRING_LINE_INFO_NULL_OR_EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.goriant.BaseTest;
import com.goriant.sharing.exception.APIException;
import com.goriant.sharing.exception.InputInvalidFormatException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Integration test main static method Packer.pack
 */
public class PackerTest extends BaseTest {

    public static final String PACKAGE_TXT = "package.txt";

    public static final String INVALID_PACKAGE_TXT = "invalid_package.txt";

    public static final String COLLISION_PACKAGE_TXT = "collision_package.txt";

    private String filePath;

    private String invalidInputFilePath;

    private String collisionFilePath;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();

        File inputFile = new File(classLoader.getResource(PACKAGE_TXT).getFile());
        filePath = inputFile.getAbsolutePath();

        File invalidInputFile = new File(classLoader.getResource(INVALID_PACKAGE_TXT).getFile());
        invalidInputFilePath = invalidInputFile.getAbsolutePath();

        File collisionFile = new File(classLoader.getResource(COLLISION_PACKAGE_TXT).getFile());
        collisionFilePath = collisionFile.getAbsolutePath();
    }

    @Test
    public void pack_should_throw_exception_when_receiving_incorrect_input_file_path() throws Exception {

        // when
        Throwable thrown = catchThrowable(() -> Packer.pack("abc"));

        // then
        assertThat(thrown).isInstanceOf(APIException.class)
                .hasMessageContaining(ERROR_MSG_FILE_INPUT_DOES_NOT_EXISTS);
    }

    @Test
    public void pack_should_throw_exception_when_receiving_invalid_format_input_file() throws Exception {

        // when
        Throwable thrown = catchThrowable(() -> Packer.pack(invalidInputFilePath));

        // then
        assertThat(thrown).isInstanceOf(APIException.class)
                .hasCauseInstanceOf(InputInvalidFormatException.class)
                .hasMessageContaining(ERROR_MSG_PACKAGE_STRING_LINE_INFO_NULL_OR_EMPTY);
    }


    @Test
    public void pack_should_pickup_packages_with_max_cost() throws Exception {

        // when
        String result = Packer.pack(filePath);

        // then
        assertThat(result)
                .containsSubsequence("4")
                .containsSubsequence("-")
                .containsSubsequence("2,7")
                .containsSubsequence("8,9");
    }

    @Test
    public void pack_should_pickup_smaller_packages_in_case_collision_max_cost() throws Exception {

        // when
        String result = Packer.pack(collisionFilePath);

        // then
        assertThat(result)
                .containsSubsequence("1,2");
    }
}