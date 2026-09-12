package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbor implements zzbov {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbpo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbor(zzbpo zzbpoVar, Object obj) {
        this.zza = obj;
        this.zzb = zzbpoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbov
    public final void zza(zzbpm zzbpmVar) {
        zzbcl zzbclVar;
        zzbpo zzbpoVar = this.zzb;
        zzbfr zzbfrVar = zzbpmVar.zza;
        zzbclVar = zzbpoVar.zzc;
        zzbfrVar.zzw(zzbclVar.zzc(this.zza));
        zzbpmVar.zza.zzr();
    }
}
