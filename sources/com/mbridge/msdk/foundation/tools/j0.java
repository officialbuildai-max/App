package com.mbridge.msdk.foundation.tools;

import android.os.SystemClock;

/* loaded from: classes5.dex */
public final class j0 {
    public static final long a() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            if (currentTimeMillis > 0) {
                return (currentTimeMillis / 10) * 10;
            }
        } catch (Exception unused) {
        }
        return 0L;
    }
}
