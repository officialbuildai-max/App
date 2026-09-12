package com.google.android.libraries.places.internal;

import java.util.Collection;

/* loaded from: classes4.dex */
final class zzbka implements Runnable {
    final /* synthetic */ zzbkb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbka(zzbkb zzbkbVar) {
        this.zza = zzbkbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Collection collection;
        zzazf zzazfVar;
        Collection collection2;
        zzbkb zzbkbVar = this.zza;
        collection = zzbkbVar.zzc.zzr;
        collection.remove(zzbkbVar.zza);
        zzazfVar = this.zza.zzc.zzv;
        if (zzazfVar.zza() == zzaze.SHUTDOWN) {
            collection2 = this.zza.zzc.zzr;
            if (collection2.isEmpty()) {
                zzbkd.zzB(this.zza.zzc);
            }
        }
    }
}
