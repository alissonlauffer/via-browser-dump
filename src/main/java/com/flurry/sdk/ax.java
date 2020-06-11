package com.flurry.sdk;

public enum ax {
    COMPLETE(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    PENDING_COMPLETION(4);
    
    int e;

    private ax(int i) {
        this.e = i;
    }

    public static ax a(int i) {
        if (i == 1) {
            return COMPLETE;
        }
        if (i == 2) {
            return TIMEOUT;
        }
        if (i == 3) {
            return INVALID_RESPONSE;
        }
        if (i != 4) {
            return null;
        }
        return PENDING_COMPLETION;
    }
}
