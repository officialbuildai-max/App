package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* loaded from: classes4.dex */
final class zzf {
    private final zzjh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzjh zzjhVar) {
        this.zza = zzjhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzf zza(String str) {
        return new zzf((TextUtils.isEmpty(str) || str.length() > 1) ? zzjh.UNINITIALIZED : zzje.zza(str.charAt(0)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjh zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return String.valueOf(zzje.zza(this.zza));
    }
}
