package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblp implements Runnable {
    final /* synthetic */ zzblq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblp(zzblq zzblqVar) {
        this.zza = zzblqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Collection collection;
        Collection collection2;
        Collection collection3;
        Object obj;
        AtomicBoolean atomicBoolean;
        zzblz zzblzVar;
        zzbhg zzbhgVar;
        zzblq zzblqVar = this.zza;
        zzbma zzbmaVar = zzblqVar.zzd.zza;
        collection = zzbmaVar.zzK;
        if (collection != null) {
            collection2 = zzbmaVar.zzK;
            collection2.remove(zzblqVar);
            collection3 = this.zza.zzd.zza.zzK;
            if (collection3.isEmpty()) {
                zzbma zzbmaVar2 = this.zza.zzd.zza;
                zzbji zzbjiVar = zzbmaVar2.zzg;
                obj = zzbmaVar2.zzL;
                zzbjiVar.zzc(obj, false);
                this.zza.zzd.zza.zzK = null;
                atomicBoolean = this.zza.zzd.zza.zzP;
                if (atomicBoolean.get()) {
                    zzblzVar = this.zza.zzd.zza.zzO;
                    Object obj2 = zzblzVar.zza;
                    zzbdo zzbdoVar = zzbma.zzd;
                    synchronized (obj2) {
                        try {
                            if (zzblzVar.zzc != null) {
                                return;
                            }
                            zzblzVar.zzc = zzbdoVar;
                            boolean isEmpty = zzblzVar.zzb.isEmpty();
                            if (isEmpty) {
                                zzbhgVar = zzblzVar.zzd.zzN;
                                zzbhgVar.zzd(zzbdoVar);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }
        }
    }
}
