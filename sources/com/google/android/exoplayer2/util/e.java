package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f27621a = new i0();

    void a();

    o createHandler(Looper looper, Handler.Callback callback);

    long elapsedRealtime();

    long uptimeMillis();
}
