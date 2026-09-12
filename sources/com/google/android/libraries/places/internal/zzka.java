package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public abstract class zzka {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract zzka zzb(int i11);

    abstract zzkb zzc();

    public abstract zzka zzd(int i11);

    public final zzkb zze() {
        zzkb zzc = zzc();
        zzmt.zzp(!zzc.zzb().isEmpty(), "Package name must not be empty.");
        return zzc;
    }
}
