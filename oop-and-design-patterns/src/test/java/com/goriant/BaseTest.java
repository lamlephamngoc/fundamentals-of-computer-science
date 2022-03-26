package com.goriant;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Lam Le - lamle@gmx.com
 */
public abstract class BaseTest {

    @BeforeEach
    public void init() {
        initMocks(this);
    }

}
