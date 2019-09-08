package com.goriant;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;

/**
 * @author Lam Le - lamle@gmx.com
 */
public abstract class BaseTest {

    @Before
    public void init() {
        initMocks(this);
    }

}
