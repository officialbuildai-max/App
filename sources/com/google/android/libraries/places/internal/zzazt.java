package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public abstract class zzazt extends zzbbs {
    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", zzb());
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbbs
    public final zzbbr zza() {
        return zzb().zza();
    }

    protected abstract zzbbs zzb();
}
