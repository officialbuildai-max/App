package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbfk extends zzbgi {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzbfo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbfk(com.google.android.libraries.places.internal.zzbfo r1, com.google.android.libraries.places.internal.zzbvq r2, com.google.android.libraries.places.internal.zzbcf r3) {
        /*
            r0 = this;
            r0.zza = r2
            r0.zzb = r3
            r0.zzc = r1
            com.google.android.libraries.places.internal.zzbfq r1 = r1.zza
            com.google.android.libraries.places.internal.zzazj r1 = com.google.android.libraries.places.internal.zzbfq.zzh(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfk.<init>(com.google.android.libraries.places.internal.zzbfo, com.google.android.libraries.places.internal.zzbvq, com.google.android.libraries.places.internal.zzbcf):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbgi
    public final void zza() {
        zzbdo zzbdoVar;
        zzayn zzaynVar;
        int i11 = zzbvr.zza;
        zzbfo zzbfoVar = this.zzc;
        zzbdoVar = zzbfoVar.zzc;
        if (zzbdoVar != null) {
            return;
        }
        try {
            zzaynVar = zzbfoVar.zzb;
            zzaynVar.zzb(this.zzb);
        } catch (Throwable th2) {
            zzbfo.zzc(this.zzc, zzbdo.zzb.zzf(th2).zzg("Failed to read headers"));
        }
    }
}
