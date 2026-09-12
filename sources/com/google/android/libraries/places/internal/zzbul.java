package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzbul {
    private final zzbui zza;
    private final zzbtd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbul(zzbuj zzbujVar, zzbuk zzbukVar) {
        zzbui zzbuiVar;
        zzbtb zzbtbVar;
        zzbuiVar = zzbujVar.zza;
        this.zza = zzbuiVar;
        zzbtbVar = zzbujVar.zzb;
        this.zzb = zzbtbVar.zzb();
    }

    public final String toString() {
        return "Request{url=" + String.valueOf(this.zza) + "}";
    }

    public final zzbtd zza() {
        return this.zzb;
    }

    public final zzbui zzb() {
        return this.zza;
    }
}
