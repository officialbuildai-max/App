package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbfn extends zzbgi {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbfo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbfn(com.google.android.libraries.places.internal.zzbfo r1, com.google.android.libraries.places.internal.zzbvq r2) {
        /*
            r0 = this;
            r0.zza = r2
            r0.zzb = r1
            com.google.android.libraries.places.internal.zzbfq r1 = r1.zza
            com.google.android.libraries.places.internal.zzazj r1 = com.google.android.libraries.places.internal.zzbfq.zzh(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfn.<init>(com.google.android.libraries.places.internal.zzbfo, com.google.android.libraries.places.internal.zzbvq):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbgi
    public final void zza() {
        zzbdo zzbdoVar;
        zzayn zzaynVar;
        int i11 = zzbvr.zza;
        zzbfo zzbfoVar = this.zzb;
        zzbdoVar = zzbfoVar.zzc;
        if (zzbdoVar != null) {
            return;
        }
        try {
            zzaynVar = zzbfoVar.zzb;
            zzaynVar.zzd();
        } catch (Throwable th2) {
            zzbfo.zzc(this.zzb, zzbdo.zzb.zzf(th2).zzg("Failed to call onReady."));
        }
    }
}
