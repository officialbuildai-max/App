package com.google.android.libraries.places.internal;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class zznp implements Comparable, Serializable {
    final Comparable zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznp(Comparable comparable) {
        this.zza = comparable;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zznp) {
            try {
                if (compareTo((zznp) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public int compareTo(zznp zznpVar) {
        zznn zznnVar;
        zznl zznlVar;
        zznnVar = zznn.zzb;
        if (zznpVar != zznnVar) {
            zznlVar = zznl.zzb;
            if (zznpVar == zznlVar) {
                return -1;
            }
            Comparable comparable = this.zza;
            Comparable comparable2 = zznpVar.zza;
            int i11 = zzok.zzc;
            int compareTo = comparable.compareTo(comparable2);
            if (compareTo != 0) {
                return compareTo;
            }
            boolean z10 = this instanceof zznm;
            if (z10 == (zznpVar instanceof zznm)) {
                return 0;
            }
            if (!z10) {
                return -1;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(StringBuilder sb2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzd(StringBuilder sb2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zze(Comparable comparable);
}
