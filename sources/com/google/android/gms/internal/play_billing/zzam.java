package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;

/* loaded from: classes4.dex */
final class zzam extends zzaf {
    final /* synthetic */ zzan zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i11) {
        int i12;
        Object[] objArr;
        Object[] objArr2;
        i12 = this.zza.zzc;
        zzx.zza(i11, i12, "index");
        zzan zzanVar = this.zza;
        objArr = zzanVar.zzb;
        int i13 = i11 + i11;
        Object obj = objArr[i13];
        obj.getClass();
        objArr2 = zzanVar.zzb;
        Object obj2 = objArr2[i13 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i11;
        i11 = this.zza.zzc;
        return i11;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public final boolean zzf() {
        return true;
    }
}
