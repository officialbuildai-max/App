package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class zzbip implements zzbgf {
    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", zzb());
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbfu
    public zzbfr zza(zzbcl zzbclVar, zzbcf zzbcfVar, zzayj zzayjVar, zzayx[] zzayxVarArr) {
        throw null;
    }

    protected abstract zzbgf zzb();

    @Override // com.google.android.libraries.places.internal.zzbau
    public final zzbap zzc() {
        return zzb().zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzbml
    public void zzd(zzbdo zzbdoVar) {
        zzb().zzd(zzbdoVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbgf
    public final zzaye zze() {
        return zzb().zze();
    }

    @Override // com.google.android.libraries.places.internal.zzbml
    public final Runnable zzj(zzbmk zzbmkVar) {
        zzb().zzj(zzbmkVar);
        return null;
    }
}
