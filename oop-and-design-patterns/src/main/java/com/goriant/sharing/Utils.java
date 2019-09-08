package com.goriant.sharing;

import java.util.Collection;

/**
 * @author Lam Le - lamle@gmx.com
 */
public final class Utils {

    private Utils() {
    }

    public static boolean isEmpty(final Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }
}
