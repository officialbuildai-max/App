package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzbch {
    private zzbci zza;
    private zzbci zzb;
    private zzbcj zzc;
    private String zzd;
    private boolean zze;

    private zzbch() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbch(zzbcg zzbcgVar) {
    }

    public final zzbch zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzbch zzb(zzbci zzbciVar) {
        this.zza = zzbciVar;
        return this;
    }

    public final zzbch zzc(zzbci zzbciVar) {
        this.zzb = zzbciVar;
        return this;
    }

    public final zzbch zzd(boolean z10) {
        this.zze = true;
        return this;
    }

    public final zzbch zze(zzbcj zzbcjVar) {
        this.zzc = zzbcjVar;
        return this;
    }

    public final zzbcl zzf() {
        return new zzbcl(this.zzc, this.zzd, this.zza, this.zzb, null, false, false, this.zze, null);
    }
}
