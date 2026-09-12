package com.google.android.libraries.places.internal;

import java.util.Collection;

/* loaded from: classes4.dex */
public final class zzbhf extends zzbhy {
    final /* synthetic */ zzbhg zza;
    private final zzbbf zzb;
    private final zzazj zzc = zzazj.zzb();
    private final zzayx[] zzd;

    public /* synthetic */ zzbhf(zzbhg zzbhgVar, zzbbf zzbbfVar, zzayx[] zzayxVarArr, zzbhe zzbheVar) {
        this.zza = zzbhgVar;
        this.zzb = zzbbfVar;
        this.zzd = zzayxVarArr;
    }

    public static /* bridge */ /* synthetic */ Runnable zzb(zzbhf zzbhfVar, zzbfu zzbfuVar) {
        zzazj zza = zzbhfVar.zzc.zza();
        try {
            zzbbf zzbbfVar = zzbhfVar.zzb;
            zzbfr zza2 = zzbfuVar.zza(zzbbfVar.zzc(), zzbbfVar.zzb(), zzbbfVar.zza(), zzbhfVar.zzd);
            zzbhfVar.zzc.zze(zza);
            return zzbhfVar.zze(zza2);
        } catch (Throwable th2) {
            zzbhfVar.zzc.zze(zza);
            throw th2;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbhy
    protected final void zzc(zzbdo zzbdoVar) {
        int i11 = 0;
        while (true) {
            zzayx[] zzayxVarArr = this.zzd;
            if (i11 >= zzayxVarArr.length) {
                return;
            }
            zzayx zzayxVar = zzayxVarArr[i11];
            i11++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbhy, com.google.android.libraries.places.internal.zzbfr
    public final void zzg(zzbjj zzbjjVar) {
        if (this.zzb.zza().zzo()) {
            zzbjjVar.zza("wait_for_ready");
        }
        super.zzg(zzbjjVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbhy, com.google.android.libraries.places.internal.zzbfr
    public final void zzh(zzbdo zzbdoVar) {
        Object obj;
        Runnable runnable;
        zzbdw zzbdwVar;
        Collection collection;
        zzbdw zzbdwVar2;
        Runnable runnable2;
        zzbdo zzbdoVar2;
        zzbdw zzbdwVar3;
        Runnable runnable3;
        super.zzh(zzbdoVar);
        obj = this.zza.zzb;
        synchronized (obj) {
            try {
                zzbhg zzbhgVar = this.zza;
                runnable = zzbhgVar.zzg;
                if (runnable != null) {
                    collection = zzbhgVar.zzi;
                    boolean remove = collection.remove(this);
                    if (!this.zza.zzn() && remove) {
                        zzbhg zzbhgVar2 = this.zza;
                        zzbdwVar2 = zzbhgVar2.zzd;
                        runnable2 = zzbhgVar2.zzf;
                        zzbdwVar2.zzc(runnable2);
                        zzbhg zzbhgVar3 = this.zza;
                        zzbdoVar2 = zzbhgVar3.zzj;
                        if (zzbdoVar2 != null) {
                            zzbdwVar3 = zzbhgVar3.zzd;
                            runnable3 = zzbhgVar3.zzg;
                            zzbdwVar3.zzc(runnable3);
                            this.zza.zzg = null;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        zzbdwVar = this.zza.zzd;
        zzbdwVar.zzb();
    }
}
