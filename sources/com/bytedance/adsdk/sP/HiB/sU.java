package com.bytedance.adsdk.sP.HiB;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class sU {
    private static final Interpolator Sj = new LinearInterpolator();
    private static SparseArray<WeakReference<Interpolator>> sP;

    sU() {
    }

    private static SparseArray<WeakReference<Interpolator>> Sj() {
        if (sP == null) {
            sP = new SparseArray<>();
        }
        return sP;
    }

    private static Interpolator Sj(PointF pointF, PointF pointF2) {
        Interpolator Sj2;
        pointF.x = com.bytedance.adsdk.sP.vS.HiB.sP(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.sP.vS.HiB.sP(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.sP.vS.HiB.sP(pointF2.x, -1.0f, 1.0f);
        float sP2 = com.bytedance.adsdk.sP.vS.HiB.sP(pointF2.y, -100.0f, 100.0f);
        pointF2.y = sP2;
        int Sj3 = com.bytedance.adsdk.sP.vS.vS.Sj(pointF.x, pointF.y, pointF2.x, sP2);
        WeakReference<Interpolator> Sj4 = com.bytedance.adsdk.sP.HiB.Sj() ? null : Sj(Sj3);
        Interpolator interpolator = Sj4 != null ? Sj4.get() : null;
        if (Sj4 == null || interpolator == null) {
            try {
                Sj2 = com.bytedance.adsdk.sP.dNu.Sj(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e11) {
                Sj2 = "The Path cannot loop back on itself.".equals(e11.getMessage()) ? com.bytedance.adsdk.sP.dNu.Sj(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = Sj2;
            if (!com.bytedance.adsdk.sP.HiB.Sj()) {
                try {
                    Sj(Sj3, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.sP.Jcg.Sj<T> Sj(JsonReader jsonReader, float f11, Ei<T> ei2) throws IOException {
        return new com.bytedance.adsdk.sP.Jcg.Sj<>(ei2.sP(jsonReader, f11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.bytedance.adsdk.sP.Jcg.Sj<T> Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg, float f11, Ei<T> ei2, boolean z10, boolean z11) throws IOException {
        return (z10 && z11) ? sP(jcg, jsonReader, f11, ei2) : z10 ? Sj(jcg, jsonReader, f11, ei2) : Sj(jsonReader, f11, ei2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0086 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> com.bytedance.adsdk.sP.Jcg.Sj<T> Sj(com.bytedance.adsdk.sP.Jcg r17, android.util.JsonReader r18, float r19, com.bytedance.adsdk.sP.HiB.Ei<T> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.sU.Sj(com.bytedance.adsdk.sP.Jcg, android.util.JsonReader, float, com.bytedance.adsdk.sP.HiB.Ei):com.bytedance.adsdk.sP.Jcg.Sj");
    }

    private static WeakReference<Interpolator> Sj(int i11) {
        WeakReference<Interpolator> weakReference;
        synchronized (sU.class) {
            weakReference = Sj().get(i11);
        }
        return weakReference;
    }

    private static void Sj(int i11, WeakReference<Interpolator> weakReference) {
        synchronized (sU.class) {
            sP.put(i11, weakReference);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x00a6. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02b2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> com.bytedance.adsdk.sP.Jcg.Sj<T> sP(com.bytedance.adsdk.sP.Jcg r26, android.util.JsonReader r27, float r28, com.bytedance.adsdk.sP.HiB.Ei<T> r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.sU.sP(com.bytedance.adsdk.sP.Jcg, android.util.JsonReader, float, com.bytedance.adsdk.sP.HiB.Ei):com.bytedance.adsdk.sP.Jcg.Sj");
    }
}
