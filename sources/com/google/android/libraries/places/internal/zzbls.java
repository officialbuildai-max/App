package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbls extends zzayk {
    final /* synthetic */ zzbma zza;
    private final AtomicReference zzb;
    private final String zzc;
    private final zzayk zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbls(zzbma zzbmaVar, String str, zzblr zzblrVar) {
        zzbam zzbamVar;
        this.zza = zzbmaVar;
        zzbamVar = zzbma.zzi;
        this.zzb = new AtomicReference(zzbamVar);
        this.zzd = new zzblk(this);
        this.zzc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzayo zzh(zzbcl zzbclVar, zzayj zzayjVar) {
        Executor executor;
        zzbam zzbamVar = (zzbam) this.zzb.get();
        if (zzbamVar == null) {
            return this.zzd.zza(zzbclVar, zzayjVar);
        }
        if (!(zzbamVar instanceof zzbmi)) {
            zzayk zzaykVar = this.zzd;
            executor = this.zza.zzt;
            return new zzbkv(zzbamVar, zzaykVar, executor, zzbclVar, zzayjVar);
        }
        zzbmg zzb = ((zzbmi) zzbamVar).zzb.zzb(zzbclVar);
        if (zzb != null) {
            zzayjVar = zzayjVar.zze(zzbmg.zza, zzb);
        }
        return this.zzd.zza(zzbclVar, zzayjVar);
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final zzayo zza(zzbcl zzbclVar, zzayj zzayjVar) {
        zzbam zzbamVar;
        zzbam zzbamVar2;
        AtomicBoolean atomicBoolean;
        Object obj = this.zzb.get();
        zzbamVar = zzbma.zzi;
        if (obj != zzbamVar) {
            return zzh(zzbclVar, zzayjVar);
        }
        zzbma zzbmaVar = this.zza;
        zzbll zzbllVar = new zzbll(this);
        zzbdw zzbdwVar = zzbmaVar.zzf;
        zzbdwVar.zzc(zzbllVar);
        zzbdwVar.zzb();
        Object obj2 = this.zzb.get();
        zzbamVar2 = zzbma.zzi;
        if (obj2 != zzbamVar2) {
            return zzh(zzbclVar, zzayjVar);
        }
        atomicBoolean = this.zza.zzP;
        if (atomicBoolean.get()) {
            return new zzblm(this);
        }
        zzblq zzblqVar = new zzblq(this, zzazj.zzb(), zzbclVar, zzayjVar);
        zzbma zzbmaVar2 = this.zza;
        zzbln zzblnVar = new zzbln(this, zzblqVar);
        zzbdw zzbdwVar2 = zzbmaVar2.zzf;
        zzbdwVar2.zzc(zzblnVar);
        zzbdwVar2.zzb();
        return zzblqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final String zzb() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf() {
        zzbam zzbamVar;
        Object obj = this.zzb.get();
        zzbamVar = zzbma.zzi;
        if (obj == zzbamVar) {
            zzg(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(zzbam zzbamVar) {
        zzbam zzbamVar2;
        Collection collection;
        Collection collection2;
        zzbam zzbamVar3 = (zzbam) this.zzb.get();
        this.zzb.set(zzbamVar);
        zzbamVar2 = zzbma.zzi;
        if (zzbamVar3 == zzbamVar2) {
            zzbma zzbmaVar = this.zza;
            collection = zzbmaVar.zzK;
            if (collection != null) {
                collection2 = zzbmaVar.zzK;
                Iterator it = collection2.iterator();
                while (it.hasNext()) {
                    ((zzblq) it.next()).zzl();
                }
            }
        }
    }
}
