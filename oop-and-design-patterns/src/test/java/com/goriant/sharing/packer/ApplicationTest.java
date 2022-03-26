package com.goriant.sharing.packer;

import static com.goriant.sharing.ErrorMessage.ERROR_MSG_FILE_INPUT_PATH_REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.goriant.sharing.Application;
import com.goriant.BaseTest;
import com.goriant.sharing.exception.APIException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

/**
 * @author Lam Le - lamle@gmx.com
 */
public class ApplicationTest extends BaseTest {

    public static final String PACKAGE_TXT = "package.txt";

    private String filePath;

    @BeforeEach
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(Objects.requireNonNull(classLoader.getResource(PACKAGE_TXT)).getFile());
        filePath = inputFile.getAbsolutePath();
    }

    @Test
    public void missing_argument_should_receive_exception() {
        Throwable thrown = catchThrowable(() -> Application.main(new String[0]));

        assertThat(thrown)
                .isInstanceOf(APIException.class)
                .hasMessage(ERROR_MSG_FILE_INPUT_PATH_REQUIRED);

    }

    @Test
    public void pass_package_file_should_not_receive_error() throws Exception {
        Application.main(new String[]{filePath});
    }
}
