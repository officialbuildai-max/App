package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbkt implements zzbfp {
    volatile zzbpn zza;
    final /* synthetic */ zzbma zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbkt(zzbma zzbmaVar, zzbks zzbksVar) {
        this.zzb = zzbmaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbfu zzc(zzbbf zzbbfVar) {
        zzbbk zzbbkVar;
        AtomicBoolean atomicBoolean;
        zzbhg zzbhgVar;
        zzbhg zzbhgVar2;
        zzbma zzbmaVar = this.zzb;
        zzbbkVar = zzbmaVar.zzH;
        atomicBoolean = zzbmaVar.zzP;
        if (!atomicBoolean.get()) {
            if (zzbbkVar == null) {
                zzbma zzbmaVar2 = this.zzb;
                zzbkq zzbkqVar = new zzbkq(this);
                zzbdw zzbdwVar = zzbmaVar2.zzf;
                zzbdwVar.zzc(zzbkqVar);
                zzbdwVar.zzb();
                zzbhgVar2 = this.zzb.zzN;
                return zzbhgVar2;
            }
            zzbfu zzc = zzbjd.zzc(zzbbkVar.zza(zzbbfVar), zzbbfVar.zza().zzo());
            if (zzc != null) {
                return zzc;
            }
        }
        zzbhgVar = this.zzb.zzN;
        return zzbhgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbfp
    public final zzbfr zza(zzbcl zzbclVar, zzayj zzayjVar, zzbcf zzbcfVar, zzazj zzazjVar) {
        boolean z10;
        z10 = this.zzb.zzaf;
        if (z10) {
            zzbmg zzbmgVar = (zzbmg) zzayjVar.zzl(zzbmg.zza);
            return new zzbkr(this, zzbclVar, zzbcfVar, zzayjVar, zzbmgVar == null ? null : zzbmgVar.zzf, zzbmgVar != null ? zzbmgVar.zzg : null, zzazjVar);
        }
        zzbfu zzc = zzc(new zzbnr(zzbclVar, zzbcfVar, zzayjVar));
        zzazj zza = zzazjVar.zza();
        try {
            return zzc.zza(zzbclVar, zzbcfVar, zzayjVar, zzbjd.zzk(zzayjVar, zzbcfVar, 0, false));
        } finally {
            zzazjVar.zze(zza);
        }
    }
}
