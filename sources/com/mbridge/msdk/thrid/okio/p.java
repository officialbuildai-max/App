package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    static o f38525a;

    /* renamed from: b, reason: collision with root package name */
    static long f38526b;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        synchronized (p.class) {
            try {
                o oVar = f38525a;
                if (oVar == null) {
                    return new o();
                }
                f38525a = oVar.f38523f;
                oVar.f38523f = null;
                f38526b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return oVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(o oVar) {
        if (oVar.f38523f != null || oVar.f38524g != null) {
            throw new IllegalArgumentException();
        }
        if (oVar.f38521d) {
            return;
        }
        synchronized (p.class) {
            try {
                long j11 = f38526b + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j11 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f38526b = j11;
                oVar.f38523f = f38525a;
                oVar.f38520c = 0;
                oVar.f38519b = 0;
                f38525a = oVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
