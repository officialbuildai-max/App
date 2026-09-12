package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgv implements Iterator {
    final /* synthetic */ zzgz zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgv(zzgz zzgzVar, zzgu zzguVar) {
        this.zza = zzgzVar;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i11 = this.zzb + 1;
        list = this.zza.zzb;
        if (i11 < list.size()) {
            return true;
        }
        map = this.zza.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        List list;
        List list2;
        this.zzc = true;
        int i11 = this.zzb + 1;
        this.zzb = i11;
        list = this.zza.zzb;
        if (i11 >= list.size()) {
            return (Map.Entry) zza().next();
        }
        list2 = this.zza.zzb;
        return (Map.Entry) list2.get(this.zzb);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        int i11 = this.zzb;
        list = this.zza.zzb;
        if (i11 >= list.size()) {
            zza().remove();
            return;
        }
        zzgz zzgzVar = this.zza;
        int i12 = this.zzb;
        this.zzb = i12 - 1;
        zzgzVar.zzl(i12);
    }
}
