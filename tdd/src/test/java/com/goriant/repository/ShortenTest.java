package com.goriant.repository;

import com.goriant.BaseTest;
import com.goriant.Shorter;
import com.goriant.exception.DuplicationException;
import com.goriant.exception.SeoViolateMaxLengthException;
import com.goriant.exception.UrlInvalidException;
import com.goriant.model.UrlStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ShortenTest extends BaseTest {

    private Shorter shorter;

    @BeforeEach
    void setup() {
        shorter = Shorten.getInstance();
    }

    @Nested
    class Init {

        @Test
        void shorten_object_should_be_singleton() {
            Shorten shorten = Shorten.getInstance();

            assertThat(shorten).isNotNull();
        }
    }

    @Nested
    class Corner_Cases {

        @Test
        void when_seo_exists_should_throw_duplication_exception() {
            // given
            shorter.shorten("https://www.google.com", "abc");

            // when
            Throwable thrown = catchThrowable(() -> shorter.shorten("http://www.google123.com", "abc"));

            // then
            assertThat(thrown).isInstanceOf(DuplicationException.class);
        }

        @Test
        void when_seo_over_max_length_should_throw_exception() {
            // when
            Throwable thrown = catchThrowable(() -> shorter.shorten("", "abdkfjsdkljsdlkfjdlsfjc"));

            // then
            assertThat(thrown).isInstanceOf(SeoViolateMaxLengthException.class);
        }

        @Test
        void when_input_nulls_should_throw_NPE() {
            // when
            Throwable thrown = catchThrowable(() -> shorter.shorten(null, null));

            // then
            assertThat(thrown).isInstanceOf(NullPointerException.class);
        }

        @Test
        void when_input_url_invalid_should_throw_exception() {
            // when
            Throwable thrown = catchThrowable(() -> shorter.shorten("null", ""));

            // then
            assertThat(thrown).isInstanceOf(UrlInvalidException.class);
        }
    }

    @Nested
    class Url_Storage_Test {

        @Test
        void url_storage_should_have_input_output() {
            // given
            UrlStorage urlStorage = new UrlStorage(null);
            urlStorage.setInputUrl("http://looooong.com/somepath");

            // when
            urlStorage.shortInputUrl("MY-NEW-WS");
            // then
            assertThat(urlStorage.getInputUrl()).isEqualTo("http://looooong.com/somepath");
            assertThat(urlStorage.getOutputUrl()).isEqualTo("http://short.com/MY-NEW-WS");
        }
    }

    @Nested
    class Shorten_Test {

        @Test
        void short_input_url_with_seo_keyword() {
            // when
            String outputUrl = shorter.shorten("http://looooong.com/somepath", "POTATO");

            // then
            assertThat(outputUrl).isEqualTo("http://short.com/POTATO");
        }

        @Nested
        class Exception {

        }
    }
}
