package com.google.android.gms.internal.measurement;

import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public final class zzgl {

    @Nullable
    private static zzgk zza;

    public static synchronized zzgk zza() {
        zzgk zzgkVar;
        synchronized (zzgl.class) {
            try {
                if (zza == null) {
                    zza(new zzgn());
                }
                zzgkVar = zza;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzgkVar;
    }

    private static synchronized void zza(zzgk zzgkVar) {
        synchronized (zzgl.class) {
            if (zza != null) {
                throw new IllegalStateException("init() already called");
            }
            zza = zzgkVar;
        }
    }
}
