package com.google.android.libraries.places.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzki {
    private final Context zza;

    public zzki(Context context) {
        zzmt.zzc(context, "Context must not be null.");
        this.zza = context;
    }

    public final zzoa zza() {
        Context context = this.zza;
        String packageName = context.getPackageName();
        String zza = zzju.zza(context.getPackageManager(), packageName);
        zznz zznzVar = new zznz();
        if (packageName != null) {
            zznzVar.zza("X-Android-Package", packageName);
        }
        if (zza != null) {
            zznzVar.zza("X-Android-Cert", zza);
        }
        return zznzVar.zzc();
    }
}
