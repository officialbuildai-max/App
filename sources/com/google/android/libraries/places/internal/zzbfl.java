package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* loaded from: classes4.dex */
final class zzbfl extends zzbgi {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbqq zzb;
    final /* synthetic */ zzbfo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbfl(com.google.android.libraries.places.internal.zzbfo r1, com.google.android.libraries.places.internal.zzbvq r2, com.google.android.libraries.places.internal.zzbqq r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfl.<init>(com.google.android.libraries.places.internal.zzbfo, com.google.android.libraries.places.internal.zzbvq, com.google.android.libraries.places.internal.zzbqq):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbgi
    public final void zza() {
        zzbdo zzbdoVar;
        zzayn zzaynVar;
        zzbcl zzbclVar;
        int i11 = zzbvr.zza;
        zzbdoVar = this.zzc.zzc;
        if (zzbdoVar != null) {
            zzbjd.zzh(this.zzb);
            return;
        }
        while (true) {
            try {
                InputStream zza = this.zzb.zza();
                if (zza == null) {
                    return;
                }
                try {
                    zzbfo zzbfoVar = this.zzc;
                    zzaynVar = zzbfoVar.zzb;
                    zzbclVar = zzbfoVar.zza.zzd;
                    zzaynVar.zzc(zzbclVar.zzd(zza));
                    zza.close();
                } finally {
                }
            } catch (Throwable th2) {
                zzbjd.zzh(this.zzb);
                zzbfo.zzc(this.zzc, zzbdo.zzb.zzf(th2).zzg("Failed to read message."));
                return;
            }
        }
    }
}
