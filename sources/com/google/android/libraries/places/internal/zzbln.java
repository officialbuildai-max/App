package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzbln implements Runnable {
    final /* synthetic */ zzblq zza;
    final /* synthetic */ zzbls zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbln(zzbls zzblsVar, zzblq zzblqVar) {
        this.zza = zzblqVar;
        this.zzb = zzblsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzbam zzbamVar;
        Collection collection;
        Collection collection2;
        Object obj;
        atomicReference = this.zzb.zzb;
        Object obj2 = atomicReference.get();
        zzbamVar = zzbma.zzi;
        if (obj2 != zzbamVar) {
            this.zza.zzl();
            return;
        }
        zzbls zzblsVar = this.zzb;
        collection = zzblsVar.zza.zzK;
        if (collection == null) {
            zzblsVar.zza.zzK = new LinkedHashSet();
            zzbma zzbmaVar = this.zzb.zza;
            zzbji zzbjiVar = zzbmaVar.zzg;
            obj = zzbmaVar.zzL;
            zzbjiVar.zzc(obj, true);
        }
        zzbls zzblsVar2 = this.zzb;
        zzblq zzblqVar = this.zza;
        collection2 = zzblsVar2.zza.zzK;
        collection2.add(zzblqVar);
    }
}
