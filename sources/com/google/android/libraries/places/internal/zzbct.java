package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbct {
    private final List zza;
    private final zzaye zzb;
    private final zzbcp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbct(List list, zzaye zzayeVar, zzbcp zzbcpVar) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        zzmt.zzc(zzayeVar, "attributes");
        this.zzb = zzayeVar;
        this.zzc = zzbcpVar;
    }

    public static zzbcs zzc() {
        return new zzbcs();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbct)) {
            return false;
        }
        zzbct zzbctVar = (zzbct) obj;
        return zzmo.zza(this.zza, zzbctVar.zza) && zzmo.zza(this.zzb, zzbctVar.zzb) && zzmo.zza(this.zzc, zzbctVar.zzc);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("addresses", this.zza);
        zzb.zzd("attributes", this.zzb);
        zzb.zzd("serviceConfig", this.zzc);
        return zzb.toString();
    }

    public final zzaye zza() {
        return this.zzb;
    }

    public final zzbcp zzb() {
        return this.zzc;
    }

    public final zzbcs zzd() {
        zzbcs zzbcsVar = new zzbcs();
        zzbcsVar.zza(this.zza);
        zzbcsVar.zzb(this.zzb);
        zzbcsVar.zzc(this.zzc);
        return zzbcsVar;
    }

    public final List zze() {
        return this.zza;
    }
}
