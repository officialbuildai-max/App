package com.google.android.libraries.places.internal;

import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzon extends zznx {
    final /* synthetic */ zzoo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(zzoo zzooVar) {
        this.zza = zzooVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i11) {
        int i12;
        Object[] objArr;
        Object[] objArr2;
        i12 = this.zza.zzc;
        zzmt.zza(i11, i12, "index");
        objArr = this.zza.zzb;
        int i13 = i11 + i11;
        Object obj = objArr[i13];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.zzb;
        Object obj2 = objArr2[i13 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i11;
        i11 = this.zza.zzc;
        return i11;
    }

    @Override // com.google.android.libraries.places.internal.zznt
    public final boolean zzf() {
        return true;
    }
}
