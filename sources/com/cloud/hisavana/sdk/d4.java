package com.cloud.hisavana.sdk;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class d4 {

    /* renamed from: a, reason: collision with root package name */
    public static final d4 f22454a = new d4();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f22455b;

    private d4() {
    }

    public final m4 a(Context context) {
        Intrinsics.h(context, "context");
        if (!b()) {
            e4.b().d("VideoPlayerFactory", "creating NoOpVideoPlayer (ExoPlayer unavailable)");
            return new n();
        }
        try {
            e4.b().d("VideoPlayerFactory", "creating ExoPlayerImpl");
            return new t3(context);
        } catch (Throwable th2) {
            e4.b().w("VideoPlayerFactory", "ExoPlayerImpl init failed, degrading to NoOp: " + th2.getMessage());
            return new n();
        }
    }

    public final boolean b() {
        boolean z10;
        boolean z11 = true;
        if (a7.c.k()) {
            return true;
        }
        Boolean bool = f22455b;
        if (bool != null) {
            return bool.booleanValue();
        }
        synchronized (this) {
            Boolean bool2 = f22455b;
            if (bool2 != null) {
                z10 = bool2.booleanValue();
            } else {
                try {
                    e4.b().d("VideoPlayerFactory", "ExoPlayer is found");
                } catch (ClassNotFoundException unused) {
                    e4.b().d("VideoPlayerFactory", "ExoPlayer not found, video ads will be degraded gracefully");
                    z11 = false;
                    f22455b = Boolean.valueOf(z11);
                    z10 = z11;
                    return z10;
                } catch (Throwable th2) {
                    e4.b().w("VideoPlayerFactory", "ExoPlayer probe failed: " + th2.getMessage());
                    z11 = false;
                    f22455b = Boolean.valueOf(z11);
                    z10 = z11;
                    return z10;
                }
                f22455b = Boolean.valueOf(z11);
                z10 = z11;
            }
        }
        return z10;
    }
}
