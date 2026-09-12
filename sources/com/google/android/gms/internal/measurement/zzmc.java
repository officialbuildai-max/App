package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzmc implements Iterator {
    private int zza;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzlv zzd;

    private zzmc(zzlv zzlvVar) {
        this.zzd = zzlvVar;
        this.zza = -1;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzc == null) {
            map = this.zzd.zzc;
            this.zzc = map.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i11;
        Map map;
        int i12 = this.zza + 1;
        i11 = this.zzd.zzb;
        if (i12 >= i11) {
            map = this.zzd.zzc;
            if (map.isEmpty() || !zza().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        int i11;
        Object[] objArr;
        this.zzb = true;
        int i12 = this.zza + 1;
        this.zza = i12;
        i11 = this.zzd.zzb;
        if (i12 >= i11) {
            return (Map.Entry) zza().next();
        }
        objArr = this.zzd.zza;
        return (zzlz) objArr[this.zza];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i11;
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzg();
        int i12 = this.zza;
        i11 = this.zzd.zzb;
        if (i12 >= i11) {
            zza().remove();
            return;
        }
        zzlv zzlvVar = this.zzd;
        int i13 = this.zza;
        this.zza = i13 - 1;
        zzlvVar.zzb(i13);
    }
}
