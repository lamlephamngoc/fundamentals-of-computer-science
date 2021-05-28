package com.goriant;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GoriantTest extends BaseTest {

    private Goriant goriant;

    @BeforeEach
    void setup() {
        goriant = new Goriant();
    }

    @Nested
    class Happy_Case {
        @Test
        void test_add() {
            // when
            int add = goriant.add(1, 2);

            // then
            assertThat(add).isEqualTo(3);
        }
    }

    @Nested
    class Corner_Case {

        @Test
        void NPE() {
            // given
            final Integer a = null;
            // when
            Throwable thrown = catchThrowable(() -> goriant.add(a, 1));

            // then
            assertThat(thrown).isInstanceOf(NullPointerException.class);
        }
    }
}