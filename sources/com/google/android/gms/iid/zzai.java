package com.google.android.gms.iid;

/* loaded from: classes3.dex */
public abstract class zzai {
    private static zzai zzdd;

    public static synchronized zzai zzy() {
        zzai zzaiVar;
        synchronized (zzai.class) {
            try {
                if (zzdd == null) {
                    zzdd = new zzac();
                }
                zzaiVar = zzdd;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzaiVar;
    }

    public abstract zzaj<Boolean> zzd(String str, boolean z10);
}
