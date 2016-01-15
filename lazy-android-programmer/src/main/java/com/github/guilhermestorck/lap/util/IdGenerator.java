package com.github.guilhermestorck.lap.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gstorck on 13/01/2016.
 */
public class IdGenerator {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

}
