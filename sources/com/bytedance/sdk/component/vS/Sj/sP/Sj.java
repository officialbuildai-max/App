package com.bytedance.sdk.component.vS.Sj.sP;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import com.bytedance.sdk.component.vS.Sj.Sj.HiB;

/* loaded from: classes2.dex */
public class Sj {
    public static boolean EjP() {
        HiB EjP = Dq.Jcg().EjP();
        return (EjP == null || TextUtils.isEmpty(EjP.HiB())) ? false : true;
    }

    public static boolean HiB() {
        HiB EjP = Dq.Jcg().EjP();
        return (EjP == null || TextUtils.isEmpty(EjP.TKC())) ? false : true;
    }

    public static long Sj(int i11, Context context) {
        return sP(i11, context);
    }

    public static boolean Sj() {
        HiB EjP = Dq.Jcg().EjP();
        return (EjP == null || TextUtils.isEmpty(EjP.Sj())) ? false : true;
    }

    public static boolean TKC() {
        HiB EjP = Dq.Jcg().EjP();
        return (EjP == null || TextUtils.isEmpty(EjP.EjP())) ? false : true;
    }

    private static long sP(int i11, Context context) {
        if (context == null) {
            return i11;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long maxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (maxMemory <= 0) {
            if (freeMemory <= 2) {
                return 1L;
            }
            return freeMemory <= 10 ? Math.min(i11, 10) : Math.min((freeMemory / 2) * 10, i11);
        }
        long j11 = ((freeMemory + maxMemory) - 10) / 2;
        if (j11 <= 2) {
            return 1L;
        }
        return j11 <= 10 ? Math.min(i11, 10) : Math.min(j11 * 10, i11);
    }

    public static boolean sP() {
        HiB EjP = Dq.Jcg().EjP();
        return (EjP == null || TextUtils.isEmpty(EjP.sP())) ? false : true;
    }

    public static boolean vS() {
        HiB EjP = Dq.Jcg().EjP();
        return (EjP == null || TextUtils.isEmpty(EjP.vS())) ? false : true;
    }
}
