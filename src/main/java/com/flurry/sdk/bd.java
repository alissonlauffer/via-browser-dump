package com.flurry.sdk;

public enum bd {
    INSTALL(1),
    SESSION_START(2),
    SESSION_END(3),
    APPLICATION_EVENT(4);
    
    final int e;

    private bd(int i) {
        this.e = i;
    }

    public static bd a(int i) {
        if (i == 1) {
            return INSTALL;
        }
        if (i == 2) {
            return SESSION_START;
        }
        if (i == 3) {
            return SESSION_END;
        }
        if (i != 4) {
            return null;
        }
        return APPLICATION_EVENT;
    }
}
