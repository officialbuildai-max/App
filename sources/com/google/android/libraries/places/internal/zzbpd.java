package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbpd {
    final boolean zza;
    final List zzb;
    final Collection zzc;
    final Collection zzd;
    final int zze;
    final zzbpm zzf;
    final boolean zzg;
    final boolean zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpd(List list, Collection collection, Collection collection2, zzbpm zzbpmVar, boolean z10, boolean z11, boolean z12, int i11) {
        this.zzb = list;
        zzmt.zzc(collection, "drainedSubstreams");
        this.zzc = collection;
        this.zzf = zzbpmVar;
        this.zzd = collection2;
        this.zzg = z10;
        this.zza = z11;
        this.zzh = z12;
        this.zze = i11;
        zzmt.zzp(!z11 || list == null, "passThrough should imply buffer is null");
        zzmt.zzp((z11 && zzbpmVar == null) ? false : true, "passThrough should imply winningSubstream != null");
        zzmt.zzp(!z11 || (collection.size() == 1 && collection.contains(zzbpmVar)) || (collection.size() == 0 && zzbpmVar.zzb), "passThrough should imply winningSubstream is drained");
        zzmt.zzp((z10 && zzbpmVar == null) ? false : true, "cancelled should imply committed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbpd zza(zzbpm zzbpmVar) {
        Collection unmodifiableCollection;
        zzmt.zzp(!this.zzh, "hedging frozen");
        zzmt.zzp(this.zzf == null, "already committed");
        Collection collection = this.zzd;
        if (collection == null) {
            unmodifiableCollection = Collections.singleton(zzbpmVar);
        } else {
            ArrayList arrayList = new ArrayList(collection);
            arrayList.add(zzbpmVar);
            unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        return new zzbpd(this.zzb, this.zzc, unmodifiableCollection, this.zzf, this.zzg, this.zza, this.zzh, this.zze + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbpd zzb() {
        return this.zzh ? this : new zzbpd(this.zzb, this.zzc, this.zzd, this.zzf, this.zzg, this.zza, true, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbpd zzc(zzbpm zzbpmVar) {
        Collection unmodifiableCollection;
        zzmt.zzp(!this.zza, "Already passThrough");
        if (zzbpmVar.zzb) {
            unmodifiableCollection = this.zzc;
        } else if (this.zzc.isEmpty()) {
            unmodifiableCollection = Collections.singletonList(zzbpmVar);
        } else {
            ArrayList arrayList = new ArrayList(this.zzc);
            arrayList.add(zzbpmVar);
            unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        Collection collection = unmodifiableCollection;
        zzbpm zzbpmVar2 = this.zzf;
        boolean z10 = zzbpmVar2 != null;
        List list = this.zzb;
        if (z10) {
            zzmt.zzp(zzbpmVar2 == zzbpmVar, "Another RPC attempt has already committed");
            list = null;
        }
        return new zzbpd(list, collection, this.zzd, this.zzf, this.zzg, z10, this.zzh, this.zze);
    }
}
