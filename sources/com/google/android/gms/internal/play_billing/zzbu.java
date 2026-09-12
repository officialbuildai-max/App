package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class zzbu {
    private static final zzbw zza;

    static {
        String[] strArr;
        strArr = zzbw.zzd;
        zza = zzb(strArr);
    }

    public static /* bridge */ /* synthetic */ zzbw zza() {
        return zza;
    }

    private static zzbw zzb(String[] strArr) {
        zzbw zzbwVar;
        try {
            zzbwVar = zzbx.zza();
        } catch (NoClassDefFoundError unused) {
            zzbwVar = null;
        }
        if (zzbwVar != null) {
            return zzbwVar;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzbw) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th2) {
                th = th2;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb2.append('\n');
                sb2.append(str);
                sb2.append(": ");
                sb2.append(th);
            }
        }
        throw new IllegalStateException(sb2.insert(0, "No logging platforms found:").toString());
    }
}
