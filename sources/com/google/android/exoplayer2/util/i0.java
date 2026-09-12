package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public class i0 implements e {
    @Override // com.google.android.exoplayer2.util.e
    public void a() {
    }

    @Override // com.google.android.exoplayer2.util.e
    public o createHandler(Looper looper, Handler.Callback callback) {
        return new j0(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.e
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.e
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
