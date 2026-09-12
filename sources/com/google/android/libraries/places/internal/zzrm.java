package com.google.android.libraries.places.internal;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzrm extends AbstractSet {
    final int zza = -1;
    final /* synthetic */ zzrn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrm(zzrn zzrnVar, int i11) {
        this.zzb = zzrnVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr;
        int i11 = this.zza;
        objArr = this.zzb.zzb;
        return Arrays.binarySearch(objArr, zzb(), zza(), obj, i11 == -1 ? zzrn.zza : zzrp.zza) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzrl(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza() - zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        int[] iArr;
        int i11 = this.zza;
        iArr = this.zzb.zzc;
        return iArr[i11 + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb() {
        int[] iArr;
        if (this.zza == -1) {
            return 0;
        }
        iArr = this.zzb.zzc;
        return iArr[0];
    }
}
