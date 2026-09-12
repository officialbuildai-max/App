package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbba {
    private final List zza;
    private final zzaye zzb;
    private final Object[][] zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbba(List list, zzaye zzayeVar, Object[][] objArr, zzbaz zzbazVar) {
        zzmt.zzc(list, "addresses are not set");
        this.zza = list;
        zzmt.zzc(zzayeVar, "attrs");
        this.zzb = zzayeVar;
        zzmt.zzc(objArr, "customOptions");
        this.zzc = objArr;
    }

    public static zzbax zzb() {
        return new zzbax();
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("addrs", this.zza);
        zzb.zzd("attrs", this.zzb);
        zzb.zzd("customOptions", Arrays.deepToString(this.zzc));
        return zzb.toString();
    }

    public final zzaye zza() {
        return this.zzb;
    }

    public final List zzc() {
        return this.zza;
    }
}
