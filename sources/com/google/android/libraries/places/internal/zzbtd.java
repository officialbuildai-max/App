package com.google.android.libraries.places.internal;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzbtd {
    private final String[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbtd(zzbtb zzbtbVar, zzbtc zzbtcVar) {
        List list;
        List list2;
        list = zzbtbVar.zza;
        list2 = zzbtbVar.zza;
        this.zza = (String[]) list.toArray(new String[list2.size()]);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int zza = zza();
        for (int i11 = 0; i11 < zza; i11++) {
            sb2.append(zzb(i11));
            sb2.append(": ");
            sb2.append(zzc(i11));
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public final int zza() {
        return this.zza.length >> 1;
    }

    public final String zzb(int i11) {
        int i12 = i11 + i11;
        if (i12 < 0) {
            return null;
        }
        String[] strArr = this.zza;
        if (i12 >= strArr.length) {
            return null;
        }
        return strArr[i12];
    }

    public final String zzc(int i11) {
        int i12 = i11 + i11 + 1;
        if (i12 < 0) {
            return null;
        }
        String[] strArr = this.zza;
        if (i12 >= strArr.length) {
            return null;
        }
        return strArr[i12];
    }
}
